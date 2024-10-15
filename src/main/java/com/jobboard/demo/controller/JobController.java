package com.jobboard.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobboard.demo.Model.Job;
import com.jobboard.demo.service.JobService;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping("")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Job>> getJobById(@PathVariable Long id) {
        System.out.println("Fetching job with ID: " + id);
        Optional<Job> job = jobService.getJobyById(id);

        // return ResponseEntity
        // .status(HttpStatus.OK)
        // .body(job);
        if (!job.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(job);
    }
}
