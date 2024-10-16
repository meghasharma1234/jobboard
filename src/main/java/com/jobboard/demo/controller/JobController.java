package com.jobboard.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.jobboard.demo.Model.Job;
import com.jobboard.demo.service.JobService;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping("")
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Job>> getJobById(@PathVariable("id") Long id) {
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

    @PostMapping("")
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        return ResponseEntity.ok(jobService.createJob(job));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable("id") Long id, @RequestBody Job job) {
        Optional<Job> updatedJob = jobService.updateJob(id, job);
        if (!updatedJob.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedJob.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable("id") Long id) {
        if (!jobService.getJobyById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        if (!jobService.deleteJob(id)){
            return ResponseEntity.internalServerError().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }
}
