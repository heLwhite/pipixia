<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminpeople.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/adminpeople.css">
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<script type="text/javascript" src="js/adminpeople.js"></script>
	
  </head>
  	
  <body>
   <!--头部信息管理-->
	<div class="top clearfix">
		<div class="topleft clearfix fl">
			<div class="fl topleftlogo">
				<img src="images/shangbiao.png" alt="">
			</div>
			<div class="fl topleftword">
				蓝<span>狗</span>管理
			</div>
			<div class="topleftmessage fl">
				<div>
					当前管理界面:
				</div>
				<div>
					资源管理界面
				</div>
			</div>
		</div>
		
		<div class="topright fr">
			<div class="userback">
				[ 退出 ]
			</div>
			<div>
				姓名
			</div>
			<div>
				头像
			</div>
		</div>
	</div>

	<!--center代码验证-->
	<div class="center clearfix">
		<div class="centerleft fl">
			<ul class="centerul" id="datashuju">
				<li data-id="admin"><a href="admin_adfindall.action" target="hougroup" id="worker">员工管理</a></li>
				<li data-id="cate"><a href="cate_cafindall.action" target="hougroup">类别管理</a></li>
				<li data-id="merch"><a href="merch_merchall.action" target="hougroup">商家管理</a></li>
				<li data-id="product"><a href="product_profindall.action" target="hougroup">产品管理</a></li>
				<li data-id="user"><a href="user_userall.action" target="hougroup">用户管理</a></li>
				
			</ul>
		</div>
		<div class="centerright fl">
			<div class="centersou clearfix">
				<input class="sousuo fl" type="text" placeholder="请输入姓名">
				<button class="soubut fl">搜索</button>
				<div class="fr caozuo" id="shanchu">删除</div>
				<div class="fr caozuo" id="xiugai">修改</div>
				<div class="fr caozuo" id="tianjia">添加</div>				
			</div>
			<div class="xianshi">
				<iframe id="hougroup" name="hougroup" data-table=""></iframe>
			</div>
		</div>
	</div>
	
  	
  	<!-- 覆盖层 -->
  	<div class="fugai" id="fugai">
  		<div class="change" id="change">
  			<div class="closefugai" id="closefugai"><img src="images/admin/guanbi.png"></div>
  			<form action="" method="post" class="changeform" id="changeform">
  				
  				
  			</form>
  		</div>
  	</div>
  </body>
</html>
