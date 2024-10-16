INSERT INTO jobs (title, description) VALUES
('Software Engineer', 'Develop, test, and maintain software applications.'),
('Data Analyst', 'Analyze data sets and produce reports to help decision making.'),
('Project Manager', 'Oversee project timelines and ensure deliverables are met.'),
('DevOps Engineer', 'Maintain and optimize the development and production environments.'),
('UI/UX Designer', 'Design user interfaces and user experiences for web and mobile applications.'),
('Product Manager', 'Lead product development and manage product lifecycle.'),
('Technical Writer', 'Create and maintain technical documentation for software products.'),
('Mobile Developer', 'Develop and maintain mobile applications for Android and iOS platforms.'),
('Systems Administrator', 'Manage and maintain IT infrastructure and server environments.'),
('Quality Assurance Engineer', 'Test software applications to ensure they meet quality standards.');


INSERT INTO applications (job_id, resume_file_path, resume_text, submitted_at, updated_at, app_status)
VALUES
(1, '/resumes/resume_1.pdf', 'Experienced software developer with expertise in Java and Python...', '2023-10-01 12:34:56', '2023-10-02 08:45:30', 'PENDING'),
(2, '/resumes/resume_2.pdf', 'Data scientist with over 4 years of experience in machine learning and AI...', '2023-10-03 09:21:12', '2023-10-04 10:50:00', 'REVIEW'),
(3, '/resumes/resume_3.pdf', 'Frontend engineer skilled in React, Angular, and web performance optimization...', '2023-10-05 14:22:30', NULL, 'PENDING'),
(4, '/resumes/resume_4.pdf', 'DevOps specialist with expertise in Docker, Kubernetes, and cloud infrastructure...', '2023-10-06 16:30:45', '2023-10-07 09:11:50', 'INTERVIEW_SCHEDULED'),
(5, '/resumes/resume_5.pdf', 'Backend developer with a strong understanding of Spring Boot, microservices, and databases...', '2023-10-08 08:12:15', '2023-10-09 10:30:00', 'REJECTED');
