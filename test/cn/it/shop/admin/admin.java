package cn.it.shop.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.Pojo.administor;
import cn.it.shop.Service.administorService;
import cn.it.shop.Util.timechangegeshi;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class admin
{
	@Autowired
	private administorService administorService;
	
	@Test
	public void findalltext()
	{
		List<administor> all=administorService.findall();
		for (administor administor : all)
		{
			Date bb= timechangegeshi.date2date(administor.getAindate(), timechangegeshi.YYYY_MM_DD);
			System.out.println(bb);
		}
		
	}
	
	@Test
	public void delete()
	{
		List aa= new ArrayList<>();
		aa.add(7);
		administorService.deletebylist(aa);
	}
}
