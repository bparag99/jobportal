/**
 * 
 */
package com.digitalchameleon.jobportal.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.digitalchameleon.jobportal.dto.AdminDTO;
import com.digitalchameleon.jobportal.dto.FreelancerDTO;
import com.digitalchameleon.jobportal.dto.RecruiterDTO;
import com.digitalchameleon.jobportal.expection.InvalidFreelancerException;
import com.digitalchameleon.jobportal.expection.InvalidRecruiterException;
import com.digitalchameleon.jobportal.modal.Admin;
import com.digitalchameleon.jobportal.service.AdminService;
import com.digitalchameleon.jobportal.service.FreelancerService;
import com.digitalchameleon.jobportal.service.RecruiterService;

/**
 * @author Parag Bajaj
 *
 */
@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	AdminService adminService;

	@Autowired
	FreelancerService freelancerService;

	@Autowired
	RecruiterService recruiterService;

	@GetMapping("/home")
	public String homePage() {
		return "index";
	}
	

	@PostMapping("/freelancer")
	public ModelAndView freelancerLogin(FreelancerDTO freelancerDTO, HttpSession session) {
		ModelAndView response = new ModelAndView();
		String error = null;
		try {
			freelancerDTO = freelancerService.findFreelancer(freelancerDTO);
			response.addObject("loggedUser", freelancerDTO);
			response.setViewName("freelancer/freelancerHome");
			session.setAttribute("loggedUser", freelancerDTO);
			this.adminService.writeLogs("Login Successfull : " + freelancerDTO.toString());

		} catch (InvalidFreelancerException exception) {
			error = exception.getMessage();
			this.adminService.writeLogs(freelancerDTO.toString() + " " + error);
			response.addObject("error", error);
			response.setViewName("index");
		}

		return response;
	}

	@PostMapping("/recruiter")
	public ModelAndView recruiterLogin(RecruiterDTO recruiterDTO, HttpSession session) {
		ModelAndView response = new ModelAndView();
		String error = null;
		try {
			recruiterDTO = recruiterService.findRecruiter(recruiterDTO);
			response.addObject("loggedUser", recruiterDTO);
			response.setViewName("recruiter/recruiterHome");
			session.setAttribute("loggedUser", recruiterDTO);
			System.out.println(recruiterDTO.toString());
			this.adminService.writeLogs("Login Successfull : " + recruiterDTO.toString());

		} catch (InvalidRecruiterException exception) {
			error = exception.getMessage();
			this.adminService.writeLogs(recruiterDTO.toString() + " " + error);
			response.addObject("error", error);
			response.setViewName("index");
		}

		return response;
	}

	@GetMapping("/recruiterSignUp")
	public String recruiterSignUp() {
		return "recruiterSignUp";
	}

	@GetMapping("/freelancerSignUp")
	public String freelancerSignUp() {
		return "freelancerSignUp";
	}

	@PostMapping("/recruiterSignUp")
	public ModelAndView createRecruiter(@Valid RecruiterDTO recruiterDTO) {
		ModelAndView response = new ModelAndView();
		String error = null;
		try {
			recruiterService.save(recruiterDTO);
			response.addObject("loggedUser", recruiterDTO);
			response.setViewName("success");
			this.adminService.writeLogs("New Recruiter Registration :" + recruiterDTO.getUserName());
			return response;
		} catch (InvalidRecruiterException exception) {

			if (exception.getMessage() != null) {
				error = "User Already Exists ! Registration Failed.";
			} else
				error = "One or more entered fields contain invalid objects.";
		}
		this.adminService.writeLogs("New Recruiter Regitration Failure");
		response.addObject("error", error);
		response.setViewName("index");
		return response;
	}

	@PostMapping("/freelancerSignUp")
	public ModelAndView createFreelancer(@Valid FreelancerDTO freelancerDTO) {
		ModelAndView response = new ModelAndView();
		String error = null;
		try {
			freelancerService.save(freelancerDTO);
			response.addObject("loggedUser", freelancerDTO);
			response.setViewName("success");
			this.adminService.writeLogs("New Freelancer Registration :" + freelancerDTO.getUserName());
			return response;
		} catch (InvalidFreelancerException exception) {

			if (exception.getMessage() != null) {
				error = "User Already Exists ! Registration Failed.";
			} else
				error = "One or more entered fields contain invalid objects.";

		}
		this.adminService.writeLogs("New Recruiter Regitration Failure");
		response.addObject("error", error);
		response.setViewName("index");
		return response;
	}

}
