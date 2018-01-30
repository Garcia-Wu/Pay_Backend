package com.jx.projects.util;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class PayConstants {
	
	/** 提示信息 */
	public static final String message = "message";
	
	/** 读取excel的日期格式 */
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	
	/** 保存在session中的工资集合(导入的excel) */
	public static final String session_wagesItem = "wagesItems";
	
	/** 获取表头信息对应属性的map集合 */
	public static Map<String, String> getHeaderMap(){
		// key为表头信息,value为对应的实体类属性名
		Map<String, String> headerMapper = new HashMap<>();
		headerMapper.put("姓名", "name");
		headerMapper.put("职务", "job");
		headerMapper.put("入职时间", "entryTime");
		headerMapper.put("满勤天数", "fullFrequentlyDay");
		headerMapper.put("出勤天数", "attendanceDay");
		headerMapper.put("加班时间（小时）", "workOvertime");
		headerMapper.put("普通加班天数", "ordinaryOvertime");
		headerMapper.put("法定节假日加班天数", "holidayOvertime");
		headerMapper.put("旷工天数", "absenteeismDays");
		headerMapper.put("病假天数", "sickLeaveDays");
		headerMapper.put("其他缺勤天数", "otherAbsenteeismDays");
		headerMapper.put("底薪", "baseSalary");
		headerMapper.put("加班津贴", "overtimeAllowance");
		headerMapper.put("任务指标", "taskIndicators");
		headerMapper.put("销售业绩", "salesPerformance");
		headerMapper.put("单提业绩", "singlePerformance");
		headerMapper.put("达标率", "successRate");
		headerMapper.put("提成系数", "commissionCoefficient");
		headerMapper.put("达标绩效", "standardPerformance");
		headerMapper.put("提成工资", "cutWages");
		headerMapper.put("加班工资", "overtimeWages");
		headerMapper.put("工龄工资", "seniorityWages");
		headerMapper.put("全勤奖", "perfectAttendance");
		headerMapper.put("社保单位部分", "socialSecurity");
		headerMapper.put("保底补贴", "guaranteedSubsidies");
		headerMapper.put("奖金", "bonus");
		headerMapper.put("应发合计", "shouldCount");
		headerMapper.put("缺勤及旷工", "absenteeism");
		headerMapper.put("水电费", "utilities");
		headerMapper.put("社保费", "socialInsurancePremiums");
		headerMapper.put("押金", "cashPledge");
		headerMapper.put("其他扣款", "otherDeductions");
		headerMapper.put("合计", "count");
		headerMapper.put("实发工资", "lastWages");
		return headerMapper;
	}
}
