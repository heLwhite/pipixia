package cn.it.shop.Action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;

import cn.it.shop.Pojo.administor;

@SuppressWarnings("serial")
@Controller("administorAction")
@Scope("prototype")
public class administorAction extends BaseAction<administor>
{
	private String shanchulist;
	private String[] scshulist;
	@SuppressWarnings("rawtypes")
	private List shanclist;

	public String getShanchulist()
	{
		return shanchulist;
	}

	public void setShanchulist(String shanchulist)
	{
		this.shanchulist = shanchulist;
	}
	//查询所有
	public String adfindall()
	{
		List<administor> allfind=administorService.findall();
		Gson gson= new Gson();
		String json=gson.toJson(allfind);
		ActionContext.getContext().getValueStack().set("json", json);
		ActionContext.getContext().getValueStack().set("savetou", "admin");
		return "admin";
	}
	//通过list删除
	@SuppressWarnings("unchecked")
	public String deletebyid()
	{
		shanclist=new ArrayList<>();
		scshulist=shanchulist.split(" ");
		for (int i = 0; i < scshulist.length; i++)
		{
			int cc=Integer.parseInt(scshulist[i]);
			
			shanclist.add(cc);
		}
		administorService.deletebylist(shanclist);
		
		return "del";
	}
	//保存
	public String save()
	{
		administorService.save(tModel);
		return "send";
	}
	//更新操作
	public String update()
	{
		administorService.update(tModel);
		return "send";
	}
	//验证操作
	public String denglu()
	{
		Boolean laaBoolean= administorService.findbyname(tModel);
		if(laaBoolean)
		{
			session.put("loginname", "A:"+tModel.getAname());
			return "adxuanchuan";
		}
		return null;
	}
}
