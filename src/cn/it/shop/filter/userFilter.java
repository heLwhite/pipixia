package cn.it.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class userFilter implements Filter
{

	@Override
	public void destroy()
	{
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
		// TODO 自动生成的方法存根
		
	}

}
