<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>办公管理系统-添加用户</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache, must-revalidate" />
<meta name="Keywords" content="keyword1,keyword2,keyword3" />
<meta name="Description" content="网页信息的描述" />
<meta name="Author" content="fkjava.org" />
<meta name="Copyright" content="All Rights Reserved." />
<link rel="stylesheet"
	href="${ctx }/resources/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript"
	src="${ctx }/resources/jquery/jquery-1.11.0.min.js"></script>
<script type="text/javascript"
	src="${ctx }/resources/jquery/jquery-migrate-1.2.1.min.js"></script>
<!-- 导入bootStrap的库 -->
<script type="text/javascript"
	src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${ctx}/resources/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${ctx}/resources/easyUI/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${ctx}/resources/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="${ctx}/resources/easyUI/easyui.css">
<script type="text/javascript">
	$(function() {
		
		// 如果有提示就弹出来 
		if("${message}"){
			top.$.messager.show({
				title:'操作提示',
				msg:'<span style="color: #11a9e2;">${message}</span>',
				timeout:3000,
				showType:'show'
			});
		}
		
		/**  修改信息，提交表单函数 */
		$("#btn_submit").click(function() {
			// 对表单中所有字段做校验
			var name = $("#pageName");
			var job = $("#pageJob");
			// 任务指标
			var taskIndicators = $("#pageTaskIndicators");
			// 销售业绩
			var salesPerformance = $("#pageSalesPerformance");
			// 单提业绩
			var singlePerformance = $("#pageSinglePerformance");
			var msg = "";
			if ($.trim(name.val()) == "") {
				msg += "姓名不能为空!";
				name.focus();
			} else if ($.trim(job.val()) == "") {
				msg += "职务不能为空!";
				job.focus();
			} else if ($.trim(taskIndicators.val()) == "" && ($.trim(salesPerformance.val()) != "" || $.trim(singlePerformance.val()) != "")) {
				msg += "存在销售业绩或单提业绩时, 任务指标不能为空！";
				taskIndicators.focus();
			}
		
			if(msg){
				$.messager.alert('提示信息',msg,'info');
			}else{
				$("#updateUserForm").submit();
			}

		});
	});
