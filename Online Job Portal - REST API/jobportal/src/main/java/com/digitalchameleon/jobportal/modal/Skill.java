package com.digitalchameleon.jobportal.modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Skill implements Serializable {

	private static final long serialVersionUID = 8190256392493481389L;
	@Id
	@Column(name = "skill_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "skill_seq")
	@SequenceGenerator(name = "skill_seq", sequenceName = "skill_seq", allocationSize = 1)
	private Long id;
	@Column(unique = true, nullable = false)
	private String name;
	private String description;

	

}