package com.jx.projects.controller;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jx.projects.entiy.WagesItem;
import com.jx.projects.service.HrmService;
import com.jx.projects.util.PageWagesItem;
import com.jx.projects.util.PayConstants;

/**
 * @author  JX.Wu
 * @date  2018年1月9日
 */
@Controller
@RequestMapping("/hrm")
public class HrmController {
	
	@Autowired
	private HrmService hrmService;
	
	/** 显示计算工资界面 */
	@RequestMapping("/showCalcWages")
	public String showCalcWages(Model model){
		return "/hrm/calcWages";
	}
	
	/** 导入excel */
	@RequestMapping("/getExcel")
	public String getExcel(@RequestParam("file")CommonsMultipartFile file,HttpSession session,Model model){
		try {
			// 获取excel文件输入流
			InputStream in = file.getInputStream();
			// 封装至实体类集合
			List<WagesItem> wagesItems = hrmService.readExcel(in);
			// 保存至session
			session.setAttribute(PayConstants.session_wagesItem, wagesItems);
			model.addAttribute(PayConstants.message, "导入Excel成功！");
		} catch (Exception e) {
			model.addAttribute(PayConstants.message, e.getMessage());
		}
		return "/hrm/calcWages";
	}
	
	/** 显示修改信息界面 */
	@RequestMapping("/showUpdateWages")
	public String showUpdateWages(@RequestParam("trId")String trId,HttpSession session,Model model){
		try {
			// 从session中取出wagesItems
			@SuppressWarnings("unchecked")
			List<WagesItem> wagesItems = (List<WagesItem>) session.getAttribute(PayConstants.session_wagesItem);
			String index = trId.substring(trId.indexOf("_") + 1);
			// 获取对应的wagesItem
			WagesItem wagesItem = wagesItems.get(Integer.valueOf(index));
			model.addAttribute("wagesItem", wagesItem);
			model.addAttribute("index", index);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(PayConstants.message, "加载数据失败！");
		}
		return "/hrm/updateWages";
	}
	
	/** 修改工资信息 */
	@RequestMapping("/updateWages")
	public String updateWages(String index,PageWagesItem pageWagesItem,HttpSession session,Model model){
		try {
			@SuppressWarnings("unchecked")
			List<WagesItem> wagesItems = (List<WagesItem>) session.getAttribute(PayConstants.session_wagesItem);
			// 从session集合中取出对应的对象
			WagesItem wagesItem = wagesItems.get(Integer.valueOf(index));
			// 获取信息，进行计算工资
			hrmService.calcWages(wagesItem,pageWagesItem);
			model.addAttribute("wagesItem", wagesItem);
			model.addAttribute("index", index);
			model.addAttribute(PayConstants.message, "信息已成功修改！");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(PayConstants.message, e.getMessage());
		}
		return "/hrm/updateWages";
	}
}
