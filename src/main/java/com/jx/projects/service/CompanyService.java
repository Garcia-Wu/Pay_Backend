package com.jx.projects.service;

import java.util.List;

import com.jx.projects.entiy.Company;

/**
 * @author  JX.Wu
 * @date  2018年2月2日
 */
public interface CompanyService {

	List<Company> findActiveList();

	void save(Company company);

}
