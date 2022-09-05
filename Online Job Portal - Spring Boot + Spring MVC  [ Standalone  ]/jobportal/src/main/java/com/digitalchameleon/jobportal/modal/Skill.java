package com.digitalchameleon.jobportal.modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

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

	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Skill(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}