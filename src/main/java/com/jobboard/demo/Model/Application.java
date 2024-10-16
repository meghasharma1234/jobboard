package com.jobboard.demo.Model;


import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    private Long job_id;
    public Long getJob_id() {
        return job_id;
    }
    private String resume_file_path;
    public String getResume_file_path() {
        return resume_file_path;
    }
    public void setResume_file_path(String resume_file_path) {
        this.resume_file_path = resume_file_path;
    }
    private String resume_text;
    public String getResume_text() {
        return resume_text;
    }
    public void setResume_text(String resume_text) {
        this.resume_text = resume_text;
    }
    private Timestamp submitted_at;
    public Timestamp getSubmitted_at() {
        return submitted_at;
    }
    public void setSubmitted_at(Timestamp submitted_at) {
        this.submitted_at = submitted_at;
    }
    private Timestamp updated_at;
    public Timestamp getUpdated_at() {
        return updated_at;
    }
    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
    private String app_status;

    public String getApp_status() {
        return app_status;
    }
    public void setApp_status(String app_status) {
        this.app_status = app_status;
    }

    @PrePersist
    protected void onCreate(){
        this.app_status = "PENDING";
        this.submitted_at = new Timestamp(System.currentTimeMillis());
        this.updated_at = new Timestamp(System.currentTimeMillis());
    }
}
