package com.jx.projects.service;

import java.io.InputStream;
import java.util.List;

import com.jx.projects.entiy.WagesItem;

/**
 * @author  JX.Wu
 * @date  2018年1月30日
 */
public interface WagesItemService {
	
	/** 导入excel 
	 * @param in */
	List<WagesItem> readExcel(InputStream in) throws Exception;

	/** 计算工资 
	 * @param pageWagesItem */
	void calcWages(WagesItem wagesItem, WagesItem sessionItem);
}
