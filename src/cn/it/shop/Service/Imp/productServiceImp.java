package cn.it.shop.Service.Imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.it.shop.Pojo.proandcate;
import cn.it.shop.Pojo.product;
import cn.it.shop.Service.productService;

@Service("productService")
@Transactional
public class productServiceImp extends BaseServiceImp<product> implements productService
{

	@Override
	public List<product> catebypid(List list)
	{
		
		return productDao.catebypid(list);
	}

	@Override
	public void deletebylist(List shanclist)
	{
		productDao.deletebylist(shanclist);
		
	}

}
