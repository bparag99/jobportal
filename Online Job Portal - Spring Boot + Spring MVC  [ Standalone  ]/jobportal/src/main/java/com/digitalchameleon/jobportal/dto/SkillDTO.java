package com.digitalchameleon.jobportal.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class SkillDTO {
	
	@NotEmpty(message = "Skill cannot be blank")
	private String name;
	@NotBlank(message = "Skill description cannot be empty")
	private String description;

	public SkillDTO(@NotEmpty(message = "Skill cannot be blank") String name,
			@NotBlank(message = "Skill description cannot be empty") String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public SkillDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "SkillDTO [name=" + name + ", description=" + description + "]";
	}

}
