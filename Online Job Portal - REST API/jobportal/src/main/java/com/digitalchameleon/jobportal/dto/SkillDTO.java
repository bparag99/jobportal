package com.digitalchameleon.jobportal.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SkillDTO {
	@NotEmpty(message = "Skill cannot be blank")
	private String name;
	@NotBlank(message = "Skill description cannot be empty")
	private String description;
}
