function createXmlHttpRequest()
{
	try{
		return new XMLHttpRequest();
	}catch(e)
	{
		try{
			return ActvieXObject("Msxml2.XMLHTTP");
		}catch(e)
		{
			alter("请更换新版本的浏览器");
		}
	}
}


function ajax(option)
{
	var xmlHttp =createXmlHttpRequest();
	
	if(!option.method)
	{
		option.method="GET";
			
	}
	if(option.asyn==null)
	{
		option.asyn=true;
	}
	
	
	xmlHttp.open(option.method,option.url,option.asyn);
	if("POST"==option.method)
		{
			xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		}
	xmlHttp.send(option.params);
	/*
	注册监听
	*/
	xmlHttp.onreadystatechange=function()
	{
		if(xmlHttp.readyState==4 && xmlHttp.status==200)
			{
				var data; 
				if(!option.type)
					{data = xmlHttp.responseText;}
				
				else if(option.type=="xml")
					{
						data = xmlHttp.responseXML;
					}
				else if(option.type=="text")
					{
						data = xmlHttp.responseText;
					}
				else if(option.type == "json")		
					{
					    var text = xmlHttp.responseText;
					    data = eval("("+text+")");
					}
				
				option.roolback(data);
			}
	};
	
}
