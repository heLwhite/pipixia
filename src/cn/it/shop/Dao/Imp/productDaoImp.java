package cn.it.shop.Dao.Imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.it.shop.Dao.productDao;
import cn.it.shop.Pojo.product;

@Repository("productDao")
public class productDaoImp extends BaseDaoImp<product> implements productDao
{

	@SuppressWarnings("unchecked")
	@Override
	public List<product> catebypid(List clist)
	{
		String hql = "from product pn where pn.pid in(:pidlist)";
		List<product>  list = getSession().createQuery(hql).setParameterList("pidlist", clist).list();
		return list;
	}
	
	//dao层实现通过list删除
	@Override
	public void deletebylist(List shanclist)
	{
		String hql="delete product s where s.pid in(:pidlist)";
		getSession().createQuery(hql).setParameterList("pidlist", shanclist).executeUpdate();
		
	}

}
