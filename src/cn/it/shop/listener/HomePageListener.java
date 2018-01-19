package cn.it.shop.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.it.shop.Util.ProductTimerTask;



public class HomePageListener implements ServletContextListener
{
	//获取参数
	ApplicationContext context=null;
	@Autowired
	ProductTimerTask protimer;

	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0)
	{
		context=WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext()); 
		protimer= (ProductTimerTask) context.getBean("productTimerTask");
		protimer.setApplication(arg0.getServletContext());
		new Timer(true).schedule(protimer, 0,1000*60*60*24);
	}

}
