package cn.it.shop.category.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.Pojo.category;
import cn.it.shop.Pojo.product;
import cn.it.shop.Service.categoryService;
import cn.it.shop.Service.proandcateService;
import cn.it.shop.Service.productService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class catetest
{
	@Autowired
	private categoryService categoryService;
	@Autowired
	private productService productService;
	@Autowired
	private proandcateService proandcateService;
	
	@Test
	public void qushu()
	{
		List<category> list = categoryService.homejt();
		for (category category : list)
		{
			System.out.println(category.getSimple());
		}
	}
	@Test
	public void quci()
	{
		List<category> list = categoryService.homeci();
		for (category category : list)
		{
		@SuppressWarnings({ "unused", "rawtypes" })
		List listpandc = proandcateService.profindcatebyId(Integer.parseInt(category.getCimgaddress()));
		
		List<product> listpro=productService.catebypid(listpandc);
		category.setPro(listpro);
		}
		
		
		
		for (category category : list)
		{
			
			for (product product : category.getPro())
			{
				System.out.println(product.getPsimpimf());
			}
		}
		
		
	}
	@Test
	public void cateall()
	{
		List<category> list = categoryService.cateall();
		System.out.println(list.toString());
	}
}
