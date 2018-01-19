package cn.it.shop.Dao;

import java.util.List;

import cn.it.shop.Pojo.proandcate;

public interface proandcateDao extends BaseDao<proandcate>
{
		public List<proandcate> profindcatebyId(Integer id);
}
