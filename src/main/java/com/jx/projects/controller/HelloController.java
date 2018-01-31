package com.jx.projects.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jx.projects.entiy.Hello;
import com.jx.projects.util.PayCopyProperties;

/**
 * @author  JX.Wu
 * @date  2017年12月27日
 */
// 等同于@Controller + @ResponseBody
@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello(Hello hello){
		System.out.println("hello："+hello);
		Hello hello2 = new Hello();
		hello2.setMyDouble(99.0);
		hello2.setMyString("111");
		hello2.setMyDate(new Date());
		hello2.setMyInt(100);
		System.out.println("hello2: "+hello2);
		PayCopyProperties.CopyProperties(hello, hello2);
		System.out.println("hello end: "+hello);
		System.out.println("hello2 end: "+hello2);
		return "Hello Spring Boot!";
	}
}
