package cn.it.shop.Dao;

import java.util.List;

import cn.it.shop.Pojo.product;

public interface productDao extends BaseDao<product>
{
	public List<product> catebypid(List list);

	public void deletebylist(List shanclist);
}
