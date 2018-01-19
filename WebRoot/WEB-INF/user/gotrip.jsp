<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'gotrip.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/gotrip.css">
	
	<style type="text/css">
		
	</style>
	<script type="text/javascript" src="websocket_js/websocket.js"></script>
	<script type="text/javascript" src="js/gotrip.js"></script>
  </head>
  
  <body>
    <div class="gt_triptalk">
    	<div class="gt_talkarex"></div>
    	<input class="gtt_input"><div class="submit">发送</div>
    </div>
  </body>
</html>
