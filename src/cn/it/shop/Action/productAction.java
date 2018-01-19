package cn.it.shop.Action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;

import cn.it.shop.Pojo.product;

@SuppressWarnings("serial")
@Controller("productAction")
@Scope("prototype")
public class productAction extends BaseAction<product>
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
	//查看所有
	public String  profindall()
	{
		List<product> list=productService.query();
		Gson gson=new Gson();
		String json=gson.toJson(list);
		ActionContext.getContext().getValueStack().set("json", json);
		ActionContext.getContext().getValueStack().set("savetou", "pro");
		return "proall";
	}
	//pro通过list删除
	public String deletebyid()
	{
		shanclist=new ArrayList<>();
		scshulist=shanchulist.split(" ");
		for (int i = 0; i < scshulist.length; i++)
		{
			int cc=Integer.parseInt(scshulist[i]);		
			shanclist.add(cc);
		}
		productService.deletebylist(shanclist);
		return "del";
	}
}
