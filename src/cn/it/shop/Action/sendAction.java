package cn.it.shop.Action;


import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller("sendAction")
public class sendAction extends ActionSupport
{

	@Override
	public String execute() throws Exception
	{
		
		return "send";
	}
	
	public String mainindex()
	{
		return "sendindex";
	}
	
	public String admin()
	{
		return "admin";
	}

}
