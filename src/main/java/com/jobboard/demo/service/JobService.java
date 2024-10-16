package com.jobboard.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<Job> getJobyById(Long id) {
        return jobRepository.findById(id);
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Optional<Job> updateJob(Long id, Job job) {
        Optional<Job> retrievedJob = jobRepository.findById(id);
        if (!retrievedJob.isPresent()) {
            return Optional.empty();
        }
        Job toUpdate = retrievedJob.get();
        toUpdate.setTitle(job.getTitle());
        toUpdate.setDescription(job.getDescription());
        return Optional.of(jobRepository.save(toUpdate));
    }

    public Boolean deleteJob(Long id){
        try{
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
        
    }

}
