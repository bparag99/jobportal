package com.digitalchameleon.jobportal.dto;

import java.time.LocalDate;

import com.digitalchameleon.jobportal.modal.Job;

public class JobListDTO {

	private Long jobId;
	private Long freelancerId;
	private String freelancerUName;
	private Long skillId;
	private String skillName;
	private Long recruiterId;
	private String recruiterName;
	private String jobTitle;
	private String jobDescription;
	private boolean jobStatus;
	private LocalDate postedDate;

	
	public JobListDTO(Long jobId, Long freelancerId, String freelancerUName, Long skillId, String skillName,
			Long recruiterId, String recruiterName, String jobTitle, String jobDescription, boolean jobStatus,LocalDate postedDate) {
		super();
		this.jobId = jobId;
		this.freelancerId = freelancerId;
		this.freelancerUName = freelancerUName;
		this.skillId = skillId;
		this.skillName = skillName;
		this.recruiterId = recruiterId;
		this.recruiterName = recruiterName;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.jobStatus = jobStatus;
		this.postedDate = postedDate;
	}

	public JobListDTO(Job job) {
		this.jobId = job.getId();
		this.freelancerId = (job.getAwardedTo() == null ? null : job.getAwardedTo().getId());
		this.freelancerUName = (job.getAwardedTo() == null ? null : job.getAwardedTo().getUserName());
		this.skillId = job.getSkill().getId();
		this.skillName = job.getSkill().getName();
		this.recruiterId = (job.getPostedBy() == null ? null : job.getPostedBy().getId());
		this.recruiterName = (job.getPostedBy() == null ? null
				: job.getPostedBy().getFirstName() + " " +job.getPostedBy().getLastName());
		this.jobTitle = job.getJobTitle();
		this.jobDescription = job.getJobDescription();
		this.jobStatus = job.getActive();
		this.postedDate = job.getPostedDate();
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getFreelancerUName() {
		return freelancerUName;
	}

	public void setFreelancerUName(String freelancerName) {
		this.freelancerUName = freelancerName;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getRecruiterName() {
		return recruiterName;
	}

	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public boolean isJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(boolean jobStatus) {
		this.jobStatus = jobStatus;
	}

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public Long getFreelancerId() {
		return freelancerId;
	}

	public void setFreelancerId(Long freelancerId) {
		this.freelancerId = freelancerId;
	}

	public Long getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(Long recruiterId) {
		this.recruiterId = recruiterId;
	}

	public LocalDate getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}

	@Override
	public String toString() {
		return "JobListDTO [jobId=" + jobId + ", freelancerId=" + freelancerId + ", freelancerUName=" + freelancerUName
				+ ", skillId=" + skillId + ", skillName=" + skillName + ", recruiterId=" + recruiterId
				+ ", recruiterName=" + recruiterName + ", jobTitle=" + jobTitle + ", jobDescription=" + jobDescription
				+ ", jobStatus=" + jobStatus + ", postedDate=" + postedDate + "]";
	}
	
	

}
