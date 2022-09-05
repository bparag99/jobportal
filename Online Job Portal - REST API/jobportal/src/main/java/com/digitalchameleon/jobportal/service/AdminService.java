package com.digitalchameleon.jobportal.service;

import org.springframework.stereotype.Service;

import com.digitalchameleon.jobportal.dto.AdminDTO;
import com.digitalchameleon.jobportal.modal.Admin;

@Service
public interface AdminService {

	Admin findById(Long id);

	Admin save(AdminDTO adminDto);

	Admin update(Long id, AdminDTO adminDto);
	
	Admin findByUserName(String userName);
}
