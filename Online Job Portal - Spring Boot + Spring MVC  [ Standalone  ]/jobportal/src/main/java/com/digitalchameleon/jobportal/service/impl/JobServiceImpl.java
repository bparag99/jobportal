package com.digitalchameleon.jobportal.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalchameleon.jobportal.dao.FreelancerDao;
import com.digitalchameleon.jobportal.dao.JobDao;
import com.digitalchameleon.jobportal.dao.RecruiterDao;
import com.digitalchameleon.jobportal.dao.SkillDao;
import com.digitalchameleon.jobportal.dto.JobDTO;
import com.digitalchameleon.jobportal.dto.JobListDTO;
import com.digitalchameleon.jobportal.expection.InvalidFreelancerException;
import com.digitalchameleon.jobportal.expection.InvalidJobApplicationException;
import com.digitalchameleon.jobportal.expection.InvalidJobException;
import com.digitalchameleon.jobportal.modal.Freelancer;
import com.digitalchameleon.jobportal.modal.Job;
import com.digitalchameleon.jobportal.service.JobService;

/**
 * @author Parag Bajaj
 *
 */
@Service
@Transactional
public class JobServiceImpl implements JobService {

	@Autowired
	JobDao jobDao;

	@Autowired
	SkillDao skillDao;

	@Autowired
	FreelancerDao freelancerDao;

	@Autowired
	RecruiterDao recruiterDao;

	// Used
	private JobListDTO mapperDTO(Job job) {
		return new JobListDTO(job);
	}

	// Used in viewJobApplications
	@Override
	public List<JobListDTO> findAllByRecruiter(String userName) {
		List<Job> allJobs = jobDao.findAllByRecruiter(recruiterDao.findByUserName(userName).getId());
		List<JobListDTO> jobListDTO = allJobs.stream().map(job -> mapperDTO(job)).collect(Collectors.toList());
		;
		if (jobListDTO.isEmpty() || jobListDTO == null) {
			throw new InvalidJobApplicationException("No Job Posted !");
		}
		return jobListDTO;
	}

	@Override
	public Job postJob(JobDTO jobdto) {
		Job job = new Job();
		System.out.println(jobdto.toString());
		if (recruiterDao.existsByUserName(jobdto.getRecruiterUName()) && skillDao.existsById(jobdto.getSkillId())) {
			job.setPostedBy(recruiterDao.findByUserName(jobdto.getRecruiterUName()));
			job.setAwardedTo(null);
			job.setSkill(skillDao.findById(jobdto.getSkillId()).get());
			job.setActive(true);
			job.setJobTitle(jobdto.getJobTitle());
			job.setJobDescription(jobdto.getJobDescription());
			return jobDao.saveAndFlush(job);
		} else
			throw new InvalidJobException();
	}

	@Override
	public void awardJob(Long jobId, String userName) {
		Job job = jobDao.findById(jobId).get();
		Freelancer freelancer = freelancerDao.findByUserName(userName);
		job.setAwardedTo(freelancer);
		job.setActive(false);
		jobDao.saveAndFlush(job);
	}

	@Override
	public Job findById(Long id) {

		if (jobDao.existsById(id)) {
			return jobDao.findById(id).get();
		} else
			throw new InvalidJobException("No Job Data Found !");
	}

	@Override
	public List<JobListDTO> findAllActiveJobs() {
		List<Job> activeJobs = jobDao.findAllActiveDTO();
		if (activeJobs.isEmpty() || activeJobs == null) {
			throw new InvalidJobApplicationException("No Jobs Available !");
		}
		List<JobListDTO> jobListDTO = activeJobs.stream().map(job -> mapperDTO(job)).collect(Collectors.toList());
		return jobListDTO;
	}

	@Override
	public List<JobListDTO> findJobAppliedByFreelancerId(Long frID) {
		List<Job> appliedJobs = jobDao.findJobAppliedByFreelancerId( frID);
		if (appliedJobs.isEmpty() || appliedJobs == null) {
			throw new InvalidJobApplicationException("No Job Applications Available !");
		}
		List<JobListDTO> jobListDTO = appliedJobs.stream().map(job -> mapperDTO(job)).collect(Collectors.toList());
		return jobListDTO;
	}

	@Override
	public List<JobListDTO> findAllJobs() {
		List<Job> allJobs = jobDao.findAll();
		if (allJobs.isEmpty() || allJobs == null) {
			throw new InvalidJobApplicationException("No Job Applications Available !");
		}
		List<JobListDTO> jobListDTO = allJobs.stream().map(job -> mapperDTO(job)).collect(Collectors.toList());
		return jobListDTO;
	}
	@Override
	public List<JobListDTO> findAll() {
		List<Job> allJobs = jobDao.findAll();
		List<JobListDTO> jobListDTO = allJobs.stream().map(job -> mapperDTO(job)).collect(Collectors.toList());
		return jobListDTO;
	}
	
	
	// UnUsed


}