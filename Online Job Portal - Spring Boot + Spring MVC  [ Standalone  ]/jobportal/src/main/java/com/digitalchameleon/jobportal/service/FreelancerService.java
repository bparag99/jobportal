package com.digitalchameleon.jobportal.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.digitalchameleon.jobportal.dto.FreelancerDTO;
import com.digitalchameleon.jobportal.dto.FreelancerListDTO;
import com.digitalchameleon.jobportal.modal.Freelancer;

@Service
public interface FreelancerService {

	Freelancer findById(Long id);

	Long getCurrentId();

	Freelancer save(FreelancerDTO freelancerDto);

	Freelancer update(Long id, FreelancerDTO freelancerDto);

	Freelancer findByUserName(String userName);
	
	List<FreelancerListDTO> listFreelancers();

	/**
	 * @param freelancerDto
	 * @return
	 */
	FreelancerDTO findFreelancer(FreelancerDTO freelancerDto);

	/**
	 * @param currentPassword
	 * @param nPassword
	 * @param freelancerDTO
	 * @return
	 */
	FreelancerDTO updatePassword(String currentPassword, String nPassword, FreelancerDTO freelancerDTO);
}
