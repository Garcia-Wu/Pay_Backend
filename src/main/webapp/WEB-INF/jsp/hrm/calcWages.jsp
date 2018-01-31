<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="kl" uri="kulang-pager" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<title>酷朗智能办公</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<link rel="stylesheet"
	href="${ctx }/resources/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx}/css/pager.css">
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
<link rel="stylesheet" href="${ctx}/resources/easyUI/easyui.css">
<script type="text/javascript" src="${ctx}/resources/blockUI/jquery.blockUI.js"></script>
<script type="text/javascript">
  /** 文档加载完成*/
     $(function(){
    	 
   		// 如果有提示就弹出来 
		if("${message}"){
			top.$.messager.show({
				title:'操作提示',
				msg:'<span style="color: #11a9e2;">${message}</span>',
				timeout:3000,
				showType:'show'
			});
		}
    	  
    	  // 开始加载时执行,提示正在加载数据
	     // $(document).ajaxStart($.blockUI({ css: { backgroundColor: '#11a9e2', color: '#fff' } , message: '<h6>正在加载..</h6>'})).ajaxStop($.unblockUI);

		  // 为删除绑定点击事件
		  $("#deleteUser").click(function(){
			  // 获取所有子复选框
			  var boxs = $("input[type='checkbox'][id^='box_']");
			  // 过滤出选中的选项
			  var checkbox = boxs.filter(":checked");
			  if(checkbox.length > 0){
				  // 弹出确认窗口, 点确认则r为true,取消为false
				  $.messager.confirm('删除提示', '确定要删除所选用户？', function(r){
					  if (r){
						  var arr = new Array();
						  $.each(checkbox,function(){
							  // 将id添加至数组中,复选框的value为用户id; 格式为  1,2,3
							  arr.push(this.value);
						  })
						  window.location = "${ctx}/identity/user/deleteUser.jspx?pageIndex=${pageModel.pageIndex}&name=${user.name}&phone=${user.phone}&dept.id=${user.dept.id}&job.code=${user.job.code}&ids="+arr;
					  }
				  });

			  }else{
				  $.messager.alert('提示信息',"请选择要删除的用户！",'warning');
			  }
		  })
		  
		  // 为添加按钮绑定事件
		  $("#addUser").click(function(){
			  // 调用公共js的方法
			  showDialog({
				  title:"添加用户",
				  width:600,
				  height:450,
				  closeUrl:"${ctx}/identity/user/selectUser.jspx?pageIndex=${pageModel.pageIndex}&name=${user.name}&phone=${user.phone}&dept.id=${user.dept.id}&job.code=${user.job.code}",
				  showUrl:"${ctx}/identity/user/showAddUser.jspx"
			  });
     	  })
     	  
     	  var dataTr = $("tr[id^='dataTr_']");
		  dataTr.on("click",function(){
			  // 展示修改信息界面
			  top.$('#divDialog').dialog({
					title : "修改工资信息",
					cls : "easyui-dialog", // class
					width : 1060, // 宽度
					height : 500, // 高度
					maximizable : true, // 最大化
					minimizable : false, // 最小化
					collapsible : true, // 折叠按钮
					resizable : true, // 是否可伸缩
					modal : true, // 模态窗口
					onClose : function() { // 关闭窗口
						window.location = "${ctx}/hrm/showCalcWages"; //关闭url
					}
				});

			  	top.$("#iframe").attr("src", "${ctx}/hrm/showUpdateWages?trId="+this.id).show();
		  })
     })
     
     // 点击导入excel事件
     function readExcel(){
	  	  // 如果当前有导入的excel数据存在于session之中
	  	  if("${wagesItems}" != null){
	  		  // 弹出确认窗口, 点确认则r为true,取消为false
			  top.$.messager.confirm('温馨提示', '再次导入Excel将会覆盖当前薪资计算页面的表格数据！确定要导入吗？', function(r){
				  if (r){
					  $('#file').trigger('click');
				  }
			  });
	  	  }else{
	    	 $('#file').trigger('click');
	  	  }
  	 }
     
  	 
