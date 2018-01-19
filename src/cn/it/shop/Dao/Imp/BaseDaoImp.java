package cn.it.shop.Dao.Imp;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import cn.it.shop.Dao.BaseDao;
@Repository("baseDao")
@Lazy(true)
public  class BaseDaoImp<T> implements BaseDao<T>
{
	
	
	@SuppressWarnings("rawtypes")
	private Class clazz;
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("rawtypes")
	public BaseDaoImp()
	{
		ParameterizedType parameterizedType= (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz=(Class) parameterizedType.getActualTypeArguments()[0];
	}
	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void save(T t)
	{
		getSession().save(t);
		
	}

	@Override
	public void update(T t)
	{
		getSession().update(t);
		
	}

	@Override
	public void delete(int id)
	{
		String hql ="delete " + clazz.getSimpleName()+" as c from c.id=id";
		getSession().createQuery(hql)
				.setInteger("id", id)
				.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int id)
	{
		
		return (T) getSession().get(clazz, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> query()
	{
		String hql="from " + clazz.getSimpleName();
		
		return getSession().createQuery(hql).list();
	}

	

}
