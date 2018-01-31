package com.jx.projects.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.jx.projects.config.interceptor.RequestLogInterceptor;

/**
 * @author  JX.Wu
 * @date  2018年1月30日
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	@Bean(name = "multipartResolver")
	public MultipartResolver getMultipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(20971520);   
	    multipartResolver.setMaxInMemorySize(1048576);
	    return multipartResolver;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestLogInterceptor());
	}
	
}
