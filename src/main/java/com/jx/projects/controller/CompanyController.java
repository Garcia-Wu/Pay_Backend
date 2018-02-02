package com.jx.projects.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jx.projects.entiy.Company;
import com.jx.projects.service.CompanyService;
import com.jx.projects.util.PayConstants;

/**
 * @author  JX.Wu
 * @date  2018年2月2日
 */
@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping("/showCompany")
	public String showCompany(Model model){
		List<Company> companies = companyService.findActiveList();
		model.addAttribute("companyList", companies);
		return "company/companyList";
	}
	
	@RequestMapping("/getCompany")
	public String getCompany(Model model){
		List<Company> companies = companyService.findActiveList();
		model.addAttribute("companyList", companies);
		model.addAttribute("defaultStatus", PayConstants.ACTIVESTATUS);
		return "company/detail";
	}
	
	@RequestMapping("/updateCompany")
	@ResponseBody
	public String updateCompany(Company company, Model model){
		System.out.println(company);
		companyService.save(company);
		return "保存成功！";
	}
}
