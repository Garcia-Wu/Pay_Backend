package com.jx.projects.util;

import com.jx.projects.entiy.WagesItem;

/** 计算工资工具类 */
public class CalcWagesUtils {
	
	/** 其他缺勤天数 */
	private static double otherAbsenteeismDays;
	/** 达标率 */
	private static double successRate;
	/** 提成工资 */
	private static double cutWages;
	/** 加班工资 */
	private static double overtimeWages;
	/** 全勤奖 */
	private static int perfectAttendance; 
	/** 提成系数 */
	private static double commissionCoefficient; 
	/** 达标绩效 */
	private static double standardPerformance; 
	/** 保底补贴 */
	private static double guaranteedSubsidies; 
	/** 应发合计 */
	private static double shouldCount;
	/** 缺勤及旷工 */
	private static double absenteeism;
	/** 应扣款项合计 */
	private static double count;
	/** 实发工资 */
	private static double lastWages;

	/** 计算所有项目并赋值 */
	public static void calcWages(WagesItem wagesItem) {
		try {
			// 计算所有需要计算的项目
			otherAbsenteeismDays = calcOtherAbsenteeismDays(wagesItem.getFullFrequentlyDay(), wagesItem.getAttendanceDay(), wagesItem.getAbsenteeismDays(), wagesItem.getSickLeaveDays());
			successRate = calcSuccessRate(wagesItem.getSalesPerformance(), wagesItem.getSinglePerformance(), wagesItem.getTaskIndicators());
			cutWages = calcCutWages(wagesItem.getSalesPerformance(), wagesItem.getCommissionCoefficient());
			overtimeWages = calcOvertimeWages(wagesItem.getWorkOvertime(), wagesItem.getBaseSalary(), wagesItem.getFullFrequentlyDay(), wagesItem.getOrdinaryOvertime(), wagesItem.getHolidayOvertime()); 
			perfectAttendance = calcPerfectAttendance(wagesItem.getFullFrequentlyDay(), wagesItem.getAttendanceDay());
			// 如果达标率不为 0,再进行计算提成系数以及达标绩效
			if(successRate != 0.0){
				commissionCoefficient = calcCommissionCoefficient(successRate);
				standardPerformance = calcStandardPerformance(successRate);
			}
			// 如果满勤不为0,再进行计算保底补贴以及缺勤旷工
			if(wagesItem.getFullFrequentlyDay() != 0.0){
				guaranteedSubsidies = calcGuaranteedSubsidies(standardPerformance, cutWages, wagesItem.getFullFrequentlyDay(), wagesItem.getAttendanceDay());
				absenteeism = calcAbsenteeism(wagesItem.getAbsenteeismDays(), wagesItem.getSickLeaveDays(), otherAbsenteeismDays, wagesItem.getBaseSalary(), wagesItem.getOvertimeAllowance(), standardPerformance, wagesItem.getFullFrequentlyDay());
			}
			shouldCount = calcShouldCount(wagesItem.getBaseSalary(), wagesItem.getOvertimeAllowance(), standardPerformance, cutWages, overtimeWages, wagesItem.getSeniorityWages(), perfectAttendance, wagesItem.getSocialSecurity(),guaranteedSubsidies ,wagesItem.getBonus());
			count = calcCount(absenteeism, wagesItem.getUtilities(), wagesItem.getSocialInsurancePremiums(), wagesItem.getCashPledge(), wagesItem.getOtherDeductions());
			lastWages = calcLastWages(shouldCount, count);
			
			// 赋值
			wagesItem.setOtherAbsenteeismDays(otherAbsenteeismDays);
			wagesItem.setSuccessRate(successRate);
			wagesItem.setCutWages(cutWages);
			wagesItem.setOvertimeWages(overtimeWages);
			wagesItem.setPerfectAttendance(perfectAttendance);
			wagesItem.setCommissionCoefficient(commissionCoefficient);
			wagesItem.setStandardPerformance(standardPerformance);
			wagesItem.setGuaranteedSubsidies(guaranteedSubsidies);
			wagesItem.setShouldCount(shouldCount);
			wagesItem.setAbsenteeism(absenteeism);
			wagesItem.setCount(count);
			wagesItem.setLastWages(lastWages);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PayException("计算赋值过程出现异常！");
		}
	}
	
