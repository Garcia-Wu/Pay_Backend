package com.jx.projects.service.impl;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jx.projects.entiy.WagesItem;
import com.jx.projects.service.HrmService;
import com.jx.projects.util.CalcWagesUtils;
import com.jx.projects.util.ExcelUtils;
import com.jx.projects.util.PayConstants;
import com.jx.projects.util.PayCopyProperties;
import com.jx.projects.util.PayException;

/**
 * @author  JX.Wu
 * @date  2018年1月30日
 */
@Service("HrmService")
public class HrmServiceImpl implements HrmService{
	
	/** 导入excel 
	 * @throws Exception */
	@Override
	public List<WagesItem> readExcel(InputStream in) throws Exception {
		// 获取定义好的表头作为key, bean属性名作为value的map
		Map<String, String> headerMap = PayConstants.getHeaderMap();
		List<WagesItem> wagesItems = ExcelUtils.readAll(in, headerMap, WagesItem.class);
		return wagesItems;
	}

	/** 计算工资 */
	@Override
	public void calcWages(WagesItem wagesItem, WagesItem sesssionItem) {
		try {
			PayCopyProperties.CopyProperties(wagesItem, sesssionItem);
			// 工资计算
			CalcWagesUtils.calcWages(sesssionItem);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PayException("修改信息失败！");
		}
	}

}