</script>
</head>
<body style="background: #F5FAFA;">
	<center>
		<form id="updateUserForm" action="${ctx}/hrm/updateWages?index=${index}"
			method="post">
			<table class="table-condensed">
				<tbody>
					<tr>
						<td><span class="label label-primary">员工信息</span></td>
						<td align="right"><label>姓名:</label></td>
						<td><input type="text" id="pageName" name="pageName"
							value="${wagesItem.name}" class="form-control" placeholder="请输入姓名"></td>
						<td align="right"><label>职务:</label></td>
						<td><input type="text" id="pageJob" name="pageJob"
							value="${wagesItem.job}" class="form-control" placeholder="请输入职务"></td>
						<td align="right"><label>入职时间:</label></td>
						<td><input type="text" id="pageEntryTime" name="pageEntryTime" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy/MM/dd'});"
							value="<fmt:formatDate value='${wagesItem.entryTime}' pattern='yyyy/mm/dd'/>" class="form-control" placeholder="请选择时间"></td>
					</tr>
					<tr>
						<td><span class="label label-primary">考勤</span></td>
						<td align="right"><label>满勤天数:</label></td>
						<td><input type="text" id="pageFullFrequentlyDay" name="pageFullFrequentlyDay"
							value="<c:if test='${wagesItem.fullFrequentlyDay != 0.0}'>${fn:replace(wagesItem.fullFrequentlyDay+'','.0','')}</c:if>" class="form-control" placeholder="满勤天数"></td>
						<td align="right"><label>出勤天数:</label></td>
						<td><input type="text" id="pageAttendanceDay" name="pageAttendanceDay"
							value="<c:if test='${wagesItem.attendanceDay != 0.0}'>${fn:replace(wagesItem.attendanceDay+'','.0','')}</c:if>" class="form-control" placeholder="出勤天数"></td>
						<td align="right"><label>加班时间(小时):</label></td>
						<td><input type="text" id="pageWorkOvertime" name="pageWorkOvertime"
							value="<c:if test='${wagesItem.workOvertime != 0.0}'>${wagesItem.workOvertime}</c:if>" class="form-control" placeholder="加班时间(小时)"></td>
					</tr>
					<tr>
						<td></td>
						<td align="right"><label>普通加班天数:</label></td>
						<td><input type="text" id="pageOrdinaryOvertime" name="pageOrdinaryOvertime"
							value="<c:if test='${wagesItem.ordinaryOvertime != 0.0}'>${fn:replace(wagesItem.ordinaryOvertime+'','.0','')}</c:if>" class="form-control" placeholder="普通加班天数"></td>
						<td align="right"><label>法定节假日加班天数:</label></td>
						<td><input type="text" id="pageHolidayOvertime" name="pageHolidayOvertime"
							value="<c:if test='${wagesItem.holidayOvertime != 0.0}'>${fn:replace(wagesItem.holidayOvertime+'','.0','')}</c:if>" class="form-control" placeholder="法定节假日加班天数"></td>
						<td align="right"><label>旷工天数:</label></td>
						<td><input type="text" id="pageAbsenteeismDays" name="pageAbsenteeismDays"
							value="<c:if test='${wagesItem.absenteeismDays != 0.0}'>${fn:replace(wagesItem.absenteeismDays+'','.0','')}</c:if>" class="form-control" placeholder="旷工天数"></td>
					</tr>
					<tr>
						<td></td>
						<td align="right"><label>病假天数:</label></td>
						<td><input type="text" id="pageSickLeaveDays" name="pageSickLeaveDays"
							value="<c:if test='${wagesItem.sickLeaveDays != 0.0}'>${fn:replace(wagesItem.sickLeaveDays+'','.0','')}</c:if>" class="form-control" placeholder="病假天数"></td>
						<td align="right"><label>其他缺勤天数:</label></td>
						<td><span class="label label-info"><c:if test='${wagesItem.otherAbsenteeismDays != 0.0}'>${wagesItem.otherAbsenteeismDays}</c:if></span></td>
					</tr>
					<tr>
						<td><span class="label label-primary">固定工资</span></td>
						<td align="right"><label>底薪:</label></td>
						<td><input type="text" id="pageBaseSalary" name="pageBaseSalary"
							value="<c:if test='${wagesItem.baseSalary != 0.0}'>${fn:replace(wagesItem.baseSalary+'','.0','')}</c:if>" class="form-control" placeholder="底薪"></td>
						<td align="right"><label>加班津贴:</label></td>
						<td><input type="text" id="pageOvertimeAllowance" name="pageOvertimeAllowance"
							value="<c:if test='${wagesItem.overtimeAllowance != 0.0}'>${fn:replace(wagesItem.overtimeAllowance+'','.0','')}</c:if>" class="form-control" placeholder="加班津贴"></td>
					</tr>
					<tr>
						<td><span class="label label-primary">销售明细</span></td>
						<td align="right"><label>任务指标:</label></td>
						<td><input type="text" id="pageTaskIndicators" name="pageTaskIndicators"
							value="<c:if test='${wagesItem.taskIndicators != 0.0}'>${fn:replace(wagesItem.taskIndicators+'','.0','')}</c:if>" class="form-control" placeholder="任务指标"></td>
						<td align="right"><label>销售业绩:</label></td>
						<td><input type="text" id="pageSalesPerformance" name="pageSalesPerformance"
							value="<c:if test='${wagesItem.salesPerformance != 0.0}'>${fn:replace(wagesItem.salesPerformance+'','.0','')}</c:if>" class="form-control" placeholder="销售业绩"></td>
						<td align="right"><label>单提业绩:</label></td>
						<td><input type="text" id="pageSinglePerformance" name="pageSinglePerformance"
							value="<c:if test='${wagesItem.singlePerformance != 0.0}'>${fn:replace(wagesItem.singlePerformance+'','.0','')}</c:if>" class="form-control" placeholder="单提业绩"></td>
					</tr>
					<tr>
						<td></td>
						<td align="right"><label>达标率:</label></td>
						<td><span class="label label-info"><c:if test="${wagesItem.successRate != 0.0}">${wagesItem.successRate}%</c:if></span></td>
						<td align="right"><label>提成系数:</label></td>
						<td><span class="label label-info"><c:if test="${wagesItem.commissionCoefficient != 0.0}"><fmt:formatNumber pattern="0.00" value="${wagesItem.commissionCoefficient}"/>%</c:if></span></td>
					</tr>
					<tr>
						<td><span class="label label-primary">浮动工资</span></td>
						<td align="right"><label>达标绩效:</label></td>
						<td><span class="label label-info"><c:if test='${wagesItem.standardPerformance != 0.0}'>${fn:replace(wagesItem.standardPerformance+'','.0','')}</c:if></span></td>
						<td align="right"><label>提成工资:</label></td>
						<td><span class="label label-info"><c:if test='${wagesItem.cutWages != 0.0}'>${fn:replace(wagesItem.cutWages+'','.0','')}</c:if></span></td>
						<td align="right"><label>加班工资:</label></td>
						<td><span class="label label-info"><c:if test='${wagesItem.overtimeWages != 0.0}'>${fn:replace(wagesItem.overtimeWages+'','.0','')}</c:if></span></td>
					</tr>
					<tr>
						<td><span class="label label-primary">福利工资</span></td>
						<td align="right"><label>工龄工资:</label></td>
						<td><input type="text" id="pageSeniorityWages" name="pageSeniorityWages"
							value="<c:if test='${wagesItem.seniorityWages != 0.0}'>${fn:replace(wagesItem.seniorityWages+'','.0','')}</c:if>" class="form-control" placeholder="工龄工资"></td>
						<td align="right"><label>全勤奖:</label></td>
						<td><span class="label label-info"><c:if test='${wagesItem.perfectAttendance != 0.0}'>${fn:replace(wagesItem.perfectAttendance+'','.0','')}</c:if></span></td>
						<td align="right"><label>社保单位部分:</label></td>
						<td><input type="text" id="pageSocialSecurity" name="pageSocialSecurity"
							value="<c:if test='${wagesItem.socialSecurity != 0.0}'>${fn:replace(wagesItem.socialSecurity+'','.0','')}</c:if>" class="form-control" placeholder="社保单位部分"></td>
					</tr>
					<tr>
						<td></td>
						<td align="right"><label>保底补贴:</label></td>
						<td><span class="label label-info"><c:if test='${wagesItem.guaranteedSubsidies != 0.0}'>${fn:replace(wagesItem.guaranteedSubsidies+'','.0','')}</c:if></span></td>
						<td align="right"><label>奖金:</label></td>
						<td><input type="text" id="pageBonus" name="pageBonus"
							value="<c:if test='${wagesItem.bonus != 0.0}'>${fn:replace(wagesItem.bonus+'','.0','')}</c:if>" class="form-control" placeholder="奖金"></td>
						<td align="right"><label>应发合计:</label></td>
						<td><span class="label label-success"><fmt:formatNumber value="${wagesItem.shouldCount}" pattern="0.00"/></span></td>
					</tr>
					<tr>
						<td><span class="label label-primary">应扣款项</span></td>
						<td align="right"><label>缺勤及旷工:</label></td>
						<td><span class="label label-info"><c:if test="${wagesItem.absenteeism != 0.0}">${fn:replace(wagesItem.absenteeism+"",".0","")}</c:if></span></td>
						<td align="right"><label>水电费:</label></td>
						<td><input type="text" id="pageUtilities" name="pageUtilities"
							value="<c:if test='${wagesItem.utilities != 0.0}'>${fn:replace(wagesItem.utilities+'','.0','')}</c:if>" class="form-control" placeholder="水电费"></td>
						<td align="right"><label>社保费:</label></td>
						<td><input type="text" id="pageSocialInsurancePremiums" name="pageSocialInsurancePremiums"
							value="<c:if test='${wagesItem.socialInsurancePremiums != 0.0}'>${fn:replace(wagesItem.socialInsurancePremiums+'','.0','')}</c:if>" class="form-control" placeholder="社保费"></td>
					</tr>
					<tr>
						<td></td>
						<td align="right"><label>押金:</label></td>
						<td><input type="text" id="pageCashPledge" name="pageCashPledge"
							value="<c:if test='${wagesItem.cashPledge != 0.0}'>${fn:replace(wagesItem.cashPledge+'','.0','')}</c:if>" class="form-control" placeholder="押金"></td>
						<td align="right"><label>其他扣款:</label></td>
						<td><input type="text" id="pageOtherDeductions" name="pageOtherDeductions"
							value="<c:if test='${wagesItem.otherDeductions != 0.0}'>${fn:replace(wagesItem.otherDeductions+'','.0','')}</c:if>" class="form-control" placeholder="其他扣款"></td>
						<td align="right"><label>合计:</label></td>
						<td><span class="label label-success"><fmt:formatNumber value="${wagesItem.count}" pattern="0.00"/></span></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td align="right"><h4><strong>实发工资：</strong></h4></td>
						<td><h4><span class="label label-warning"><fmt:formatNumber value="${wagesItem.lastWages}" pattern="0.00"/></span></h4></td>
					</tr>
				</tbody>
			</table>
			<div align="center" style="margin-top: 15px;margin-bottom: 15px">
				<a id="btn_submit" class="btn btn-info"><span
					class="glyphicon glyphicon-edit"></span>&nbsp;修改</a>
				<button type="reset" class="btn btn-danger">
					<span class="glyphicon glyphicon-remove"></span>&nbsp;重置
				</button>
			</div>
		</form>

	</center>
</body>
</html>