	/** 
	 * 计算其他缺勤天数
	 * @param fullFrequentlyDay 满勤
	 * @param attendanceDay 出勤
	 * @param absenteeismDays  旷工
	 * @param sickLeaveDays  病假
	 * 其他缺勤天数 = 满勤 - 出勤 - 旷工 - 病假
	 *  */
	public static double calcOtherAbsenteeismDays(double fullFrequentlyDay, double attendanceDay,
			double absenteeismDays, double sickLeaveDays) {
		
		return fullFrequentlyDay - attendanceDay - absenteeismDays - sickLeaveDays;
	}
	
	/**
	 * 计算达标率
	 * @param salesPerformance 销售业绩
	 * @param singlePerformance 单提业绩
	 * @param taskIndicators  任务指标
	 * 达标率 = ( 销售业绩 + 单提业绩 ) / 任务指标
	 */
	public static double calcSuccessRate(double salesPerformance, double singlePerformance, double taskIndicators) {
		// 乘以1000除以1000 用于保留三位小数   乘以100为100%
		return Math.round((salesPerformance + singlePerformance) / taskIndicators * 1000) * 100 / 1000.0;
	}
	
	/**
	 * 计算提成工资
	 * @param salesPerformance 销售业绩
	 * @param commissionCoefficient  提成系数
	 * 提成工资 = 销售业绩 * 提成系数 (四舍五入为整数)
	 */
	public static double calcCutWages(double salesPerformance, double commissionCoefficient) {
		// 提成系数为去掉'%'直接拿到的字符串,所以需除以10000
		return Math.round(salesPerformance * (commissionCoefficient / 10000));
	}
	
	/**
	 * 计算加班工资
	 * @param workOvertime 加班时间
	 * @param baseSalary 底薪
	 * @param fullFrequentlyDay 满勤天数
	 * @param ordinaryOvertime 普通加班天数
	 * @param holidayOvertime  节假日加班
	 * 加班工资 = 6 * 加班时间 + 底薪 / 满勤天数 * 普通加班天数 + 底薪 / 满勤天数 * 节假日加班 * 2 (四舍五入为整数)
	 */
	public static double calcOvertimeWages(double workOvertime, double baseSalary,
			double fullFrequentlyDay, double ordinaryOvertime,  double holidayOvertime) {
		// 计算并四舍五入
		return Math.round( 6 * workOvertime + baseSalary / fullFrequentlyDay * ordinaryOvertime + baseSalary / fullFrequentlyDay * holidayOvertime * 2);
	}
	
	/** 计算是否有全勤奖
	 * @param fullFrequentlyDay 满勤天数
	 * @param attendanceDay 出勤天数
	 * 如果  满勤天数 = 出勤天数 ,则有全勤奖(100)
	 *  */
	public static int calcPerfectAttendance(double fullFrequentlyDay, double attendanceDay){
		if( fullFrequentlyDay == attendanceDay ){
			return 100;
		}else{
			return 0;
		}
	}
	
	/** 根据达标率计算提成系数 */
	public static double calcCommissionCoefficient(double successRate) {
		double result = 0.0;
		if(successRate >=0 && successRate < 80){
			result = 4.1;
		}else if(successRate >= 80 && successRate < 100){
			result = 4.2;
		}else if(successRate >= 100 && successRate < 110){
			result = 4.4;
		}else if(successRate >= 110 && successRate < 120){
			result = 4.6;
		}else if(successRate >= 120 && successRate < 140){
			result = 4.7;
		}else if(successRate >= 140){
			result = 4.9;
		}
		return result;
	}
	
	/** 根据达标率计算达标绩效 */
	public static double calcStandardPerformance(double successRate) {
		double result = 0.0;
		if(successRate >=0 && successRate < 80){
			result = -150;
		}else if(successRate >= 80 && successRate < 100){
			result = -100;
		}else if(successRate >= 100 && successRate < 110){
			result = 100;
		}else if(successRate >= 110 && successRate < 120){
			result = 200;
		}else if(successRate >= 120 && successRate < 140){
			result = 300;
		}else if(successRate >= 140){
			result = 400;
		}
		return result;
	}
	
	/**
	 * 计算保底补贴
	 * @param standardPerformance 达标绩效
	 * @param cutWages 提成工资
	 * @param fullFrequentlyDay 满勤天数
	 * @param attendanceDay 出勤天数
	 * 保底补贴 = 如果 "(达标绩效 + 提成工资) < 800 / 满勤*出勤 " 则计算 "800 / 满勤*出勤 - (达标绩效 + 提成工资)"; 否则为0(四舍五入为整数)
	 */
	public static double calcGuaranteedSubsidies(double standardPerformance, double cutWages, double fullFrequentlyDay, double attendanceDay) {
		double result = 0.0;
		if(standardPerformance + cutWages < 800 / fullFrequentlyDay * attendanceDay){
			result = Math.round(800 / fullFrequentlyDay * attendanceDay - (standardPerformance + cutWages));
		}
		return result;
	}
	
