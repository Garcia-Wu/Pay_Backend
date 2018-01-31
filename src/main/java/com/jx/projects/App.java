package com.jx.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author  JX.Wu
 * @date  2017年12月27日
 */
@SpringBootApplication
@Configuration
@ComponentScan(basePackages="com.jx") //默认扫描是当前包下的路径
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class}) 
public class App extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(App.class);
	}
	
	public static void main(String[] args) throws Exception{
		SpringApplication.run(App.class, args);
	}
	
}