</script>
</head>
<body style="overflow: hidden; width: 98%; height: 100%;" >
   		<!-- 工具按钮区 -->
   		<div style="padding-left: 5px">
			<table class="table-condensed">
					<tr>
						<td style="padding-left: 5px">	
							<a class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span>&nbsp;新建</a>
						    <a class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除</a>
						    <a href="javascript:readExcel();" class="btn btn-info"><span class="glyphicon glyphicon-save"></span>&nbsp;导入表格</a>
						    <a class="btn btn-success"><span class="glyphicon glyphicon-open"></span>&nbsp;导出表格</a>
					 	</td>
					</tr>
					</tbody>
			</table>
		</div>
		
 		<div class="panel panel-primary" style="padding-left: 10px;">
 			<div class="panel-heading" style="background-color: #11a9e2;">
				<h3 class="panel-title">员工工资表</h3>
			</div>
			<div class="panel-body" >
				<table class="table table-bordered" style="width: 2500px">
					<thead>
						<tr style="font-size: 12px;" align="center">
							<td style="text-align: center;vertical-align: middle;" rowspan="2"><input id="checkAll"
								type="checkbox" /></td>
							<td style="text-align: center;vertical-align: middle;" rowspan="2">序号</td>
							<td style="text-align: center;vertical-align: middle;" rowspan="2">姓名</td>
							<td style="text-align: center;vertical-align: middle;" rowspan="2">职务</td>
							<td style="text-align: center;vertical-align: middle;" rowspan="2">入职时间</td>
							<th style="text-align: center;" colspan="8">考勤</th>
							<th style="text-align: center;" colspan="2">固定工资</th>
							<th style="text-align: center;" colspan="5">销售明细</th>
							<th style="text-align: center;" colspan="3">浮动工资</th>
							<th style="text-align: center;" colspan="5">福利工资</th>
							<td style="text-align: center;vertical-align: middle;" rowspan="2">应发合计</td>
							<th style="text-align: center;" colspan="6">应扣款项</th>
							<td style="text-align: center;vertical-align: middle;" rowspan="2">实发工资</td>
						</tr>
						<tr style="font-size: 12px;" align="center">
							<td style="text-align: center;">满勤天数</td>
							<td style="text-align: center;">出勤天数</td>
							<td style="text-align: center;">加班时间(小时)</td>
							<td style="text-align: center;">普通加班天数</td>
							<td style="text-align: center;">法定节假日加班天数</td>
							<td style="text-align: center;">旷工天数</td>
							<td style="text-align: center;">病假天数</td>
							<th style="text-align: center;">其他缺勤天数</th>
							<td style="text-align: center;">底薪</td>
							<td style="text-align: center;">加班津贴</td>
							<td style="text-align: center;">任务指标</td>
							<td style="text-align: center;">销售业绩</td>
							<td style="text-align: center;">单提业绩</td>
							<td style="text-align: center;">达标率</td>
							<td style="text-align: center;">提成系数</td>
							<td style="text-align: center;">达标绩效</td>
							<td style="text-align: center;">提成工资</td>
							<td style="text-align: center;">加班工资</td>
							<td style="text-align: center;">工龄工资</td>
							<td style="text-align: center;">全勤奖</td>
							<td style="text-align: center;">社保单位部分</td>
							<td style="text-align: center;">保底补贴</td>
							<td style="text-align: center;">奖金</td>
							<td style="text-align: center;">缺勤及旷工</td>
							<td style="text-align: center;">水电费</td>
							<td style="text-align: center;">社保费</td>
							<td style="text-align: center;">押金</td>
							<td style="text-align: center;">其他扣款</td>
							<td style="text-align: center;">合计</td>
						</tr>
					</thead>
					<c:forEach items="${wagesItems}" var="wage"
						varStatus="stat">
						<tr id="dataTr_${stat.index}" align="center" style="cursor:pointer" title="点击修改该行">
							<td id="dataTd"><input type="checkbox" name="box" id="box_${stat.index}"
								value="${user.userId}" /></td>
							<td id="dataTd">${stat.index + 1}</td>
							<td id="dataTd">${wage.name}</td>
							<td id="dataTd">${wage.job}</td>
							<td id="dataTd"><fmt:formatDate value="${wage.entryTime}" pattern="yyyy/mm/dd"/></td>
							<td id="dataTd"><c:if test="${wage.fullFrequentlyDay != 0.0}">${fn:replace(wage.fullFrequentlyDay+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.attendanceDay != 0.0}">${fn:replace(wage.attendanceDay+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.workOvertime != 0.0}">${wage.workOvertime}</c:if></td>
							<td id="dataTd"><c:if test="${wage.ordinaryOvertime != 0.0}">${fn:replace(wage.ordinaryOvertime+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.holidayOvertime != 0.0}">${fn:replace(wage.holidayOvertime+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.absenteeismDays != 0.0}">${fn:replace(wage.absenteeismDays+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.sickLeaveDays != 0.0}">${fn:replace(wage.sickLeaveDays+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.otherAbsenteeismDays != 0.0}">${wage.otherAbsenteeismDays}</c:if></td>
							<td id="dataTd"><c:if test="${wage.baseSalary != 0.0}">${fn:replace(wage.baseSalary+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.overtimeAllowance != 0.0}">${fn:replace(wage.overtimeAllowance+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.taskIndicators != 0.0}">${fn:replace(wage.taskIndicators+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.salesPerformance != 0.0}">${fn:replace(wage.salesPerformance+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.singlePerformance != 0.0}">${fn:replace(wage.singlePerformance+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.successRate != 0.0}">${wage.successRate}%</c:if></td>
							<td id="dataTd"><c:if test="${wage.commissionCoefficient != 0.0}"><fmt:formatNumber pattern="0.00" value="${wage.commissionCoefficient}"/>%</c:if></td>
							<td id="dataTd"><c:if test="${wage.standardPerformance != 0.0}">${fn:replace(wage.standardPerformance+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.cutWages != 0.0}">${fn:replace(wage.cutWages+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.overtimeWages != 0.0}">${fn:replace(wage.overtimeWages+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.seniorityWages != 0.0}">${fn:replace(wage.seniorityWages+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.perfectAttendance != 0.0}">${fn:replace(wage.perfectAttendance+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.socialSecurity != 0.0}">${fn:replace(wage.socialSecurity+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.guaranteedSubsidies != 0.0}">${fn:replace(wage.guaranteedSubsidies+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.bonus != 0.0}">${fn:replace(wage.bonus+"",".0","")}</c:if></td>
							<td id="dataTd"><fmt:formatNumber value="${wage.shouldCount}" pattern="0.00"/></td>
							<td id="dataTd"><c:if test="${wage.absenteeism != 0.0}">${fn:replace(wage.absenteeism+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.utilities != 0.0}">${fn:replace(wage.utilities+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.socialInsurancePremiums != 0.0}">${fn:replace(wage.socialInsurancePremiums+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.cashPledge != 0.0}">${fn:replace(wage.cashPledge+"",".0","")}</c:if></td>
							<td id="dataTd"><c:if test="${wage.otherDeductions != 0.0}">${fn:replace(wage.otherDeductions+"",".0","")}</c:if></td>
							<td id="dataTd"><fmt:formatNumber value="${wage.count}" pattern="0.00"/></td>
							<td id="dataTd"><fmt:formatNumber value="${wage.lastWages}" pattern="0.00"/></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<%-- <!-- 分页标签区 -->
				<kl:pager pageIndex="${pageModel.pageIndex}"
					pageSize="${pageModel.pageSize}"
					recordCount="${pageModel.recordCount}"
					submitUrl="${ctx}/identity/user/selectUser.jspx?pageIndex={0}&name=${user.name}&phone=${user.phone}&dept.id=${user.dept.id}&job.code=${user.job.code}" /> --%>
		</div>
		
		<form id="getExcelForm" method="post" action="${ctx}/hrm/getExcel" enctype="multipart/form-data" style="display: none;">
			<input type="file" id="file" name="fileName" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel" onchange="javascript:$('#getExcelForm').submit();"/>
		</form>
	
</body>
</html>