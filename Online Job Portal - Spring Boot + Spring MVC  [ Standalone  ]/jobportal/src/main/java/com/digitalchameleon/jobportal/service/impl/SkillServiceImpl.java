package com.digitalchameleon.jobportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalchameleon.jobportal.dao.SkillDao;
import com.digitalchameleon.jobportal.dto.SkillDTO;
import com.digitalchameleon.jobportal.expection.DuplicateSkillException;
import com.digitalchameleon.jobportal.expection.InvalidSkillException;
import com.digitalchameleon.jobportal.modal.Skill;
import com.digitalchameleon.jobportal.service.SkillService;

/**
 * @author Parag Bajaj
 *
 */
@Service
@Transactional
public class SkillServiceImpl implements SkillService {

	@Autowired
	SkillDao skillDao;

	@Override
	public Skill findById(Long id) {
		return skillDao.findById(id).get();
	}

	@Override
	public List<Skill> getAllSkills() {
		return skillDao.findAll();
	}

	@Override
	public Long getCurrentId() {
		return skillDao.getCurrentSeriesId();
	}

	@Override
	public Skill getSkill(Long id) {
		return skillDao.getOne(id);
	}

	@Override
	public String remove(Long id) {
		if (skillDao.existsById(id)) {
			skillDao.deleteById(id);
			return "Skill Deleted ! Re-login required to reflect changes.";
		} else {
			throw new InvalidSkillException("Inavlid Skill Id !");
		}
	}

	@Override
	public Skill save(Skill skill) {
		return skillDao.saveAndFlush(skill);
	}

	public Skill save(SkillDTO skillDto) {
		Skill skill = new Skill();
		if (skillDao.existsByName(skillDto.getName())) {
			throw new DuplicateSkillException();
		} else {
			skill.setName(skillDto.getName());
			skill.setDescription(skillDto.getDescription());
			return skillDao.save(skill);
		}
	}

	@Override
	public Skill update(Long id, Skill skill) {
		if (skillDao.existsById(id)) {
			return skillDao.save(skill);
		} else {
			throw new InvalidSkillException();
		}
	}

}
