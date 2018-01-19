package cn.it.shop.Dao.Imp;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.GET;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.it.shop.Dao.categoryDao;
import cn.it.shop.Pojo.category;

@Repository("categoryDao")
public class categoryDaoImp extends BaseDaoImp<category> implements categoryDao
{
	//dao层的选出精品
	@Override
	public List<category> homejp()
	{
		String hql0 = "select count(cn) from category cn where cn.simple <> null";
		Long integer= (Long) getSession().createQuery(hql0).uniqueResult();
		Integer Title=(int) (integer-5);
		Random random =new  Random();
		Integer integer2=random.nextInt(Title);
		String hql = "from category cn where cn.simple <> null";		
		Query query=getSession().createQuery(hql);
		query.setFirstResult(integer2);
		query.setMaxResults(5);
		@SuppressWarnings("unchecked")
		List<category> list= query.list();
		return list;
	}
	//dao层的选出精品的下层
	@SuppressWarnings("unchecked")
	@Override
	public List<category> honeci()
	{
		
		String hql="from category cn where cn.simple=null";
		
		List<category> cList=getSession().createQuery(hql).list();
		return cList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<category> cateall()
	{
		String hql="from category cn where cn.simple <> null";
		List<category> cList=getSession().createQuery(hql).list();
		return cList;
	}
	
	//控制层list删除操作
	@Override
	public void deletebylist(List shanclist)
	{
		String hql="delete category s where s.cid in(:pidlist)";
		getSession().createQuery(hql).setParameterList("pidlist", shanclist).executeUpdate();
		
	}
	
}
