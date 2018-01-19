package cn.it.shop.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.it.shop.Pojo.category;
import cn.it.shop.Pojo.product;
import cn.it.shop.Service.categoryService;
import cn.it.shop.Service.proandcateService;
import cn.it.shop.Service.productService;

@Component("productTimerTask")
public class ProductTimerTask extends TimerTask
{
	@Autowired
	private categoryService categoryService;
	@Autowired
	private proandcateService proandcateService;
	@Autowired
	private productService productService;
	private ServletContext  application;
	public ServletContext getApplication()
	{
		return application;
	}
	public void setApplication(ServletContext application)
	{
		this.application = application;
	}
	
	@Override
	public void run()
	{
		List<category> list= new ArrayList<>();
		list=categoryService.homejt();
		application.setAttribute("homeshou", list);
		
		List<category> listci=new ArrayList<>();
		listci=categoryService.homeci();
		for (category category : listci)
		{
		@SuppressWarnings({ "unused", "rawtypes" })
		List listpandc = proandcateService.profindcatebyId(Integer.parseInt(category.getCimgaddress()));
		
		List<product> listpro=productService.catebypid(listpandc);
		category.setPro(listpro);
		}
		application.setAttribute("homeci", listci);
		
	}

}
