package cn.it.shop.user;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.Pojo.user;
import cn.it.shop.Service.userService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class usertext
{
	@Autowired
	private userService userService;
	
	//用户登录测试
	@Test
	public void login()
	{
		user  user = new user();
		user.setUname("hejinze");
		user.setUpwd("459299");
		Boolean boolean1= userService.login(user);
		if(boolean1)
		{
			System.out.println("你成功了");
		}else
		{
			System.out.println("没这个人");
		}
	}
}
