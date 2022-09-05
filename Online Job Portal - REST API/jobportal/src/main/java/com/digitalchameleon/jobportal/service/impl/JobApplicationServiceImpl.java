package com.digitalchameleon.jobportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalchameleon.jobportal.dao.FreelancerDao;
import com.digitalchameleon.jobportal.dao.JobApplicationDao;
import com.digitalchameleon.jobportal.dao.JobDao;
import com.digitalchameleon.jobportal.dto.JobApplicationDTO;
import com.digitalchameleon.jobportal.dto.JobApplicationsListDTO;
import com.digitalchameleon.jobportal.expection.InvalidJobApplicationException;
import com.digitalchameleon.jobportal.modal.JobApplication;
import com.digitalchameleon.jobportal.service.JobApplicationService;

/**
 * @author Parag Bajaj
 *
 */
@Service
@Transactional
public class JobApplicationServiceImpl implements JobApplicationService {

	@Autowired
	JobApplicationDao jobApplicationDao;

	@Autowired
	JobDao jobDao;

	@Autowired
	FreelancerDao freelancerDao;

	@Override
	public JobApplication applyToJob(JobApplicationDTO jobApplicationDto) {
		JobApplication jobApplication = new JobApplication();
		if ((jobApplicationDto.getFreelancerId() != null) || !jobApplicationDto.getCoverLetter().isEmpty()
				|| jobApplicationDto.getJobId() != null) {

			jobApplication.setCoverLetter(jobApplicationDto.getCoverLetter());
			jobApplication.setFreelancer(freelancerDao.findById(jobApplicationDto.getFreelancerId()).get());
			jobApplication.setJob(jobDao.findById(jobApplicationDto.getJobId()).get());
			return jobApplicationDao.save(jobApplication);

		} else {
			throw new InvalidJobApplicationException();
		}
	}

	@Override
	public List<JobApplicationsListDTO> findAll() {
		return jobApplicationDao.findAllApps();

	}

	@Override
	public void remove(Long id) {
		if (jobApplicationDao.existsById(id)) {

			jobApplicationDao.deleteById(id);
		} else {
			throw new InvalidJobApplicationException();
		}

	}

	@Override
	public JobApplication updateJobApplication(Long id, JobApplicationDTO jobApplicationDto) {
		if (jobApplicationDao.existsById(id)) {

			JobApplication jobApplication = jobApplicationDao.findById(id).get();
			jobApplication.setCoverLetter(jobApplicationDto.getCoverLetter());

			jobApplication.setJob(jobDao.findById(jobApplicationDto.getJobId()).get());
			jobApplicationDao.save(jobApplication);

			return jobApplication;
		} else {
			throw new InvalidJobApplicationException();
		}

	}

	@Override
	public List<JobApplicationsListDTO> findAllByJobId(Long jobId) {
		return jobApplicationDao.findAllByJobId(jobId);
	}

	@Override
	public List<JobApplicationsListDTO> findByFreelancerId(Long jobId, Long freelancerId) {
		return jobApplicationDao.findByFreelancerId(jobId, freelancerId);
	}

}