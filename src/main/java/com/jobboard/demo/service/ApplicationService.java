package com.jobboard.demo.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobboard.demo.Model.Application;
import com.jobboard.demo.Repository.ApplicationRepository;

@Service
public class ApplicationService {
    
    @Autowired
    private ApplicationRepository appRepository;
    
    public List<Application> getAllApplications() {
        return appRepository.findAll();
    }

    public Optional<Application> getApplicationById(Long id) {
        return appRepository.findById(id);
    }

    public Application createApplication(Application app) {
        return appRepository.save(app);
    }

    public Optional<Application> updateApplication(Long id, Application app) {
        Optional<Application> retrievedApplication = appRepository.findById(id);
        if (!retrievedApplication.isPresent()) {
            return Optional.empty();
        }
        Application toUpdate = retrievedApplication.get();
        if(app.getApp_status()!= null){
            toUpdate.setApp_status(app.getApp_status());
        }
        toUpdate.setResume_file_path(app.getResume_file_path());
        toUpdate.setResume_text(app.getResume_text());
        toUpdate.setUpdated_at(new Timestamp(System.currentTimeMillis()));
        return Optional.of(appRepository.save(toUpdate));
    }

    public Boolean deleteApplication(Long id){
        try{
            appRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
        
    }
}
