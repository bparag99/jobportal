package com.digitalchameleon.jobportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digitalchameleon.jobportal.modal.Skill;

@Repository
public interface SkillDao extends JpaRepository<Skill, Long> {

	boolean existsByName(String name);

	Skill findByName(String name);

	@Query(value = "select skill_seq.currval from dual", nativeQuery = true)
	Long getCurrentSeriesId();

}
