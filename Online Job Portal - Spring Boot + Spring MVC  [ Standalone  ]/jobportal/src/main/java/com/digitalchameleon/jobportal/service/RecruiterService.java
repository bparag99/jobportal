package com.digitalchameleon.jobportal.service;

import java.util.List;

import javax.validation.Valid;

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

	RecruiterDTO findRecruiter(RecruiterDTO recruiterDto);

	/**
	 * @param currentPassword
	 * @param nPassword
	 * @param recruiterDTO
	 * @return
	 */
	RecruiterDTO updatePassword(String currentPassword, String nPassword, RecruiterDTO recruiterDTO);

}
