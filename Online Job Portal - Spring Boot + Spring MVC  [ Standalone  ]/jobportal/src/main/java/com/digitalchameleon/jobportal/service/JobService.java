package com.digitalchameleon.jobportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digitalchameleon.jobportal.dto.JobApplicationsListDTO;
import com.digitalchameleon.jobportal.dto.JobDTO;
import com.digitalchameleon.jobportal.dto.JobListDTO;
import com.digitalchameleon.jobportal.modal.Job;

@Service
public interface JobService {

	List<JobListDTO> findAllByRecruiter(String userName);

	Job findById(Long id);

	void awardJob(Long jobId, String userName);

	Job postJob(JobDTO jobDto);

	List<JobListDTO> findJobAppliedByFreelancerId(Long frID);
	
	List<JobListDTO> findAllActiveJobs();

	List<JobListDTO> findAllJobs();

	List<JobListDTO> findAll();

	// Unused
	

}