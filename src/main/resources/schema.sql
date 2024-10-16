CREATE TABLE jobs (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  description TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE applications (
  id INT PRIMARY KEY AUTO_INCREMENT,
  job_id INT NOT NULL,
--   need candidate id to add when user table is  created
  resume_file_path VARCHAR(255),
  resume_text TEXT,
  submitted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP,
  app_status VARCHAR(255) DEFAULT 'PENDING',
  FOREIGN KEY (job_id) references jobs(id)
);
