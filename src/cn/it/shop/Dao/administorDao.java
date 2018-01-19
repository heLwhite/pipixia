package cn.it.shop.Dao;

import java.util.List;

import cn.it.shop.Pojo.administor;

public interface administorDao extends BaseDao<administor>
{

	public List<administor> findall();

	public void deletebylist(List scshulist);

	public Boolean findbyname(administor tModel);

}
