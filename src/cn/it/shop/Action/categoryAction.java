package cn.it.shop.Action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;

import cn.it.shop.Pojo.category;

@SuppressWarnings("serial")
@Controller("categoryAction")
@Scope("prototype")
public class categoryAction extends BaseAction<category>
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
	public String cafindall()
	{
		List<category> alllist=categoryService.cateall();
		Gson gson=new Gson();
		String cagson=gson.toJson(alllist);
		System.out.println(cagson);
		ActionContext.getContext().getValueStack().set("json", cagson);
		ActionContext.getContext().getValueStack().set("savetou", "cate");
		return "cate";
	}
	//删除操作
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
		
		categoryService.deletebylist(shanclist);
		return "del";
	}
	
	public String save()
	{
		categoryService.save(tModel);
		return "send";
	}
	
	public String update()
	{
		categoryService.update(tModel);
		return "send";
	}
}
