package cn.it.shop.product.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.Pojo.product;
import cn.it.shop.Service.productService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class producttext
{
	@Autowired
	private productService productService;
	
	@Test
	public void findBylist()
	{
		List<Integer> li=new  ArrayList<>();
		li.add(1);
		li.add(2);
		System.out.println(li);
		List<product> list=productService.catebypid(li);
		for (product product : list)
		{
			System.out.println(product.getPsimpimf());
		}
	}
}
