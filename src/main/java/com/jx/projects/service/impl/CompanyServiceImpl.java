package com.jx.projects.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jx.projects.entiy.Company;
import com.jx.projects.repository.CompanyRepository;
import com.jx.projects.service.CompanyService;
import com.jx.projects.util.PayConstants;

/**
 * @author  JX.Wu
 * @date  2018年2月2日
 */
@Service("CompanyService")
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public List<Company> findActiveList() {
		return companyRepository.findByStatus(PayConstants.ACTIVESTATUS);
	}

	@Override
	public void save(Company company) {
		companyRepository.save(company);
	}

}
