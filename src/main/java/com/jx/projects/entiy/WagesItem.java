package com.jx.projects.entiy;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/** 工资明细类 */
@Entity
@Table(name="wages_item")
@Data
public class WagesItem extends BaseEntiy{
	
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
	
	/** 对应公司 */
	@ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name="company_id")
	private Company company;

}
