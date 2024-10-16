package com.jobboard.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobboard.demo.Model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    
}
