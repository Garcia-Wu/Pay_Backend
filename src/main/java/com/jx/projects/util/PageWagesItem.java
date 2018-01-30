package com.jx.projects.util;

/** 接收页面参数类 */
public class PageWagesItem {
	
	/** 姓名 */
	private String pageName;
	
	/** 职务 */
	private String pageJob;
	
	/** 入职时间 */
	private String pageEntryTime;

	/** 满勤天数 */
	private String pageFullFrequentlyDay;
	
	/** 出勤天数 */
	private String pageAttendanceDay;
	
	/** 加班时间(小时) */
	private String pageWorkOvertime;
	
	/** 普通加班天数 */
	private String pageOrdinaryOvertime;
	
	/** 节日加班天数 */
	private String pageHolidayOvertime;
	
	/** 旷工天数 */
	private String pageAbsenteeismDays;

	/** 病假天数 */
	private String pageSickLeaveDays;
	
	/** 底薪 */
	private String pageBaseSalary;
	
	/** 加班津贴*/
	private String pageOvertimeAllowance;
	
	/** 任务指标 */
	private String pageTaskIndicators;

	/** 销售业绩 */
	private String pageSalesPerformance;

	/** 单提业绩 */
	private String pageSinglePerformance;
	
	/** 工龄工资 */
	private String pageSeniorityWages;
	
	/** 社保单位部分 */
	private String pageSocialSecurity;
	
	/** 奖金 */
	private String pageBonus;
	
	/** 水电费 */
	private String pageUtilities;
	
	/** 社保费 */
	private String pageSocialInsurancePremiums;
	
	/** 押金 */
	private String pageCashPledge;
	
	/** 其他扣款 */
	private String pageOtherDeductions;

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPageJob() {
		return pageJob;
	}

	public void setPageJob(String pageJob) {
		this.pageJob = pageJob;
	}

	public String getPageEntryTime() {
		return pageEntryTime;
	}

	public void setPageEntryTime(String pageEntryTime) {
		this.pageEntryTime = pageEntryTime;
	}

	public String getPageFullFrequentlyDay() {
		return pageFullFrequentlyDay;
	}

	public void setPageFullFrequentlyDay(String pageFullFrequentlyDay) {
		this.pageFullFrequentlyDay = pageFullFrequentlyDay;
	}

	public String getPageAttendanceDay() {
		return pageAttendanceDay;
	}

	public void setPageAttendanceDay(String pageAttendanceDay) {
		this.pageAttendanceDay = pageAttendanceDay;
	}

	public String getPageWorkOvertime() {
		return pageWorkOvertime;
	}

	public void setPageWorkOvertime(String pageWorkOvertime) {
		this.pageWorkOvertime = pageWorkOvertime;
	}

	public String getPageOrdinaryOvertime() {
		return pageOrdinaryOvertime;
	}

	public void setPageOrdinaryOvertime(String pageOrdinaryOvertime) {
		this.pageOrdinaryOvertime = pageOrdinaryOvertime;
	}

	public String getPageHolidayOvertime() {
		return pageHolidayOvertime;
	}

	public void setPageHolidayOvertime(String pageHolidayOvertime) {
		this.pageHolidayOvertime = pageHolidayOvertime;
	}

	public String getPageAbsenteeismDays() {
		return pageAbsenteeismDays;
	}

	public void setPageAbsenteeismDays(String pageAbsenteeismDays) {
		this.pageAbsenteeismDays = pageAbsenteeismDays;
	}

	public String getPageSickLeaveDays() {
		return pageSickLeaveDays;
	}

	public void setPageSickLeaveDays(String pageSickLeaveDays) {
		this.pageSickLeaveDays = pageSickLeaveDays;
	}

	public String getPageBaseSalary() {
		return pageBaseSalary;
	}

	public void setPageBaseSalary(String pageBaseSalary) {
		this.pageBaseSalary = pageBaseSalary;
	}

	public String getPageOvertimeAllowance() {
		return pageOvertimeAllowance;
	}

	public void setPageOvertimeAllowance(String pageOvertimeAllowance) {
		this.pageOvertimeAllowance = pageOvertimeAllowance;
	}

	public String getPageTaskIndicators() {
		return pageTaskIndicators;
	}

	public void setPageTaskIndicators(String pageTaskIndicators) {
		this.pageTaskIndicators = pageTaskIndicators;
	}

	public String getPageSalesPerformance() {
		return pageSalesPerformance;
	}

	public void setPageSalesPerformance(String pageSalesPerformance) {
		this.pageSalesPerformance = pageSalesPerformance;
	}

	public String getPageSinglePerformance() {
		return pageSinglePerformance;
	}

	public void setPageSinglePerformance(String pageSinglePerformance) {
		this.pageSinglePerformance = pageSinglePerformance;
	}

	public String getPageSeniorityWages() {
		return pageSeniorityWages;
	}

	public void setPageSeniorityWages(String pageSeniorityWages) {
		this.pageSeniorityWages = pageSeniorityWages;
	}

	public String getPageSocialSecurity() {
		return pageSocialSecurity;
	}

	public void setPageSocialSecurity(String pageSocialSecurity) {
		this.pageSocialSecurity = pageSocialSecurity;
	}

	public String getPageBonus() {
		return pageBonus;
	}

	public void setPageBonus(String pageBonus) {
		this.pageBonus = pageBonus;
	}

	public String getPageUtilities() {
		return pageUtilities;
	}

	public void setPageUtilities(String pageUtilities) {
		this.pageUtilities = pageUtilities;
	}

	public String getPageSocialInsurancePremiums() {
		return pageSocialInsurancePremiums;
	}

	public void setPageSocialInsurancePremiums(String pageSocialInsurancePremiums) {
		this.pageSocialInsurancePremiums = pageSocialInsurancePremiums;
	}

	public String getPageCashPledge() {
		return pageCashPledge;
	}

	public void setPageCashPledge(String pageCashPledge) {
		this.pageCashPledge = pageCashPledge;
	}

	public String getPageOtherDeductions() {
		return pageOtherDeductions;
	}

	public void setPageOtherDeductions(String pageOtherDeductions) {
		this.pageOtherDeductions = pageOtherDeductions;
	}

	@Override
	public String toString() {
		return "PageWagesItem [pageName=" + pageName + ", pageJob=" + pageJob + ", pageEntryTime=" + pageEntryTime
				+ ", pageFullFrequentlyDay=" + pageFullFrequentlyDay + ", pageAttendanceDay=" + pageAttendanceDay
				+ ", pageWorkOvertime=" + pageWorkOvertime + ", pageOrdinaryOvertime=" + pageOrdinaryOvertime
				+ ", pageHolidayOvertime=" + pageHolidayOvertime + ", pageAbsenteeismDays=" + pageAbsenteeismDays
				+ ", pageSickLeaveDays=" + pageSickLeaveDays + ", pageBaseSalary=" + pageBaseSalary
				+ ", pageOvertimeAllowance=" + pageOvertimeAllowance + ", pageTaskIndicators=" + pageTaskIndicators
				+ ", pageSalesPerformance=" + pageSalesPerformance + ", pageSinglePerformance=" + pageSinglePerformance
				+ ", pageSeniorityWages=" + pageSeniorityWages + ", pageSocialSecurity=" + pageSocialSecurity
				+ ", pageBonus=" + pageBonus + ", pageUtilities=" + pageUtilities + ", pageSocialInsurancePremiums="
				+ pageSocialInsurancePremiums + ", pageCashPledge=" + pageCashPledge + ", pageOtherDeductions="
				+ pageOtherDeductions + "]";
	}
	
}
