/**
 * 
 */
package com.digitalchameleon.jobportal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.digitalchameleon.jobportal.dto.FreelancerDTO;
import com.digitalchameleon.jobportal.dto.JobApplicationDTO;
import com.digitalchameleon.jobportal.dto.JobApplicationsListDTO;
import com.digitalchameleon.jobportal.dto.JobDTO;
import com.digitalchameleon.jobportal.dto.JobListDTO;
import com.digitalchameleon.jobportal.expection.InvalidFreelancerException;
import com.digitalchameleon.jobportal.expection.InvalidJobApplicationException;
import com.digitalchameleon.jobportal.service.AdminService;
import com.digitalchameleon.jobportal.service.FreelancerService;
import com.digitalchameleon.jobportal.service.JobApplicationService;
import com.digitalchameleon.jobportal.service.JobService;

/**
 * @author bpara
 *
 */
@Controller
@RequestMapping("/freelancer")
public class FreelancerController {

	@Autowired
	AdminService adminService;

	@Autowired
	FreelancerService freelancerService;

	@Autowired
	JobApplicationService jobApplicationService;

	@Autowired
	JobService jobService;

	@GetMapping("/jobsearch")
	public ModelAndView jobSearch(HttpSession session) {
		ModelAndView response = new ModelAndView();
		FreelancerDTO freelancerDTO = (FreelancerDTO) session.getAttribute("loggedUser");
		Long frID = this.freelancerService.findByUserName(freelancerDTO.getUserName()).getId();
		try {
			List<JobListDTO> activeJoblist = this.jobService.findAllActiveJobs();
			response.addObject("activeJoblist", activeJoblist);
			response.setViewName("freelancer/jobsearch");
		} catch (InvalidJobApplicationException exception) {
			response.addObject("error", exception.getMessage());
			response.setViewName("freelancer/freelancerHome");
		}

		return response;
	}

	@PostMapping("/applyforjob/{jId}")
	public ModelAndView applyForJob(@PathVariable Long jId, @RequestParam String coverLetter, HttpSession session) {
		ModelAndView response = new ModelAndView();
		FreelancerDTO freelancerDTO = (FreelancerDTO) session.getAttribute("loggedUser");
		try {
			JobApplicationDTO jobApplication = new JobApplicationDTO(jId, coverLetter,
					freelancerService.findByUserName(freelancerDTO.getUserName()).getId());
			jobApplicationService.applyToJob(jobApplication);
			response.addObject("message", "Job Application uploaded !");
			response.setViewName("freelancer/freelancerHome");
		} catch (InvalidJobApplicationException exception) {
			response.addObject("error", exception.getMessage());
			response.setViewName("freelancer/freelancerHome");
		}

		return response;
	}

	@GetMapping("/myapplications")
	public ModelAndView viewApplications(HttpSession session) {
		ModelAndView response = new ModelAndView();
		FreelancerDTO freelancerDTO = (FreelancerDTO) session.getAttribute("loggedUser");
		Long frID = this.freelancerService.findByUserName(freelancerDTO.getUserName()).getId();
		try {
			List<JobListDTO> applicationslist = this.jobService.findJobAppliedByFreelancerId(frID);
			response.addObject("applicationslist", applicationslist);
			response.setViewName("freelancer/myapplications");
		} catch (InvalidJobApplicationException exception) {
			response.addObject("error", exception.getMessage());
			response.setViewName("freelancer/freelancerHome");
		}

		return response;
	}

	@GetMapping("/profile")
	public ModelAndView changePassword(HttpSession session) {
		ModelAndView response = new ModelAndView();
		FreelancerDTO freelancerDTO = (FreelancerDTO) session.getAttribute("loggedUser");
		response.setViewName("freelancer/profile");
		return response;
	}

	@PostMapping("/updatepassword")
	public ModelAndView updatePassword(@RequestParam String currentPassword, @RequestParam String nPassword,
			HttpSession session) {
		ModelAndView response = new ModelAndView();
		FreelancerDTO freelancerDTO = (FreelancerDTO) session.getAttribute("loggedUser");
		try {
			freelancerDTO = freelancerService.updatePassword(currentPassword, nPassword, freelancerDTO);
			session.setAttribute("loggedUser", freelancerDTO);
			response.addObject("message", "Password Changed !");
		} catch (InvalidFreelancerException exception) {
			response.addObject("error", exception.getMessage());
		}
		response.setViewName("freelancer/freelancerHome");

		return response;
	}
}
