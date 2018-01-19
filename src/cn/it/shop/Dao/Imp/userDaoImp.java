package cn.it.shop.Dao.Imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.it.shop.Dao.userDao;
import cn.it.shop.Pojo.user;

@Repository("userDao")
public class userDaoImp extends BaseDaoImp<user> implements userDao 
{

	@SuppressWarnings("unchecked")
	@Override
	public Boolean login(user tModel)
	{
		String hql="from user  where uname = ? and upwd = ? " ;
		List<user> list=getSession().createQuery(hql)
										.setString(0, tModel.getUname())
										.setString(1, tModel.getUpwd()).list();
		
		
		if (list.size()==0)
		{
			return false;
		}else
		{
			return true;
		}
		
	}

	

}
