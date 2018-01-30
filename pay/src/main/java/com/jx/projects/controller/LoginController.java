package com.jx.projects.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author  JX.Wu
 * @date  2018年1月30日
 */
@Controller
public class LoginController {

	@RequestMapping("/main")
	public String getMain(){
		return "main";
	}
	
	@RequestMapping("/home")
	public String getHome(){
		return "home";
	}
}
