package com.jx.projects.controller;

import java.util.Date;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient;
import com.jx.projects.entiy.Hello;
import com.jx.projects.util.CopyPropertiesUtil;

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
		CopyPropertiesUtil.CopyProperties(hello, hello2);
		System.out.println("hello end: "+hello);
		System.out.println("hello2 end: "+hello2);
		return "Hello Spring Boot!";
	}
	
	@RequestMapping("/testOss")
	public String testOss(@RequestParam("fileName")MultipartFile file){
		String endpoint = "oss-cn-shenzhen.aliyuncs.com";
        String accessKeyId  = "LTAIytD5zD6qaY5G";
        String accessKeySecret  = "mnpjfQjee7X4X4KrCk3nOV8z6tIYPp";
        String bucketName = "payfile";
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        String extend = FilenameUtils.getExtension(file.getOriginalFilename());
        try {
			ossClient.putObject(bucketName, "2018-01/31/superAdmin."+extend.toLowerCase(), file.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
        ossClient.shutdown();
		return "SUCCESS!";
	}
}
