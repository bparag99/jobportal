package com.digitalchameleon.jobportal.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobDTO {

	private long freelancerid = 2L;
	@NotNull(message = "skillId cant be null")
	private long skillId;
	@NotNull(message = "recruiterid cant be null")
	private long recruiterId;

	private String jobTitle;
	private String jobDescription;
}
