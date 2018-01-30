<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html> 
<html>
<head> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>酷朗智能办公</title> 
<link href="${ctx}/css/base.css" rel="stylesheet">
<link href="${ctx}/css/platform.css" rel="stylesheet">
<link href="${ctx}/images/favicon.ico" rel="Shortcut Icon">
<link rel="stylesheet" href="${ctx}/resources/easyUI/easyui.css">
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${ctx}/resources/easyUI/easyui-lang-zh_CN.js"></script>
 <!-- <script type="text/javascript" src="js/menu.js"></script> -->
<script type="text/javascript" src="${ctx}/js/main.js"></script>
<script type="text/javascript" src="${ctx}/js/nowTime.js"></script>
<script type="text/javascript">
	$(function(){
		$('#tt').tabs({
		    	  tabHeight: 40,
			      onSelect:function(title,index){
			        var currentTab = $('#tt').tabs("getSelected");
			        if(currentTab.find("iframe") && currentTab.find("iframe").size()){
			            currentTab.find("iframe").attr("src",currentTab.find("iframe").attr("src"));
			        }
			      }
		 });
		
		// 进行信息提示,js中使用EL表达式需使用双引号
		if("${message}"){
			$.messager.alert('提示信息',"${message}",'warning');
		}
		
		// 如果当前窗口不是父窗口,则将当前窗口最为顶级窗口(防止只显示在面板里面)
		if(window.location != parent.window.location){
			top.window.location = window.location;
		}
		
		$("#nowTime").nowTime();
	})

     // 写一个方法往easyUI中添加面板 
	function addPanel(id,url,name){
    	name = name.replace(/-/g,"");
    	// 判断之前是否已经存在该面板存在就不创建新的面板 
    	var exist = $('#tt').tabs('exists',name);
    	if(exist){
    		// 已经存在就将该面板选中  exist
    		$('#tt').tabs('select',name);
    		var currentTab =  $('#tt').tabs('getTab',name);
    		// 刷新一下界面 
    		if(currentTab.find("iframe") && currentTab.find("iframe").size()){
	            currentTab.find("iframe").attr("src",currentTab.find("iframe").attr("src"));
	        }
    	}else{
    		$('#tt').tabs('add',{
    			id:id,
    			title: name,
    			content: '<div style="width:100%;height:100%;"><iframe class="page-iframe" src="'+url+'" frameborder="no"   border="no" height="100%" width="100%" scrolling="auto"></iframe></div>',
    			closable: true
    		});
    	}
	}
	   
	    $(window).resize(function(){
	          $('.tabs-panels').height($("#pf-page").height()-46);
	          $('.panel-body').height($("#pf-page").height()-76);
	    }).resize();

	    var page = 0,
	        pages = ($('.pf-nav').height() / 70) - 1;

	    if(pages === 0){
	      $('.pf-nav-prev,.pf-nav-next').hide();
	    }
	    $(document).on('click', '.pf-nav-prev,.pf-nav-next', function(){
			    	
	      if($(this).hasClass('disabled')) return;
	      if($(this).hasClass('pf-nav-next')){
	        page++;
	        $('.pf-nav').stop().animate({'margin-top': -70*page}, 200);
	        if(page == pages){
	          $(this).addClass('disabled');
	          $('.pf-nav-prev').removeClass('disabled');
	        }else{
	          $('.pf-nav-prev').removeClass('disabled');
	        }
	      }else{
	        page--;
	        $('.pf-nav').stop().animate({'margin-top': -70*page}, 200);
	        if(page == 0){
	          $(this).addClass('disabled');
	          $('.pf-nav-next').removeClass('disabled');
	        }else{
	          $('.pf-nav-next').removeClass('disabled');
	        }
	        
	      }
	    })
	    
	    function exit(){
	    	window.location="${ctx}/identity/user/logout";
	    }
	    
	  
	    </script>

