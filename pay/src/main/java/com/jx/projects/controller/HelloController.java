package com.jx.projects.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  JX.Wu
 * @date  2017年12月27日
 */
// 等同于@Controller + @ResponseBody
@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello(){
		return "Hello Spring Boot!";
	}
}
