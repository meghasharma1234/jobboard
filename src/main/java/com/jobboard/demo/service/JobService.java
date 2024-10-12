package com.jobboard.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jobboard.demo.Model.Job;
import com.jobboard.demo.Repository.JobRepository;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;
    
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    
}