</head> 
<body>
    <div class="container">
        <div id="pf-hd">
           <div class="pf-logo" style="padding-left: 40px">
                <img  src="${ctx}/images/logo.png" height="70" width="200" alt="logo">
           </div>
            
            <div class="pf-nav-wrap">
              <div class="pf-nav-ww">
              </div>
                <ul class="pf-nav">
	                  <li data-menu="sys-manage">
	                      <font color="white"><br><br>当前时间：<span id="nowTime"></span></font>
	                  </li>
                </ul>

            </div>
            


            <div class="pf-user">
                <div class="pf-user-photo">
                    <img style="width: 40px;height: 40px;" src="${ctx}/images/main/jiuguang.jpg" alt="">
                </div>
                <h4 id="userName" class="pf-user-name ellipsis">${session_user.name}</h4>
                <i class="iconfont xiala">&#xe607;</i>

                <div class="pf-user-panel">
                    <ul class="pf-user-opt">
                        <li>
                            <a href="javascript:addPanel('0' ,'${ctx}/home','用户信息');">
                                <i class="iconfont">&#xe60d;</i>
                                <span class="pf-opt-name">用户信息</span>
                            </a>
                        </li>
                        <li  id="exit">
                            <a href="javascript:exit();">
                                <i class="iconfont">&#xe60e;</i>
                                <span class="pf-opt-name">退出</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

        </div>

        <div id="pf-bd">
            <div id="pf-sider">
                <h2 class="pf-model-name">
                    <span class="iconfont">&#xe64a;</span>
                    <span class="pf-name">薪酬管理系统</span>
                    <span class="toggle-icon"></span>
                </h2>
				<!-- 展示系统左侧权限树  -->
                <ul class="sider-nav" id="sider-nav">
            	  	<li>
                 	  	<a href="javascript:addPanel(1 ,'${ctx}/hrm/showCalcWages','薪资计算');">
                            <span class="iconfont sider-nav-icon">&#xe611;</span>
                            <span class="sider-nav-title">薪资计算</span>
                            <i class="iconfont">&#xe642;</i>
                        </a>
               	  	</li>
            	  	<li>
                 	  	<a href="javascript:;" >
                            <span class="iconfont sider-nav-icon">&#xe611;</span>
                            <span class="sider-nav-title">历史表格</span>
                            <i class="iconfont">&#xe642;</i>
                        </a>
               	  	</li>
            	  	<li>
                 	  	<a href="javascript:;" >
                            <span class="iconfont sider-nav-icon">&#xe611;</span>
                            <span class="sider-nav-title">系统管理</span>
                            <i class="iconfont">&#xe642;</i>
                        </a>
                        <ul class="sider-nav-s">
		                    <li><a href="javascript:addPanel(31 ,'${seModule.url}','${seModule.name}');">用户管理</a></li>
		                    <li><a href="javascript:addPanel(32 ,'${seModule.url}','${seModule.name}');">角色管理</a></li>
		                </ul>
               	  	</li>
                 </ul> 
            </div>

           <!-- 用户信息面板 -->
            <div id="pf-page">
                <div class="easyui-tabs" id="tt" style="width:100%;height:100%;">
                  <div title="用户信息" id="user" style="padding:10px 5px 5px 10px;">
                    	<iframe class="page-iframe" src="${ctx}/home" frameborder="no"   border="no" height="100%" width="100%" scrolling="auto"></iframe>
                  </div>
                </div>
            </div>
        </div>
        <div id="divDialog" style="display: none;" >
			 <!-- 放置一个显示信息的界面  -->
			 <iframe id="iframe" frameborder="0" onload=' this.style.height=Math.max(this.contentWindow.document.body.scrollHeight,this.contentWindow.document.documentElement.scrollHeight,200)+"px";  ' style="width: 100%;height: 100%;"></iframe>
		</div>

        <div id="pf-ft">
            <div class="system-name">
              <i class="iconfont">&#xe6fe;</i>
              <span>酷朗智能办公平台&nbsp;v1.0</span>
            </div>
            <div class="copyright-name">
              <span>Copyright&nbsp;©&nbsp;2017</span>
              <i class="iconfont" >&#xe6ff;</i>
            </div>
        </div>
    </div>
    
</body> 
</html>
    