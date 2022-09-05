/**
 * 
 */
package com.digitalchameleon.jobportal.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.digitalchameleon.jobportal.dto.JobApplicationsListDTO;
import com.digitalchameleon.jobportal.dto.JobDTO;
import com.digitalchameleon.jobportal.dto.JobListDTO;
import com.digitalchameleon.jobportal.dto.RecruiterDTO;
import com.digitalchameleon.jobportal.expection.InvalidJobApplicationException;
import com.digitalchameleon.jobportal.expection.InvalidJobException;
import com.digitalchameleon.jobportal.expection.InvalidRecruiterException;
import com.digitalchameleon.jobportal.modal.Freelancer;
import com.digitalchameleon.jobportal.modal.Job;
import com.digitalchameleon.jobportal.modal.Skill;
import com.digitalchameleon.jobportal.service.AdminService;
import com.digitalchameleon.jobportal.service.EmailService;
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
@RequestMapping("/recruiter")
public class RecruiterController {

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

	@Autowired
	EmailService emailService;

	// -- Handle 'View Posted Jobs' Tab
	@GetMapping("/viewpostedjobs")
	public ModelAndView viewJobApplications(HttpSession session) {
		ModelAndView response = new ModelAndView();
		RecruiterDTO recruiterDTO = (RecruiterDTO) session.getAttribute("loggedUser");
		try {
			List<JobListDTO> postedJobList = jobService.findAllByRecruiter(recruiterDTO.getUserName());
			response.addObject("postedJobList", postedJobList);
			response.setViewName("recruiter/postedjobs");
		} catch (InvalidJobApplicationException exception) {
			response.addObject("error", exception.getMessage());
			response.setViewName("recruiter/recruiterHome");
		}
		return response;
	}

	@GetMapping("/recruit/{id}")
	public ModelAndView recruit(@PathVariable Long id, HttpSession session) {
		ModelAndView response = new ModelAndView();
		RecruiterDTO recruiterDTO = (RecruiterDTO) session.getAttribute("loggedUser");
		try {
			List<JobApplicationsListDTO> applicatants = jobApplicationService.findAllByJobId(id);
			response.addObject("applicants", applicatants);
			response.setViewName("recruiter/recruitment");
		} catch (InvalidJobApplicationException exception) {
			response.addObject("error", exception.getMessage());
			response.setViewName("recruiter/recruiterHome");
		}

		return response;
	}

	@GetMapping("/email/{userName}/{jobId}")
	public ModelAndView mailInterviewDetails(@PathVariable String userName, @PathVariable Long jobId,
			HttpSession session) {
		ModelAndView response = new ModelAndView();
		RecruiterDTO recruiterDTO = (RecruiterDTO) session.getAttribute("loggedUser");
		try {
			Freelancer freelancer = freelancerService.findByUserName(userName);
			Job job = jobService.findById(jobId);
			String mailBody = "Hi " + freelancer.getFirstName() + " \n \nYou are selected for the interview ! \n"
					+ "Job Title : " + job.getJobTitle() + "\nDescription : " + job.getJobDescription()
					+ "\nSkill Set: " + job.getSkill().getName() + " : " + job.getSkill().getDescription()
					+ "\nRegards,\n" + recruiterDTO.getFirstName();
			
			String mail = emailService.sendSimpleMail(mailBody, userName, "Job Opportunity !");

			response.addObject("message", "Email Invite Sent to " + freelancer.getUserName());

		} catch (InvalidJobException exception) {
			response.addObject("error", exception.getMessage());
		}
		response.setViewName("recruiter/recruiterHome");
		return response;
	}

	@GetMapping("/awardjob/{userName}/{jobId}")
	public ModelAndView awardJob(@PathVariable String userName, @PathVariable Long jobId, HttpSession session) {
		ModelAndView response = new ModelAndView();
		RecruiterDTO recruiterDTO = (RecruiterDTO) session.getAttribute("loggedUser");
		try {
			jobService.awardJob(jobId, userName);

//			Freelancer freelancer = freelancerService.findByUserName(userName);
//			JobApplication jobApplication = jobApplicationService.findByJobId(jobId);
//			Job job = jobService.findById(jobId);

			String mail = emailService.sendSimpleMail("Congratulations ! You have been selected for the Job", userName, "Job Confirmation !");

			response.addObject("message", "Applicant " + userName + " Recruited !");

		} catch (InvalidJobException exception) {
			response.addObject("error", exception.getMessage());

		}
		response.setViewName("recruiter/recruiterHome");
		return response;
	}

	// -- Handle 'Post a New Job' Tab
	@GetMapping("/addnewjob")
	public ModelAndView addNewJob(HttpSession session) {
		ModelAndView response = new ModelAndView();
		RecruiterDTO recruiterDTO = (RecruiterDTO) session.getAttribute("loggedUser");
		List<Skill> skills = skillService.getAllSkills();
		System.out.println(Arrays.toString(skills.toArray()));
		response.addObject("skills", skills);
		response.setViewName("recruiter/newjob");
		return response;
	}

	@PostMapping("/postjob")
	public ModelAndView postJob(JobDTO jobDto, HttpSession session) {
		ModelAndView response = new ModelAndView();
		RecruiterDTO recruiterDTO = (RecruiterDTO) session.getAttribute("loggedUser");
		try {
			jobService.postJob(jobDto);
			response.addObject("message", "Job Posted Successfully");
			response.setViewName("recruiter/recruiterHome");

		} catch (InvalidJobException exception) {
			String error = null;
			error = exception.getMessage();
			response.addObject("error", error);
			response.setViewName("recruiter/recruiterHome");
		}

		return response;
	}

	// -- Handle 'Change Password' Tab
	@GetMapping("/profile")
	public ModelAndView changePassword(HttpSession session) {
		ModelAndView response = new ModelAndView();
		RecruiterDTO recruiterDTO = (RecruiterDTO) session.getAttribute("loggedUser");

		response.setViewName("recruiter/profile");

		return response;
	}

	@PostMapping("/updatepassword")
	public ModelAndView updatePassword(@RequestParam String currentPassword, @RequestParam String nPassword,
			HttpSession session) {
		ModelAndView response = new ModelAndView();
		RecruiterDTO recruiterDTO = (RecruiterDTO) session.getAttribute("loggedUser");
		try {
			recruiterDTO = recruiterService.updatePassword(currentPassword, nPassword, recruiterDTO);
			session.setAttribute("loggedUser", recruiterDTO);
			response.addObject("message", "Password Changed !");
		} catch (InvalidRecruiterException exception) {
			response.addObject("error", exception.getMessage());
		}
		response.setViewName("recruiter/recruiterHome");

		return response;
	}
}
