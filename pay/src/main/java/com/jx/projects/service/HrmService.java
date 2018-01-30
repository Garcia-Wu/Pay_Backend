package com.jx.projects.service;

import java.io.InputStream;
import java.util.List;

import com.jx.projects.entiy.WagesItem;
import com.jx.projects.util.PageWagesItem;

/**
 * @author  JX.Wu
 * @date  2018年1月30日
 */
public interface HrmService {
	
	/** 导入excel 
	 * @param in */
	List<WagesItem> readExcel(InputStream in);

	/** 计算工资 
	 * @param pageWagesItem */
	void calcWages(WagesItem wagesItem, PageWagesItem pageWagesItem);
}
