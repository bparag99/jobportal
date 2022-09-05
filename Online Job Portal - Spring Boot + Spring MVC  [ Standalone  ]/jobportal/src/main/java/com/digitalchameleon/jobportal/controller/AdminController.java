/**
 * 
 */
package com.digitalchameleon.jobportal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.digitalchameleon.jobportal.dto.AdminDTO;
import com.digitalchameleon.jobportal.expection.InvalidSkillException;
import com.digitalchameleon.jobportal.modal.Admin;
import com.digitalchameleon.jobportal.modal.Skill;
import com.digitalchameleon.jobportal.service.AdminService;
import com.digitalchameleon.jobportal.service.FreelancerService;
import com.digitalchameleon.jobportal.service.JobApplicationService;
import com.digitalchameleon.jobportal.service.JobService;
import com.digitalchameleon.jobportal.service.RecruiterService;
import com.digitalchameleon.jobportal.service.SkillService;

/**
 * @author bpara
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;

	@Autowired
	FreelancerService freelancerService;

	@Autowired
	RecruiterService recruiterService;

	@Autowired
	JobApplicationService jobApplicationService;

	@Autowired
	JobService jobService;

	@Autowired
	SkillService skillService;

	public AdminController(AdminService adminService, FreelancerService freelancerService,
			RecruiterService recruiterService, JobApplicationService jobApplicationService, JobService jobService,
			SkillService skillService) {
		super();
		this.adminService = adminService;
		this.freelancerService = freelancerService;
		this.recruiterService = recruiterService;
		this.jobApplicationService = jobApplicationService;
		this.jobService = jobService;
		this.skillService = skillService;
	}

	@PostMapping("")
	public ModelAndView adminLogin(AdminDTO adminDTO, HttpSession session) {
		ModelAndView response = new ModelAndView();
		System.out.println("here");
		try {
			if (adminDTO.getPassword().equals("admin") && adminDTO.getUserName().equals("admin")) {
				Admin loggedUser = this.adminService.findById((long) 1);
				session.setAttribute("loggedUser", loggedUser);
				session.setAttribute("freelancers", this.freelancerService.listFreelancers());
				session.setAttribute("recruiters", this.recruiterService.findAll());
				session.setAttribute("jobs", this.jobService.findAll());
				session.setAttribute("jobapplications", this.jobApplicationService.findAll());
				session.setAttribute("skills", this.skillService.getAllSkills());
				response.addObject("logs", this.adminService.getLogs());
				response.addObject("loggedUser", loggedUser);
				response.setViewName("admin/adminHome");
			}

		} catch (Exception e) {
			response.setViewName("index");
			response.addObject("error", "Admin Login Failed !");
		}

		return response;
	}

	

	@PostMapping("/deleteSkill")
	public ModelAndView deleteSkill(@RequestParam Long id, HttpSession session) {
		ModelAndView response = new ModelAndView();
		try {
			response.addObject("message", skillService.remove(id));
		} catch (InvalidSkillException exception) {
			// TODO: handle exception
			response.addObject("error", exception.getMessage());
		}
		response.setViewName("admin/adminHome");
		return response;
	}

	@PostMapping("/addSkill")
	public ModelAndView addSkill(Skill skill, HttpSession session) {
		ModelAndView response = new ModelAndView();
		System.out.println(skill.toString());
		try {
			skillService.save(skill);
		} catch (Exception e) {
			// TODO: handle exception
		}
		String message = "Record Added Successfully ! Re-login required to show changes.";

		response.addObject("message", message);
		response.setViewName("index");
		return response;
	}
}