	/** 
	 * 计算应发合计
	 * @param baseSalary 底薪
	 * @param overtimeAllowance 加班津贴
	 * @param standardPerformance  达标绩效
	 * @param cutWages  提成工资 
	 * @param overtimeWages  加班工资
	 * @param seniorityWages  工龄工资
	 * @param perfectAttendance  全勤奖
	 * @param socialSecurity  社保单位部分
	 * @param guaranteedSubsidies  保底补贴
	 * @param bonus  奖金
	 * 应发合计 = 底薪 + 加班津贴 + 达标绩效 + 提成工资 + 加班工资 + 工龄工资 + 全勤奖 + 社保单位部分 + 保底补贴 + 奖金 (四舍五入取整)
	 *  */
	public static double calcShouldCount(double baseSalary, double overtimeAllowance, double standardPerformance,
			double cutWages, double overtimeWages, int seniorityWages, int perfectAttendance, double socialSecurity,
			double guaranteedSubsidies, double bonus) {
		double result = baseSalary + overtimeAllowance + standardPerformance + cutWages + overtimeWages + seniorityWages 
				+ perfectAttendance + socialSecurity + guaranteedSubsidies + bonus;
		return Math.round(result);
	}

	/** 
	 * 计算缺勤及旷工
	 * @param absenteeismDays 旷工
	 * @param sickLeaveDays 病假
	 * @param otherAbsenteeismDays 其他缺勤天数
	 * @param baseSalary  底薪 
	 * @param overtimeAllowance  加班津贴
	 * @param standardPerformance  达标绩效
	 * @param fullFrequentlyDay  满勤天数
	 * 缺勤及旷工 
	 * 	 如果  
	 * 		旷工 + 病假 + 其他缺勤天数 > 4
	 * 	 则计算
	 * 		(底薪 + 加班津贴 + 达标绩效) / 满勤天数  * 旷工 * 3 + (底薪 + 加班津贴 + 达标绩效) / 满勤天数  * 病假 * 0.5 + (底薪 + 加班津贴 + 达标绩效) / 满勤天数  * 其他缺勤天数
	 *	 否则计算
	 *  	底薪 / 满勤 * 旷工 * 3 + 底薪 / 满勤 * 病假 * 0.5 + 底薪 / 满勤 * 其他缺勤天数
	 *  (结果四舍五入取整)
	 *  */
	public static double calcAbsenteeism(double absenteeismDays, double sickLeaveDays, double otherAbsenteeismDays,
			double baseSalary, double overtimeAllowance, double standardPerformance, double fullFrequentlyDay) {
		double result = 0.0;
		if(absenteeismDays + sickLeaveDays + otherAbsenteeismDays > 4){
			result = (baseSalary + overtimeAllowance + standardPerformance) / fullFrequentlyDay * absenteeismDays * 3
					 + (baseSalary + overtimeAllowance + standardPerformance) / fullFrequentlyDay * sickLeaveDays * 0.5
					 + (baseSalary + overtimeAllowance + standardPerformance) / fullFrequentlyDay * otherAbsenteeismDays;
		}else{
			result = baseSalary / fullFrequentlyDay * absenteeismDays * 3 
					+ baseSalary / fullFrequentlyDay * sickLeaveDays * 0.5
					+ baseSalary / fullFrequentlyDay * otherAbsenteeismDays;
		}
		return Math.round(result);
	}
	
	/** 
	 * 计算应扣款项合计
	 * @param absenteeism 缺勤及旷工
	 * @param utilities 水电费
	 * @param socialInsurancePremiums 社保费
	 * @param cashPledge  押金
	 * @param otherDeductions  其他扣款
	 *  应扣款项合计 = 缺勤及旷工 + 水电费 + 社保费 + 押金 + 其他扣款
	 *  */
	public static double calcCount(double absenteeism, double utilities, double socialInsurancePremiums,
			double cashPledge, double otherDeductions) {
		return absenteeism + utilities + socialInsurancePremiums + cashPledge + otherDeductions;
	}

	/** 
	 * 计算实发工资
	 * @param shouldCount 应发合计
	 * @param count 应扣合计
	 *  实发工资 = 应发合计 - 应扣合计
	 * */
	private static double calcLastWages(double shouldCount, double count) {
		return shouldCount - count;
	}



}
