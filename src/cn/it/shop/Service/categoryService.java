package cn.it.shop.Service;

import java.util.List;

import cn.it.shop.Pojo.category;
 
public interface categoryService extends BaseService<category>
{
	public List<category> homejt();
	public List<category> homeci();
	public List<category> cateall();
	public void deletebylist(List shanclist);
}
