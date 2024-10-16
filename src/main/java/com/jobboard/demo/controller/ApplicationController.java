package com.jobboard.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobboard.demo.Model.Application;
import com.jobboard.demo.Model.Job;
import com.jobboard.demo.service.ApplicationService;

@RequestMapping("/applications")
@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService appService;

    @GetMapping("")
    public ResponseEntity<List<Application>> getAllApplications() {
        return ResponseEntity.ok(appService.getAllApplications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Application>> getApplicationById(@PathVariable("id") Long id) {
        Optional<Application> app = appService.getApplicationById(id);
        if (!app.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(app);
    }

    @PostMapping("")
    public ResponseEntity<Application> createApplication(@RequestBody Application app) {
        Application createdApp = appService.createApplication(app);
        return ResponseEntity.ok(createdApp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Application>> updateApplicationById(@PathVariable("id") Long id, @RequestBody Application app) {
        Optional<Application> retrievedApp = appService.getApplicationById(id);
        if (!retrievedApp.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(appService.updateApplication(id, app));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplicationById(@PathVariable("id") Long id){
        Boolean isDeleted = appService.deleteApplication(id);
        if (isDeleted){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.internalServerError().build();
    }

    
}
