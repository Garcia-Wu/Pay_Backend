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
<style type="text/css">
.hahaha{
     border: 0px solid transparent !important;
} 
</style>
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
		  $("#addCompany").click(function(){
		     // 展示修改信息界面
			 top.$('#divDialog').dialog({
					title : "新建公司信息",
					cls : "easyui-dialog", // class
					width : 450, // 宽度
					height : 350, // 高度
					maximizable : true, // 最大化
					minimizable : false, // 最小化
					collapsible : true, // 折叠按钮
					resizable : true, // 是否可伸缩
					modal : true // 模态窗口
			  });
			
			  top.$("#iframe").attr("src", "${ctx}/company/getCompany").show();
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
						window.location = "${ctx}/wagesItem/showCalcWages"; //关闭url
					}
				});
				
			  	top.$("#iframe").attr("src", "${ctx}/wagesItem/showUpdateWages?trId="+this.id).show();
			  	
			  	$('#divDialog').window('center');
		  })
     })

     
  	 
</script>
</head>
<body style="overflow: hidden; width: 98%; height: 100%;" >
		
 		<div class="panel panel-primary" style="padding-left: 10px;padding-top: 10px">
 			<div class="panel-heading" style="background-color: #11a9e2;">
 				<div class="btn-group" style="float: right">
					<a id="addCompany" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-plus"></span>&nbsp;新建</a>
				    <a class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除</a>
				</div>
				<h3 class="panel-title">公司分部表</h3>
			</div>
			<div>
				<table class="table table-bordered hahaha">
					<thead>
						<tr style="font-size: 12px;" align="center">
							<td style="text-align: center;">序号</td>
							<td style="text-align: center;">名称</td>
							<td style="text-align: center;">所属分部</td>
							<td style="text-align: center;">地址</td>
							<td style="text-align: center;">备注</td>
						</tr>
					</thead>
					<c:forEach items="${companyList}" var="item" varStatus="stat">
						<tr align="center" style="cursor:pointer;font-size: 12px;" title="点击修改该行">
							<td>${stat.index + 1}</td>
							<td>${item.name}</td>
							<td>${item.branch}</td>
							<td>${item.address}</td>
							<td>${item.remark}</td>
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
	
</body>
</html>