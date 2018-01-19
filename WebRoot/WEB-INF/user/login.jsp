
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>蓝狗欢迎你</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/userlogin.css">
	<script type="text/javascript" src="ajax_js/ajax.js"></script>
	<script type="text/javascript">
		window.onload=function(){
			var login_button=document.getElementById("loginbutton");
			var login_pwd=document.getElementById("inputpwd");
			var login_name=document.getElementById("inputname");
			
			login_button.onclick=function()
			{
				ajax
				({
					method:"POST",
					url:"user_login.action",
					type:"text",
					params:"uname="+login_name.value+"&upwd="+login_pwd.value+"",
					roolback:function(data)
					{
						if(data=="pwderrow")
							{
								var errowxianshi= document.getElementById("errowprompt");
								errowxianshi.style.display='block';

							}else if(data=="pwdqueren")
								{
								window.location.href='send_index_haha_mainindex.action';
								}
						
						
					}
				});
			};
		};
	</script>
  </head>
  
  <body>
    <div class="errowprompt" id="errowprompt">你输入的密码和账户名不匹配，是否忘记密码  或  忘记会员名
    	<span class="errowrow"></span>
    </div>
    <!-- 登录界面 -->
    <div class="comWidth titlediv">
    	<a href="index.jsp">
    		<img alt="回天猫" src="images/shangbiao.png" class="titleimg">
    	</a>
    </div>
    <!-- 中间登录页面 -->
    <div class="center">
    	<div class="comWidth">
    	 	<img src="images/u_l_images/baskground.png">
    	</div>
    </div>
    
   <!-- 登录div -->
   
    <div class="logindiv">
    	<div class="hellow">密码登录</div>
    	<div>
    		<div class="loginform">
    			<div class="clearfix"><img class="naimg fl" src="images/u_l_images/routou.png"></img><input type="text" name="uname" class="name fl" id="inputname" placeholder="会员名 / 邮箱  / 手机号"></div>
    			<div class="clearfix"><img  class="pwedimg fl" src="images/u_l_images/mima.png"></img><input type="password" name="upwd" class="password fl" id="inputpwd" placeholder="请输入密码"></div>
    			<button type="button" value="登录" class="login_submit" id="loginbutton">登录</button>
    		</div>
    		<div class="forget_login">
    			<a href="#">忘记密码？</a> 
    			<a href="">注册密码</a>
    			<a href="send_admin_adminpeople_admin.action">管理员登录</a>  			
    		</div>
    	</div>
    </div>
    
    <!-- 声明 -->
    <div class="comWidth shengming" data-spm="a2226n1" data-spm-max-idx="41">
    
    
    <div id="tmall-desc">
              
    </div>
    <div id="tmall-copyright">
        <div class="mui-global-fragment-load" data-fragment="tmbase/mui_footer_link"><p class="footer-tmallinfo"> 
    <a href="//pages.tmall.com/wow/seller/act/zhaoshangproduce?spm=a2240.7829288.a2226n1.1.4Vz8E3" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.1">关于天猫</a> 
    <a href="//service.tmall.com/support/tmall/tmallHelp.htm" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.2">帮助中心</a> 
    <a href="//open.taobao.com" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.3">开放平台</a> 
    <a href="//job.alibaba.com/zhaopin/index.htm" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.4">诚聘英才</a> 
    <a href="//consumerservice.taobao.com/contact-us" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.5">联系我们</a> 
    <a href="//xtao.tmall.com?tracelog=tmallfoot" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.6">网站合作</a> 
    <a href="http://terms.alicdn.com/legal-agreement/terms/suit_bu1_taobao/suit_bu1_taobao201703241622_61002.html" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.7">法律声明及隐私权政策</a>
    <a href="http://ipp.alibabagroup.com/" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.8">知识产权</a>
    <a href="//jubao.alibaba.com/index.html?site=TMALL" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.9">廉正举报</a> 
    <a class="footer-fp-rule" style="display:none;" href="//rule.tmall.com/trulecycle.htm" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.10">规则意见征集</a>
