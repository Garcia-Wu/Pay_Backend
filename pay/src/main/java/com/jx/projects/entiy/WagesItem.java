package com.jx.projects.entiy;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/** 工资明细类 */
@Entity
@Table(name="pay_hrm_employee")
public class WagesItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/** 姓名 */
	@Column(name="NAME",length=50)
	private String name;
	
	/** 职务 */
	@Column(name="JOB",length=30)
	private String job;
	
	/** 入职时间 */
	@Column(name="ENTRY_TIME")
	@Temporal(TemporalType.DATE)
	private Date entryTime;
	
	/** 所属(公司或分部) */
	@Column(name="AFFILIATION",length=50)
	private String affiliation;
	
	/** 底薪 */
	@Column(name="BASE_SALARY")
	private double baseSalary;
	
	/** 加班津贴*/
	@Column(name="OVERTIME_ALLOWANCE")
	private double overtimeAllowance;
	
	/** 提成工资 */
	@Column(name="CUT_WAGES")
	private double cutWages;

	/** 加班工资 */
	@Column(name="OVERTIME_WAGES")
	private double overtimeWages;
	
	/** 工龄工资 */
	@Column(name="SENIORITY_WAGES")
	private int seniorityWages;
	
	/** 满勤天数 */
	@Column(name="FULL_FREQUENTLY_DAY")
	private double fullFrequentlyDay;
	
	/** 出勤天数 */
	@Column(name="ATTENDANCE_DAY")
	private double attendanceDay;
	
	/** 加班时间(小时) */
	@Column(name="WORK_OVERTIME")
	private double workOvertime;
	
	/** 普通加班天数 */
	@Column(name="ORDINARY_OVERTIME")
	private double ordinaryOvertime;
	
	/** 节日加班天数 */
	@Column(name="HOLIDAY_OVERTIME")
	private double holidayOvertime;
	
	/** 旷工天数 */
	@Column(name="ABSENTEEISM_DAYS")
	private double absenteeismDays;

	/** 病假天数 */
	@Column(name="SICK_LEAVE_DAYS")
	private double sickLeaveDays;
	
	/** 其他缺勤天数 */
	@Column(name="OTHER_ABSENTEEISM_DAYS")
	private double otherAbsenteeismDays;

	/** 全勤奖 */
	@Column(name="PERFECT_ATTENDANCE")
	private int perfectAttendance;
	
	/** 社保单位部分 */
	@Column(name="SOCIAL_SECURITY")
	private double socialSecurity;
	
	/** 保底补贴 */
	@Column(name="GUARANTEED_SUBSIDIES")
	private double guaranteedSubsidies;
	
	/** 奖金 */
	@Column(name="BONUS")
	private double bonus;

	/** 任务指标 */
	@Column(name="TASK_INDICATORS")
	private double taskIndicators;

	/** 销售业绩 */
	@Column(name="SALES_PERFORMANCE")
	private double salesPerformance;

	/** 单提业绩 */
	@Column(name="SINGLE_PERFORMANCE")
	private double singlePerformance;
	
	/** 达标率 */
	@Column(name="SUCCESS_RATE")
	private double successRate;
	
	/** 提成系数 */
	@Column(name="COMMISSION_COEFFICIENT")
	private double commissionCoefficient;
	
	/** 达标绩效 */
	@Column(name="STANDARD_PERFORMANCE")
	private double standardPerformance;
	
	/** 缺勤以及旷工 */
	@Column(name="ABSENTEEISM")
	private double absenteeism;
	
	/** 水电费 */
	@Column(name="UTILITIES")
	private double utilities;
	
	/** 社保费 */
	@Column(name="SOCIAL_INSURANCE_PREMIUMS")
	private double socialInsurancePremiums;
	
	/** 押金 */
	@Column(name="CASH_PLEDGE")
	private double cashPledge;
	
	/** 其他扣款 */
	@Column(name="OTHER_DEDUCTIONS")
	private double otherDeductions;
	
	/** 所属月份 */
	@Column(name="DATES")
	@Temporal(TemporalType.DATE)
	private Date dates;
	
	/** 应发合计 */
	@Column(name="SHOULD_COUNT")
	private double shouldCount;

	/** 应扣款项合计 */
	@Column(name="COUNT")
	private double count;
	
	/** 实发工资 */
	@Column(name="LAST_WAGES")
	private double lastWages;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public double getOvertimeAllowance() {
		return overtimeAllowance;
	}

	public void setOvertimeAllowance(double overtimeAllowance) {
		this.overtimeAllowance = overtimeAllowance;
	}

	public double getCutWages() {
		return cutWages;
	}

	public void setCutWages(double cutWages) {
		this.cutWages = cutWages;
	}

	public double getOvertimeWages() {
		return overtimeWages;
	}

	public void setOvertimeWages(double overtimeWages) {
		this.overtimeWages = overtimeWages;
	}

	public int getSeniorityWages() {
		return seniorityWages;
	}

	public void setSeniorityWages(int seniorityWages) {
		this.seniorityWages = seniorityWages;
	}

	public double getFullFrequentlyDay() {
		return fullFrequentlyDay;
	}

	public void setFullFrequentlyDay(double fullFrequentlyDay) {
		this.fullFrequentlyDay = fullFrequentlyDay;
	}

	public double getAttendanceDay() {
		return attendanceDay;
	}

	public void setAttendanceDay(double attendanceDay) {
		this.attendanceDay = attendanceDay;
	}

	public double getWorkOvertime() {
		return workOvertime;
	}

	public void setWorkOvertime(double workOvertime) {
		this.workOvertime = workOvertime;
	}

	public double getOrdinaryOvertime() {
		return ordinaryOvertime;
	}

	public void setOrdinaryOvertime(double ordinaryOvertime) {
		this.ordinaryOvertime = ordinaryOvertime;
	}

	public double getHolidayOvertime() {
		return holidayOvertime;
	}

	public void setHolidayOvertime(double holidayOvertime) {
		this.holidayOvertime = holidayOvertime;
	}

	public double getAbsenteeismDays() {
		return absenteeismDays;
	}

	public void setAbsenteeismDays(double absenteeismDays) {
		this.absenteeismDays = absenteeismDays;
	}

	public double getSickLeaveDays() {
		return sickLeaveDays;
	}

	public void setSickLeaveDays(double sickLeaveDays) {
		this.sickLeaveDays = sickLeaveDays;
	}

	public double getOtherAbsenteeismDays() {
		return otherAbsenteeismDays;
	}

	public void setOtherAbsenteeismDays(double otherAbsenteeismDays) {
		this.otherAbsenteeismDays = otherAbsenteeismDays;
	}

	public int getPerfectAttendance() {
		return perfectAttendance;
	}

	public void setPerfectAttendance(int perfectAttendance) {
		this.perfectAttendance = perfectAttendance;
	}

	public double getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(double socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	public double getGuaranteedSubsidies() {
		return guaranteedSubsidies;
	}

	public void setGuaranteedSubsidies(double guaranteedSubsidies) {
		this.guaranteedSubsidies = guaranteedSubsidies;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getTaskIndicators() {
		return taskIndicators;
	}

	public void setTaskIndicators(double taskIndicators) {
		this.taskIndicators = taskIndicators;
	}

	public double getSalesPerformance() {
		return salesPerformance;
	}

	public void setSalesPerformance(double salesPerformance) {
		this.salesPerformance = salesPerformance;
	}

	public double getSinglePerformance() {
		return singlePerformance;
	}

	public void setSinglePerformance(double singlePerformance) {
		this.singlePerformance = singlePerformance;
	}

	public double getSuccessRate() {
		return successRate;
	}

	public void setSuccessRate(double successRate) {
		this.successRate = successRate;
	}

	public double getCommissionCoefficient() {
		return commissionCoefficient;
	}

	public void setCommissionCoefficient(double commissionCoefficient) {
		this.commissionCoefficient = commissionCoefficient;
	}

	public double getStandardPerformance() {
		return standardPerformance;
	}

	public void setStandardPerformance(double standardPerformance) {
		this.standardPerformance = standardPerformance;
	}

	public double getAbsenteeism() {
		return absenteeism;
	}

	public void setAbsenteeism(double absenteeism) {
		this.absenteeism = absenteeism;
	}

	public double getUtilities() {
		return utilities;
	}

	public void setUtilities(double utilities) {
		this.utilities = utilities;
	}

	public double getSocialInsurancePremiums() {
		return socialInsurancePremiums;
	}

	public void setSocialInsurancePremiums(double socialInsurancePremiums) {
		this.socialInsurancePremiums = socialInsurancePremiums;
	}

	public double getCashPledge() {
		return cashPledge;
	}

	public void setCashPledge(double cashPledge) {
		this.cashPledge = cashPledge;
	}

	public double getOtherDeductions() {
		return otherDeductions;
	}

	public void setOtherDeductions(double otherDeductions) {
		this.otherDeductions = otherDeductions;
	}

	public Date getDates() {
		return dates;
	}

	public void setDates(Date dates) {
		this.dates = dates;
	}

	public double getShouldCount() {
		return shouldCount;
	}

	public void setShouldCount(double shouldCount) {
		this.shouldCount = shouldCount;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}

	public double getLastWages() {
		return lastWages;
	}

	public void setLastWages(double lastWages) {
		this.lastWages = lastWages;
	}

	@Override
	public String toString() {
		return "WagesItem [id=" + id + ", name=" + name + ", job=" + job + ", entryTime=" + entryTime + ", affiliation="
				+ affiliation + ", baseSalary=" + baseSalary + ", overtimeAllowance=" + overtimeAllowance
				+ ", cutWages=" + cutWages + ", overtimeWages=" + overtimeWages + ", seniorityWages=" + seniorityWages
				+ ", fullFrequentlyDay=" + fullFrequentlyDay + ", attendanceDay=" + attendanceDay + ", workOvertime="
				+ workOvertime + ", ordinaryOvertime=" + ordinaryOvertime + ", holidayOvertime=" + holidayOvertime
				+ ", absenteeismDays=" + absenteeismDays + ", sickLeaveDays=" + sickLeaveDays
				+ ", otherAbsenteeismDays=" + otherAbsenteeismDays + ", perfectAttendance=" + perfectAttendance
				+ ", socialSecurity=" + socialSecurity + ", guaranteedSubsidies=" + guaranteedSubsidies + ", bonus="
				+ bonus + ", taskIndicators=" + taskIndicators + ", salesPerformance=" + salesPerformance
				+ ", singlePerformance=" + singlePerformance + ", successRate=" + successRate
				+ ", commissionCoefficient=" + commissionCoefficient + ", standardPerformance=" + standardPerformance
				+ ", absenteeism=" + absenteeism + ", utilities=" + utilities + ", socialInsurancePremiums="
				+ socialInsurancePremiums + ", cashPledge=" + cashPledge + ", otherDeductions=" + otherDeductions
				+ ", dates=" + dates + ", shouldCount=" + shouldCount + ", count=" + count + ", lastWages=" + lastWages
				+ "]";
	}

}
