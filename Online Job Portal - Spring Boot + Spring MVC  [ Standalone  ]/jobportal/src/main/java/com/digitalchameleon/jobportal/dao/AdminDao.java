/**
 * 
 */
package com.digitalchameleon.jobportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digitalchameleon.jobportal.modal.Admin;

/**
 * @author bpara
 *
 */
@Repository
public interface AdminDao extends JpaRepository<Admin, Long> {
	
	@Query(value = "select admin_seq.currval from dual", nativeQuery = true)
	Long getCurrentSeriesId();

	public Admin findByUserName(String userName);

	public boolean existsByUserName(String userName);

}
