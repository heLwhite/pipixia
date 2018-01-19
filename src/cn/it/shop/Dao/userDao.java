package cn.it.shop.Dao;

import cn.it.shop.Pojo.user;

public interface userDao extends BaseDao<user>
{

	public Boolean login(user tModel);
	
}
