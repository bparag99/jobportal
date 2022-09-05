package com.digitalchameleon.jobportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digitalchameleon.jobportal.dto.SkillDTO;
import com.digitalchameleon.jobportal.modal.Skill;

@Service
public interface SkillService {

	Skill findById(Long id);

	List<Skill> getAllSkills();

	Long getCurrentId();

	Skill getSkill(Long id);

	String remove(Long id);

	Skill save(Skill skill);

	Skill save(SkillDTO skillDto);

	Skill update(Long id, Skill skill);
}
