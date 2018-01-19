window.onload=function()
{	
	var json =	[
	          	 {"admin":
					{
						"aname":"登录账户",
						"apwd":"密码",
						"aindate":"入职日期",
						"namestring":"名称",
						"wage":"工资",
						"aid":""
					}
	          	 },
				 {
					"cate":
					{
						"type":"种类类型",
						"hot":"热度关注",
						"cname":"种类简称",
						"cimgaddress":"图片地址",
						"simple":"简单描述",
						"cid":""
					}

				 }
				];
	
	var hougroup=document.getElementById("hougroup");
	//	操作三按钮
	var shanchu=document.getElementById("shanchu"); 
	var xiugai=document.getElementById("xiugai");
	var tianjia=document.getElementById("tianjia");
	var caozuo=document.getElementsByClassName("caozuo");
	
	//提交按钮
	var submit=document.getElementById("submit");
	//覆盖层的编写
	var fugai=document.getElementById("fugai");
	var change=document.getElementById("change");
	var closefugai=document.getElementById("closefugai");
	
	var changeformin=document.getElementById("changeform").getElementsByTagName("input");
	
	var changeform=document.getElementById("changeform");
	//获取左边按钮的参数改变
	var datashuju=document.getElementById("datashuju");
	datashuju.onclick=function(ev)
	{
	    var target = ev.target || ev.srcElement;
	    //确定当前iframe的网站状态
	    var dataid;
	    if(target.tagName=="A")
	    {
	    	dataid=target.parentNode.dataset.id;
	    }else
	    	{
	    		dataid=target.dataset.id;
	    	}
	    hougroup.dataset.table=dataid;
	    //判断按钮的状态
	    switch(dataid)
	    {
	    	case "admin" : gnanniu();shanchu.style.display="block";xiugai.style.display="block";tianjia.style.display="block"; break;
	    	case "cate" : gnanniu();shanchu.style.display="block";xiugai.style.display="block";tianjia.style.display="block";break;
	    	case "product" : gnanniu();shanchu.style.display="block"; break;
	    	case "merch" :gnanniu();break;
	    	case "user":gnanniu();break;
	    }
	}
	
	//提交按钮
	changeform.onsubmit=function()
	{
	   var 	dateinput = document.getElementsByClassName("dateinput")[0];
	   dateinput.disabled=false;
	}
	
	//关闭按钮
	var gnanniu=function()
	{
		for(var i=0;i<caozuo.length;i++)
		{
			caozuo[i].style.display="none";
		}
	}
	
	//获取页面的宽和高
	var Swidth=document.documentElement.scrollWidth;
	fugai.style.height=700+'px';
	fugai.style.width=Swidth+'px';
	
	//删除操作
	shanchu.onclick=function()
	{
		
		var shanchulist="";   //数据存储list
		var iframedata=hougroup.dataset.table;
		var biaohao=getIFrameDOM("hougroup").getElementsByClassName("adid");
		if(iframedata)
			{
			for (var i = 0; i < biaohao.length; i++) 
			{
				if(biaohao[i].firstChild.checked)
				{
					shanchulist=shanchulist+biaohao[i].parentNode.getElementsByClassName("aaid")[0].value+' ';
				};	
			}
			if(shanchulist=="")
			{
				alert("请选中一个目标");
			}else
			{
				hougroup.src=iframedata+'_deletebyid.action?shanchulist='+shanchulist+'';
			}
		}
	};
	
	
	//添加操作
	tianjia.onclick=function()
	{
		
		fugai.style.display="block";
		var changeweight=change.offsetWidth;
		var changeleft=Math.round((Swidth-changeweight)*0.5);
		change.style.left=changeleft+'px';
		var zhuangtai=hougroup.dataset.table;
		var data= datashow(zhuangtai);
		changeform.innerHTML="<button type=\"submit\">提交</button><button>清空</button>";
		changeform.action=hougroup.dataset.table+"_save.action";
		for(var k in data)
		{
			for(var j in data[k])
			{
				var adddiv=document.createElement("div");
				adddiv.className="hougpdiv";
				adddiv.innerHTML=data[k][j];
				var input=document.createElement("input");
				
				if(j=="hot")
				{
					
					input.type="checkbox";
				}else if(j.indexOf("id")>0)
					{
						input.type="hidden";
					}else
					{
						input.type="text";
					}
				input.name=j;
				if(j.indexOf("date")>0)
				{
					var time1 = new Date().format("yyyy-MM-dd hh:mm:ss");
					input.value=time1;
					input.className="dateinput";
					input.disabled=true;
					
				}
				
				changeform.appendChild(adddiv);
				changeform.appendChild(input);
			}
		}
	}
	
	//更新操作
	xiugai.onclick=function()
	{
	
		//检测选中数量
		var shuliang=0;
		//选中标记
		var title=0;
		var biaohao=getIFrameDOM("hougroup").getElementsByClassName("adid");
		var bhtr=getIFrameDOM("hougroup").getElementsByClassName("caaa");
		for (var i = 0; i < biaohao.length; i++) 
		{
			if(biaohao[i].firstChild.checked)
			{
				shuliang=shuliang+1;
				title=i;
			}	
		}
		
		
		
		if(shuliang==1)
		{
			var tjiedian=bhtr[title].getElementsByTagName("th");
			var ijiedian=bhtr[title].getElementsByTagName("input")[1];
			var fugaiinput=changeform.getElementsByTagName("input");
			fugai.style.display="block";
			var changeweight=change.offsetWidth;
			var changeleft=Math.round((Swidth-changeweight)*0.5);
			change.style.left=changeleft+'px';
			tianjia.onclick();
			changeform.action=hougroup.dataset.table+"_update.action";
			for(var i=1;i<tjiedian.length;i++)
		    {
				if(fugaiinput[i-1].type=="checkbox")
				{
					fugaiinput[i-1].checked=tjiedian[i].innerHTML;
				}else
					{
						fugaiinput[i-1].value=tjiedian[i].innerHTML;
					}
			}
			
			fugaiinput[i-1].value=ijiedian.value;
		}else
			{
				alert("请选择1个作为标记");
			}
	}
	//关闭层
	closefugai.onclick=function()
	{
		fugai.style.display="none";
		for (var i = 0; i < changeformin.length; i++) 
		{
			changeformin[i].value="";
		}
		
	}
	
	//数据获取层
	var datashow=function(data)
	{
		for(var i=0;i<json.length;i++)
		{
			for(var j in json[i])
			{
				if(data==j)
					{
						return json[i];
					}
			}
		}
	};
	
};


	//获取iframe中的值
	function getIFrameDOM(id)
	{
	
	    return document.getElementById(id).contentDocument || document.frames[id].document;
	
	}
	//时间转换
	Date.prototype.format = function(fmt) { 
	     var o = { 
	        "M+" : this.getMonth()+1,                 //月份 
	        "d+" : this.getDate(),                    //日 
	        "h+" : this.getHours(),                   //小时 
	        "m+" : this.getMinutes(),                 //分 
	        "s+" : this.getSeconds(),                 //秒 
	        "q+" : Math.floor((this.getMonth()+3)/3), //季度 
	        "S"  : this.getMilliseconds()             //毫秒 
	    }; 
	    if(/(y+)/.test(fmt)) {
	            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	    }
	     for(var k in o) {
	        if(new RegExp("("+ k +")").test(fmt)){
	             fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
	         }
	     }
	    return fmt; 
	} 



