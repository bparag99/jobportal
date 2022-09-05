package com.digitalchameleon.jobportal.dto;

import javax.validation.constraints.NotNull;

public class JobDTO {
	private long freelancerid ;
	@NotNull(message = "skillId cant be null")
	private long skillId;
	@NotNull(message = "recruiterid cant be null")
	private String recruiterUName;

	private String jobTitle;
	private String jobDescription;

	public JobDTO() {
		super();
	}

	public JobDTO(long freelancerid, long skillId, String recruiterUName, String jobTitle, String jobDescription) {
		super();
		this.freelancerid = freelancerid;
		this.skillId = skillId;
		this.recruiterUName = recruiterUName;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
	}

	public long getFreelancerid() {
		return freelancerid;
	}

	public String getRecruiterUName() {
		return recruiterUName;
	}

	public long getSkillId() {
		return skillId;
	}

	public void setFreelancerid(long freelancerid) {
		this.freelancerid = freelancerid;
	}

	public void setRecruiterUName(String recruiterUName) {
		this.recruiterUName = recruiterUName;
	}

	public void setSkillId(long skillId) {
		this.skillId = skillId;
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

	@Override
	public String toString() {
		return "JobDTO [freelancerid=" + freelancerid + ", skillId=" + skillId + ", recruiterUName=" + recruiterUName
				+ ", jobTitle=" + jobTitle + ", jobDescription=" + jobDescription + "]";
	}

}