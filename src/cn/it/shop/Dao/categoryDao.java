package cn.it.shop.Dao;

import java.util.List;

import cn.it.shop.Pojo.category;

public interface categoryDao extends BaseDao<category>
{
	public List<category> homejp();
	public List<category> honeci();
	public List<category> cateall();
	public void deletebylist(List shanclist);
}
