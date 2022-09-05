package com.digitalchameleon.jobportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digitalchameleon.jobportal.dto.JobDTO;
import com.digitalchameleon.jobportal.modal.Job;

@Service
public interface JobService {

	void close(Long id);

	Job findById(Long id);
	
	List<Object> findJobsBySkillName(String name);
	
	List<Object> findAll();
	
	List<Object> findAllActiveJobs();
	
	Job postJob(JobDTO jobDto);
	
	void awardJob(Long jobId, Long freelancerId);
}