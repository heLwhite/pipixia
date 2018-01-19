package cn.it.shop.Dao.Imp;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.it.shop.Dao.administorDao;
import cn.it.shop.Pojo.administor;
import cn.it.shop.Pojo.user;

@Repository("administorDao")
public class administorDaoImp extends BaseDaoImp<administor> implements administorDao
{

	@SuppressWarnings("unchecked")
	@Override
	public List<administor> findall()
	{
		String hql="from administor";
		List<administor> admlist=getSession().createQuery(hql).list();		
		return admlist;
	}

	@Override
	public void deletebylist(List scshulist)
	{
		
		String hql="delete administor s where s.aid in(:pidlist)";
		getSession().createQuery(hql).setParameterList("pidlist", scshulist).executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean findbyname(administor tModel)
	{
		// TODO 自动生成的方法存根
		String hql="from administor where aname=? and apwd=?";
		List<user> list=getSession().createQuery(hql)
				.setString(0, tModel.getAname())
				.setString(1, tModel.getApwd()).list();


		if (list.size()==0)
		{
			return false;
		}else
		{
			return true;
		}
	}

}
