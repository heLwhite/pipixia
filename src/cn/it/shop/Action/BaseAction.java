package cn.it.shop.Action;

import java.lang.reflect.ParameterizedType;
import java.util.Map;







import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.Service.administorService;
import cn.it.shop.Service.categoryService;
import cn.it.shop.Service.merchantsService;
import cn.it.shop.Service.productService;
import cn.it.shop.Service.userService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller("baseAction")
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,ApplicationAware,SessionAware,ModelDriven<T>
{
	//对象的注入
	@Autowired
	protected userService userService;
	@Autowired
	protected productService productService;
	@Autowired
	protected categoryService categoryService;
	@Autowired
	protected administorService administorService;
	@Autowired
	protected merchantsService merchantsService;
	
	//域对象
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	
	protected T tModel;
	@SuppressWarnings("unchecked")
	@Override
	public T getModel()
	{
		ParameterizedType parameterizedType=  (ParameterizedType) this.getClass().getGenericSuperclass();
		@SuppressWarnings("rawtypes")
		Class clazz=(Class) parameterizedType.getActualTypeArguments()[0];
		try
		{
			tModel=(T) clazz.newInstance();
		} catch(InstantiationException e)
		{
			
			e.printStackTrace();
		} catch(IllegalAccessException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return tModel;
	}

	@Override
	public void setSession(Map<String, Object> arg0)
	{
		this.session=arg0;
		
	}

	@Override
	public void setApplication(Map<String, Object> arg0)
	{
		this.application=arg0;
		
	}

	@Override
	public void setRequest(Map<String, Object> arg0)
	{
		this.request=arg0;
		
	}

	

}