</p>
<p class="footer-otherlink"> 
    <a href="http://www.alibabagroup.com/cn/global/home" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.11">阿里巴巴集团</a>| 
    <a href="//www.taobao.com" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.12">淘宝网</a> | 
    <a href="//www.tmall.com/" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.13">天猫</a> | 
    <a href="//ju.taobao.com/" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.14">聚划算</a> | 
    <a href="http://www.aliexpress.com/" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.15">全球速卖通</a> | 
    <a href="http://www.alibaba.com/" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.16">阿里巴巴国际交易市场</a>| 
    <a href="//www.1688.com/" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.17">1688</a> | 
    <a href="//www.alimama.com/" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.18">阿里妈妈</a> | 
    <a href="//www.fliggy.com/" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.19">飞猪</a> | 
    <a href="http://www.aliyun.com/" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.20">阿里云计算</a> | 
    <a href="http://www.yunos.com/" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.21">YunOS</a> | 
    <a href="http://aliqin.cn/" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.22">阿里通信</a> | 
    <a href="http://www.net.cn/" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.23">万网</a> | 
    <a href="http://www.autonavi.com/" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.24">高德</a> | 
    <a href="http://www.uc.cn/" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.25">UC</a> | 
    <a href="http://www.umeng.com/" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.26">友盟</a> | 
    <a href="http://www.xiami.com/" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.27">虾米</a> | 
    <a href="http://www.alibabaplanet.com" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.28">阿里星球</a> | 
    <a href="http://www.laiwang.com/" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.29">来往</a> | 
    <a href="http://www.dingtalk.com/?lwfrom=20150205115110773" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.30">钉钉</a> | 
    <a href="https://www.alipay.com" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.31">支付宝</a>
</p>
<div class="footer-copyright">增值电信业务经营许可证：
    <a data-spm-protocol="i" href="http://www.miibeian.gov.cn/state/outPortal/loginPortal.action" data-spm-anchor-id="a2240.7829288.a2226n1.32">浙B2-20110446</a>
    网络文化经营许可证：<a href="http://sq.ccm.gov.cn/ccnt/sczr/service/business/emark/toDetail/CB964ABC7B904B7BA3472DDF700A2D6D" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.33">浙网文[2015]0295-065号</a>
    <a href="http://jb.ccm.gov.cn/" data-spm-anchor-id="a2240.7829288.a2226n1.34">12318举报</a>
    <br>
    <span class="footer-liangxinyao-cert" style="display:none;">
        互联网药品交易服务资格证：<a href="//img.alicdn.com/tps/TB1c4YwOpXXXXcHXXXXXXXXXXXX-3306-2338.jpg" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.35">粤c20150002</a>
        <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=44010602001483" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.36">
            <img src="https://img.alicdn.com/tps/TB1_qAKKVXXXXXjapXXXXXXXXXX-20-20.png">粤公网安备 44010602001483号
        </a>
        <a href="http://www.miitbeian.gov.cn/" target="_blank" data-spm-anchor-id="a2240.7829288.a2226n1.37">粤ICP备14088652号-2</a>
    </span>
    互联网药品信息服务资质证书编号：<a href="//img.alicdn.com/tps/TB1vi6vPVXXXXbVXVXXXXXXXXXX-927-653.png" data-spm-anchor-id="a2240.7829288.a2226n1.38">浙-（经营性）-2017-0005</a>
    <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010002000120" data-spm-anchor-id="a2240.7829288.a2226n1.39"><img src="//img.alicdn.com/tps/TB1yEqRPXXXXXXPXpXXXXXXXXXX-20-20.png" style="position:relative;top:5px;vertical-align:baseline;">
  浙公网安备 33010002000120号</a>
    <b>© 2003-2017 TMALL.COM 版权所有</b>
    <p style="padding-top:10px; display:none;" class="footer-fp-img">
        <a style="margin-right:10px" target="_blank" href="http://idinfo.zjaic.gov.cn/bscx.do?method=hddoc&amp;id=33018400005282" data-spm-anchor-id="a2240.7829288.a2226n1.40"><img src="//img.alicdn.com/tps/i4/TB1j5gtHXXXXXXjaXXXydRxIFXX-73-30.jpg"></a>
        <a target="_blank" href="http://sq.ccm.gov.cn" data-spm-anchor-id="a2240.7829288.a2226n1.41"><img src="//img.alicdn.com/tps/i1/TB13mgzHXXXXXbjXVXXzby4IVXX-80-30.jpg"></a>
    </p>
</div></div>
    </div>
    

    <div id="server-num">wormholesource010178033023.et2.production</div>
</div>
  </body>
</html>
