package com.digitalchameleon.jobportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalchameleon.jobportal.dao.RecruiterDao;
import com.digitalchameleon.jobportal.dto.RecruiterDTO;
import com.digitalchameleon.jobportal.dto.RecruiterListDTO;
import com.digitalchameleon.jobportal.expection.InvalidRecruiterException;
import com.digitalchameleon.jobportal.modal.Recruiter;
import com.digitalchameleon.jobportal.service.RecruiterService;

/**
 * @author Parag Bajaj
 *
 */
@Service
@Transactional
public class RecruiterServiceImpl implements RecruiterService {

	@Autowired
	RecruiterDao recruiterDao;

	@Override
	public Recruiter findById(Long id) {
		if (recruiterDao.existsById(id)) {
			return recruiterDao.findById(id).get();
		} else
			throw new InvalidRecruiterException();
	}

	@Override
	public Long getCurrentId() {
		return recruiterDao.getCurrentSeriesId();
	}

	@Override
	public Recruiter save(RecruiterDTO recruiterDto) {
		System.out.println(recruiterDto);
		Recruiter recruiter = new Recruiter();
		recruiter.setFirstName(recruiterDto.getFirstName());
		recruiter.setLastName(recruiterDto.getLastName());
		recruiter.setUserName(recruiterDto.getUserName());
		recruiter.setPassword(recruiterDto.getPassword());
		if (!(recruiterDto.getFirstName() == null || recruiterDto.getLastName() == null
				|| recruiterDto.getUserName() == null || recruiterDto.getPassword() == null))
			return recruiterDao.save(recruiter);
		else
			throw new InvalidRecruiterException();
	}

	@Override
	public Recruiter update(Long id, RecruiterDTO recruiterDto) {
		if (recruiterDao.existsById(id)) {
			Recruiter recruiter = recruiterDao.findById(id).get();
			recruiter.setFirstName(recruiterDto.getFirstName());
			recruiter.setLastName(recruiterDto.getLastName());
			recruiter.setUserName(recruiterDto.getUserName());
			recruiter.setPassword(recruiterDto.getPassword());
			return recruiterDao.save(recruiter);
		} else
			throw new InvalidRecruiterException();
	}

	@Override
	public Recruiter findByUserName(String userName) {
		if (recruiterDao.existsByUserName(userName)) {
			return recruiterDao.findByUserName(userName);
		} else {
			throw new InvalidRecruiterException();
		}
	}

	@Override
	public List<RecruiterListDTO> findAll() {
		return recruiterDao.findAllRecruiters();
	}
}
