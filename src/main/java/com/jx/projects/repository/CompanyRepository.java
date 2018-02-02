package com.jx.projects.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jx.projects.entiy.Company;

/**
 * @author  JX.Wu
 * @date  2018年2月2日
 */
public interface CompanyRepository extends JpaRepository<Company, Integer>{

	List<Company> findByStatus(Integer activestatus);

}
