package cn.it.shop.Action;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;

import cn.it.shop.Pojo.user;

@SuppressWarnings("serial")
@Controller("userAction")
@Scope("prototype")
public class userAction extends BaseAction<user>
{
	
	public String login() throws IOException
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		Boolean login =userService.login(tModel);
		if(login)
		{
			System.out.println("密码正确");
			session.put("username", tModel.getUloginname());
			response.getWriter().print("pwdqueren");
			return null;
		}else
		{
			response.getWriter().print("pwderrow");
			return null;
		}
		
		
		
	}
	
	public String text() throws IOException
	{
		HttpServletResponse httpServletResponse= ServletActionContext.getResponse();
		httpServletResponse.getWriter().print("sddsd");
		return null;
	}

	public String userall()
	{
		List<user> list = userService.query();
		Gson gson=new Gson();
		String json=gson.toJson(list);
		ActionContext.getContext().getValueStack().set("json", json);
		ActionContext.getContext().getValueStack().set("savetou", "user");
		return "user";
	}
}
