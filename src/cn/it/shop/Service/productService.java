package cn.it.shop.Service;

import java.util.List;

import cn.it.shop.Pojo.proandcate;
import cn.it.shop.Pojo.product;


public interface productService extends BaseService<product> 
{
	public List<product> catebypid(List list);

	public void deletebylist(List shanclist);
}
