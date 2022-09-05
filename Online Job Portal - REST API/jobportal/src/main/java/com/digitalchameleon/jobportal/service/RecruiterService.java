package com.digitalchameleon.jobportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digitalchameleon.jobportal.dto.RecruiterDTO;
import com.digitalchameleon.jobportal.dto.RecruiterListDTO;
import com.digitalchameleon.jobportal.modal.Recruiter;

@Service
public interface RecruiterService {

	Recruiter findById(Long id);

	Long getCurrentId();

	Recruiter save(RecruiterDTO recruiterdto);

	Recruiter update(Long id, RecruiterDTO recruiterDto);

	Recruiter findByUserName(String userName);

	List<RecruiterListDTO> findAll();

}
