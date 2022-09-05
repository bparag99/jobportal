package com.digitalchameleon.jobportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digitalchameleon.jobportal.dto.JobApplicationDTO;
import com.digitalchameleon.jobportal.dto.JobApplicationsListDTO;
import com.digitalchameleon.jobportal.modal.JobApplication;

@Service
public interface JobApplicationService {

	JobApplication applyToJob(JobApplicationDTO jobApplicationDto);

	List<JobApplicationsListDTO> findAll();

	void remove(Long id);
	
	JobApplication updateJobApplication(Long id,JobApplicationDTO jobApplicationDto);
	
	List<JobApplicationsListDTO> findAllByJobId(Long jobId);
	
	List<JobApplicationsListDTO> findByFreelancerId(Long jobId, Long freelancerId);
}