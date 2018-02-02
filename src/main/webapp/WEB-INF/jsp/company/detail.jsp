<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>办公管理系统</title>
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
			/* // 对表单中所有字段做校验
			var name = $("#name");
			var job = $("#job");
			// 任务指标
			var taskIndicators = $("#taskIndicators");
			// 销售业绩
			var salesPerformance = $("#salesPerformance");
			// 单提业绩
			var singlePerformance = $("#singlePerformance");
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
			} */
			top.$('#divDialog').dialog("close");
			$.ajax({
				url:"${ctx}/company/updateCompany",
				data:$('#updateForm').serialize(),
				success:function(data){
					if(data){
						top.addPanel(2 ,'${ctx}/company/showCompany','公司管理');
					}
				},error:function(){
					alert("加载失败！");
				}
			})

		});
	});
</script>
</head>
<body style="background: #F5FAFA;">
	<center>
		<form id="updateForm" action="${ctx}/company/updateCompany"
			method="post">
			<input type="hidden" name="status" value="<c:out value="${item.status}" default="${defaultStatus}" />">
			<table class="table-condensed">
				<tbody>
					<tr>
						<td><span class="label label-primary">名称</span></td>
						<td><input type="text" id="name" name="name"
							value="${item.name}" class="form-control" placeholder="请输入名称"></td>
					</tr>
					<tr>
						<td><span class="label label-primary">所属分部</span></td>
						<td><input type="text" id="branch" name="branch"
							value="${item.branch}" class="form-control" placeholder="请输入所属分部"></td>
					</tr>
					<tr>
						<td><span class="label label-primary">地址</span></td>
						<td><input type="text" id="address" name="address"
							value="${item.address}" class="form-control" placeholder="请输入地址"></td>
					</tr>
					<tr>
						<td><span class="label label-primary">备注</span></td>
						<td><textarea id="remark" name="remark" class="form-control" placeholder="请输入备注" style="width: 300px;height:80px">${item.remark}</textarea></td>
					</tr>
				</tbody>
			</table>
			<div align="center" style="margin-top: 15px;margin-bottom: 15px">
				<a id="btn_submit" class="btn btn-info"><span
					class="glyphicon glyphicon-edit"></span>&nbsp;保存</a>
				<button type="reset" class="btn btn-danger">
					<span class="glyphicon glyphicon-remove"></span>&nbsp;重置
				</button>
			</div>
		</form>

	</center>
</body>
</html>
