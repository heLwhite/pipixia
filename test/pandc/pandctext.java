package pandc;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import cn.it.shop.Service.proandcateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class pandctext
{
	@Autowired
	private proandcateService pandcateService;
	
	@Test
	public void findbyId()
	{
		@SuppressWarnings("rawtypes")
		List list=pandcateService.profindcatebyId(3);
		for (int i = 0; i < list.size(); i++)
		{
			
			System.out.println(list.get(i));
		}
		
	}
}
