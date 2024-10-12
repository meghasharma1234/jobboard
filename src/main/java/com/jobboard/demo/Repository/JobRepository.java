package com.jobboard.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobboard.demo.Model.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
    
}
