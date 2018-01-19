	window.onload=function()
	{
		//websocket操作相关
		subOpen(
			{
				address:"shop/shopweb",
				message:function(even)
				{
					
					var json=eval('('+even.data+')');
					console.log(json);
					if((typeof json)=='object')
					{
						adduser(json);
					}else
						{
						    var userdiv=document.getElementById("user"+json);
						    var talkdiv=document.getElementById("talk"+json);
							if(userdiv)
								{
									userdiv.parentNode.removeChild(userdiv);
									talkdiv.parentNode.removeChild(talkdiv);
								}
						}
					
				}
			}
			);
	
		
//		
		
		//节点操作
	        var customer=document.getElementsByClassName("dh_customer")[0];
	        var talk=document.getElementsByClassName("dh_talk")[0];
	        var talkdh=document.getElementsByClassName("dh_ta");
	        var writeinput=document.getElementsByClassName("dh_input")[0];
	        var duculist=document.getElementsByClassName("dh_cu");

	        //添加用户测试
	        var adduser=function(ee)
	        {
	        	var jiedian=true;
	        	console.log(ee);
	        	for(var i=0;i<duculist.length;i++)
	        		{
	        			console.log(ee.sender);
	        			if(duculist[i].dataset.divtalk==ee.sender||ee.sender==undefined)
	        			{
	        				jiedian=false;
	        			}
	        		}
	            if(jiedian)
	            	{	    
	            		//创建用户的使用的节点
	            		var div=document.createElement("div");
	            		div.className="dh_cu";
	            		div.id="user"+ee.sender;
	            		div.dataset.divtalk=ee.sender;
	            		div.innerHTML='客户端'+ee.sender+'用户';
	            		customer.appendChild(div);
	            		var span = document.createElement("span");                     //提示
	            		span.className="prompt";
	            		span.id="prompt"+ee.sender;
	            		if(talk.dataset.dhtstrong!=ee.sender)
	            		{
	            			span.style.display="block";
	            			console.log(talk.dataset.dhtstrong+ee.sender);
	            		}
	            		div.appendChild(span);
	            		//创建对话的对话框
	            		var divtalk=document.createElement("div");
	            		divtalk.className="dh_ta";
	            		divtalk.id="talk"+div.dataset.divtalk;
	            		talk.appendChild(divtalk);
	            		//创建生成的气泡
	            		var divpao=document.createElement("div");
	            		divpao.className="divpao";
	            		divpao.innerHTML=ee.talk;
	            		divtalk.appendChild(divpao);
	            		var spandate=document.createElement("span");
	            		spandate.className="spandate";
	            		spandate.innerHTML=ee.Date;
	            		divpao.appendChild(spandate);
	            		
	            	}else
	            		{
	            			var paocon;
	            			var spanproshow;
	            			var divpao=document.createElement("div");//聊天气泡
	            			console.log(ee.sender);
	            			if(ee.sender==undefined)
	            			{
	            				paocon=document.getElementById("talk"+ee.recipient); 
	            				spanproshow=document.getElementById("prompt"+ee.recipient);
	            				divpao.style.left="8px";
	            			} else
	            				{
	            					paocon=document.getElementById("talk"+ee.sender);
	            					spanproshow=document.getElementById("prompt"+ee.sender);                    //聊天气泡
	            				}         //对话框   //提示
	            			spanproshow.style.display="block";                   
		            		divpao.className="divpao";		            		
		            		divpao.innerHTML=ee.talk;
		            		paocon.appendChild(divpao);		         
		            		var spandate=document.createElement("span");                   //时间
		            		spandate.className="spandate";
		            		spandate.innerHTML=ee.Date;
		            		divpao.appendChild(spandate);
		            		
	            		}
	            
	        }
	        //用户按钮操作
	        customer.onclick=function(ev)
	        {
	            var target = ev.target || ev.srcElement;
	            
	            //防止内层无法点击
	            if(target.className=="dh_customer")
	            {
	                return;
	            }else
	            {
	                for(var i=0;i<talkdh.length;i++)
	                {
	                    if(talkdh[i].style.display=="block")
	                    {
	                        talkdh[i].style.display="none";
	                        talkdh[i].style.left=-160+'px';
	                        setAlphaOpacity(talkdh[i],10);
	                        break;
	                    }
	                }
	                var talkhuoqu=document.getElementById("talk"+target.dataset.divtalk);
	                talkhuoqu.style.display="block";
	                talk.dataset.dhtstrong=target.dataset.divtalk;
	                document.getElementById("prompt"+target.dataset.divtalk).style.display="none";
	                Move(talkhuoqu,{'left':'0','opacity':'100'});
	            }
	        }
	        function setAlphaOpacity(elm,value)
	        {
	            elm=typeof elm=="string"?document.getElementById(elm):elm;
	            if(document.all){  //IE
	                elm.style.filter='alpha(opacity='+value+')';
	            }else{             //FF
	                 elm.style.opacity=value/100;
	                }
	        }

	        //控制回车键
	        var enterkey=function(ev)
	        {
	            var even = ev || window.event;
	            if(even.keyCode==13)
	            {
	            	if(writeinput.value.replace(/[\r\n]/g, "")==null||talk.dataset.dhtstrong==null)
	            	{
	            		return;
	            	}else
	            	{
	            		var touser=
	            			{
	            				"recipient": talk.dataset.dhtstrong,
	            				"Date":new Date().format('MM月dd日hh时'),
	            				"talk":writeinput.value.replace(/[\r\n]/g, "")
	            			};
	            		var jsonuser=JSON.stringify(touser); 
	            		console.log(jsonuser);
	            		onsubSend(jsonuser,clear);
	            	}
	            }
	        }

	        writeinput.onblur=function()
	        {
	            document.onkeypress="";
	        }
	        writeinput.onfocus=function()
	        {
	            document.onkeypress=enterkey;
	        }
	        //清空所有
			var clear=function()
			{
			
				writeinput.value="";
			};
			
			
	    
	}
	
	//	日期格式的转化
	Date.prototype.format = function(format){ 
		var o = { 
		"M+" : this.getMonth()+1, //month 
		"d+" : this.getDate(), //day 
		"h+" : this.getHours(), //hour 
		"m+" : this.getMinutes(), //minute 
		"s+" : this.getSeconds(), //second 
		"q+" : Math.floor((this.getMonth()+3)/3), //quarter 
		"S" : this.getMilliseconds() //millisecond 
		} 
		 
		if(/(y+)/.test(format)) { 
		format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
		} 
		 
		for(var k in o) { 
		if(new RegExp("("+ k +")").test(format)) { 
		format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
		} 
		} 
		return format; 
		}