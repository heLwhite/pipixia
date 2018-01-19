<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

	<script type="text/javascript" src="ajax_js/ajax.js"></script>
	<script type="text/javascript">
	window.onload = function()
	{
		var btn =document .getElementById("tijiao");
		btn.onclick = function()
		{
			ajax(
					{
						method:"POST",
						url:"user_login.action",
						type:"text",
						roolback:function(data)
						{
							document.getElementById("chu").innerHTML=data;
						}
					}
			
			);
		};
	};
	</script>
  </head>
  
  <body>
    	<h1 id="chu">保存商品</h1>
    	
    		<table>
    			<tr>
    				<td>商品名称</td>
    				<td><s:textfield name="pname"></s:textfield></td>
    			</tr>
    			<tr>
    				<td>价格</td>
    				<td><s:textfield name="price"></s:textfield></td>
    			</tr>
    			<tr>
    				<td colspan="2"><button id="tijiao">大一点</button></td>
    			</tr>
    		</table>
    	
  </body>
</html>
