package cn.it.shop.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;

import cn.it.shop.Pojo.merchants;

@SuppressWarnings("serial")
@Controller("merchantsAction")
@Scope("prototype")
public class merchantsAction extends BaseAction<merchants>
{
	private File file;
	private String fileFileName;
	private String fileContentType;
	
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
	
	public File getFile()
	{
		return file;
	}
	public void setFile(File file)
	{
		this.file = file;
	}
	public String getFileFileName()
	{
		return fileFileName;
	}

	public void setFileFileName(String fileFileName)
	{
		this.fileFileName = fileFileName;
	}

	public String getFileContentType()
	{
		return fileContentType;
	}

	public void setFileContentType(String fileContentType)
	{
		this.fileContentType = fileContentType;
	}
	
	public String upload() throws IOException
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String path=request.getRealPath("/upload");
		InputStream iStream=new FileInputStream(file);
		OutputStream oStream=new FileOutputStream(new File(path,fileFileName));
		byte[] buffer = new byte[200];
		int len=0;
		while((len=iStream.read(buffer))!=-1)
		{
			oStream.write(buffer,0,len);
		}
		iStream.close();
		oStream.close();
		return "ss";
	}

	// 查询所有的商户
	public String merchall()
	{
		List<merchants> list=merchantsService.query();
		Gson gson = new Gson();
		String json=gson.toJson(list);
		ActionContext.getContext().getValueStack().set("json", json);
		ActionContext.getContext().getValueStack().set("savetou", "merch");
		return "merch";
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
		merchantsService.deletebylist(shanclist);
		return "del";
	}
}
