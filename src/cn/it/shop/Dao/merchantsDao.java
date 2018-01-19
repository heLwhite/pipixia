package cn.it.shop.Dao;

import java.util.List;

import cn.it.shop.Pojo.merchants;

public interface merchantsDao extends BaseDao<merchants>
{

	void deletebylist(List shanclist);

}
