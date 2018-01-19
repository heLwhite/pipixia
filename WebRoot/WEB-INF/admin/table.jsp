<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'table.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<style type="text/css" media="screen">
		.shoushou
		{
			width: 100%
		}
		.shoushou tr
		{
			width: 100%
		}
		th
		{
			width: 12%;
			height: 30px;
		}
		
		tbody tr:nth-child(2n+1)
		{
			background: #BCDAFA;
			
		}
		tbody tr:nth-child(2n)
		{
			background: white;
			
		}
		thead tr
		{
			height:50px;

		}
		
		tr th:first-of-type
		{
		   width:50px;
		  
		}
		th input 
		{
			border:1px solid;
		}
	</style>
	<script type="text/javascript">
		window.onload=function()
		{
			var zhukuang=document.getElementsByClassName("zhukuang")[0];
			var xuanzekuang=document.getElementsByClassName("xuanzekuang");
			var tou=document.getElementsByClassName("titletop")[0];
			var sbody=document.getElementById("catby");
			 
			var text = eval('${json}');
			var savetou ='${savetou}';
			create(savetou,tou,text,sbody);
			//用于实现全部提交按钮
			zhukuang.onclick=function()
			{				
				if(zhukuang.checked==true)
				{
					
					for (var i = 0; i < xuanzekuang.length; i++) 
					{
						xuanzekuang[i].checked=true;
					
					}	
				}else
					{
						for (var i = 0; i < xuanzekuang.length; i++) 
						{
							xuanzekuang[i].checked=false;
						}
					}				
			};			
		};
		//增加节点
		function create(data,jiedian,text,bodyjd)
		{
			var toucan=gettou(data).split(' ');
			
			for (var i = 0; i < toucan.length; i++) {
				var th=document.createElement("th");
				th.innerHTML=toucan[i];
				jiedian.appendChild(th);
			}
			for (var i = 0; i < text.length; i++) {
				var tr=document.createElement("tr");
				tr.className="caaa";
				bodyjd.appendChild(tr);
				var th=document.createElement("th");
				th.style.width="5%";
				th.className="adid";
				tr.appendChild(th);
				var input=document.createElement("input");
				input.type="checkbox";
				input.className="xuanzekuang";
				th.appendChild(input);
				for(var j in text[i])
				{
					if(j.indexOf("id")>0)
						{
							var iphidden=document.createElement("input");
							iphidden.type="hidden";
							iphidden.className="aaid";
							iphidden.value=text[i][j];
							tr.appendChild(iphidden);
						}else
							{
								var th2=document.createElement("th");
								th2.innerHTML=text[i][j];
								tr.appendChild(th2);
							}
				}
			}
		}
		
		var gettou=function(data)
		{
			var tou1=
			{
				"admin":"登录账户 密码 入职日期 登录名 工资金额",
				"cate":"种类名 热卖 种类简称 图片名称 简单介绍",
				"merch":"店铺名 密码 商铺地址 商铺类型 赔付资金 注册日期 剩余日期",
				"pro":"名称 价格 简介 详细介绍 图片号 关注度 规格 活动",
				"user":"账户名称 密码 登录名称 性别 联系电话"
			};

			return tou1[data];
		};
		
	</script>
  </head>
  
  <body>
    <table class="shoushou">
		<thead>
			<tr class="titletop">
				<th><input type="checkbox" class="zhukuang"></th>			
			</tr>
		</thead>
		<tbody id="catby">
				
		</tbody>
	</table>
  </body>
</html>
