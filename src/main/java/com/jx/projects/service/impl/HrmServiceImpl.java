package com.jx.projects.service.impl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jx.projects.entiy.WagesItem;
import com.jx.projects.service.HrmService;
import com.jx.projects.util.CalcWagesUtils;
import com.jx.projects.util.ExcelUtils;
import com.jx.projects.util.PageWagesItem;
import com.jx.projects.util.PayConstants;
import com.jx.projects.util.PayException;

/**
 * @author  JX.Wu
 * @date  2018年1月30日
 */
@Service("HrmService")
public class HrmServiceImpl implements HrmService{
	
	/** 导入excel */
	@Override
	public List<WagesItem> readExcel(InputStream in) {
		try {
			// 获取定义好的表头作为key, bean属性名作为value的map
			Map<String, String> headerMap = PayConstants.getHeaderMap();
			List<WagesItem> wagesItems = ExcelUtils.readAll(in, headerMap, WagesItem.class);
			return wagesItems;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PayException("导入excel失败！");
		}
	}

	/** 计算工资 */
	@Override
	public void calcWages(WagesItem wagesItem, PageWagesItem pageWagesItem) {
		try {
			// 如果页面有输入对应参数, 则赋值给实体类
			if(pageWagesItem.getPageEntryTime() != null && !pageWagesItem.getPageEntryTime().trim().equals("")){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
				Date entryTime = sdf.parse(pageWagesItem.getPageEntryTime());
				wagesItem.setEntryTime(entryTime);
			}
			if(pageWagesItem.getPageName() != null && !pageWagesItem.getPageName().trim().equals("")){
				wagesItem.setName(pageWagesItem.getPageName());
			}
			if(pageWagesItem.getPageJob() != null && !pageWagesItem.getPageJob().trim().equals("")){
				wagesItem.setJob(pageWagesItem.getPageJob());
			}
			if(pageWagesItem.getPageFullFrequentlyDay() != null && !pageWagesItem.getPageFullFrequentlyDay().trim().equals("")){
				wagesItem.setFullFrequentlyDay(Double.valueOf(pageWagesItem.getPageFullFrequentlyDay()));
			}
			if(pageWagesItem.getPageAttendanceDay() != null && !pageWagesItem.getPageAttendanceDay().trim().equals("")){
				wagesItem.setAttendanceDay(Double.valueOf(pageWagesItem.getPageAttendanceDay()));
			}
			if(pageWagesItem.getPageWorkOvertime() != null && !pageWagesItem.getPageWorkOvertime().trim().equals("")){
				wagesItem.setWorkOvertime(Double.valueOf(pageWagesItem.getPageWorkOvertime()));
			}
			if(pageWagesItem.getPageOrdinaryOvertime() != null && !pageWagesItem.getPageOrdinaryOvertime().trim().equals("")){
				wagesItem.setOrdinaryOvertime(Double.valueOf(pageWagesItem.getPageOrdinaryOvertime()));
			}
			if(pageWagesItem.getPageHolidayOvertime() != null && !pageWagesItem.getPageHolidayOvertime().trim().equals("")){
				wagesItem.setHolidayOvertime(Double.valueOf(pageWagesItem.getPageHolidayOvertime()));
			}
			if(pageWagesItem.getPageAbsenteeismDays() != null && !pageWagesItem.getPageAbsenteeismDays().trim().equals("")){
				wagesItem.setAbsenteeismDays(Double.valueOf(pageWagesItem.getPageAbsenteeismDays()));
			}
			if(pageWagesItem.getPageSickLeaveDays() != null && !pageWagesItem.getPageSickLeaveDays().trim().equals("")){
				wagesItem.setSickLeaveDays(Double.valueOf(pageWagesItem.getPageSickLeaveDays()));
			}
			if(pageWagesItem.getPageBaseSalary() != null && !pageWagesItem.getPageBaseSalary().trim().equals("")){
				wagesItem.setBaseSalary(Double.valueOf(pageWagesItem.getPageBaseSalary()));
			}
			if(pageWagesItem.getPageOvertimeAllowance() != null && !pageWagesItem.getPageOvertimeAllowance().trim().equals("")){
				wagesItem.setOvertimeAllowance(Double.valueOf(pageWagesItem.getPageOvertimeAllowance()));
			}
			if(pageWagesItem.getPageTaskIndicators() != null && !pageWagesItem.getPageTaskIndicators().trim().equals("")){
				wagesItem.setTaskIndicators(Double.valueOf(pageWagesItem.getPageTaskIndicators()));
			}
			if(pageWagesItem.getPageSalesPerformance() != null && !pageWagesItem.getPageSalesPerformance().trim().equals("")){
				wagesItem.setSalesPerformance(Double.valueOf(pageWagesItem.getPageSalesPerformance()));
			}
			if(pageWagesItem.getPageSinglePerformance() != null && !pageWagesItem.getPageSinglePerformance().trim().equals("")){
				wagesItem.setSinglePerformance(Double.valueOf(pageWagesItem.getPageSinglePerformance()));
			}
			if(pageWagesItem.getPageSeniorityWages() != null && !pageWagesItem.getPageSeniorityWages().trim().equals("")){
				wagesItem.setSeniorityWages(Integer.valueOf(pageWagesItem.getPageSeniorityWages()));
			}
			if(pageWagesItem.getPageSocialSecurity() != null && !pageWagesItem.getPageSocialSecurity().trim().equals("")){
				wagesItem.setSocialSecurity(Double.valueOf(pageWagesItem.getPageSocialSecurity()));
			}
			if(pageWagesItem.getPageBonus() != null && !pageWagesItem.getPageBonus().trim().equals("")){
				wagesItem.setBonus(Double.valueOf(pageWagesItem.getPageBonus()));
			}
			if(pageWagesItem.getPageUtilities() != null && !pageWagesItem.getPageUtilities().trim().equals("")){
				wagesItem.setUtilities(Double.valueOf(pageWagesItem.getPageUtilities()));
			}
			if(pageWagesItem.getPageSocialInsurancePremiums() != null && !pageWagesItem.getPageSocialInsurancePremiums().trim().equals("")){
				wagesItem.setSocialInsurancePremiums(Double.valueOf(pageWagesItem.getPageSocialInsurancePremiums()));
			}
			if(pageWagesItem.getPageCashPledge() != null && !pageWagesItem.getPageCashPledge().trim().equals("")){
				wagesItem.setCashPledge(Double.valueOf(pageWagesItem.getPageCashPledge()));
			}
			if(pageWagesItem.getPageOtherDeductions() != null && !pageWagesItem.getPageOtherDeductions().trim().equals("")){
				wagesItem.setOtherDeductions(Double.valueOf(pageWagesItem.getPageOtherDeductions()));
			}
			// 工资计算
			CalcWagesUtils.calcWages(wagesItem);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PayException("修改信息失败！");
		}
	}

}
