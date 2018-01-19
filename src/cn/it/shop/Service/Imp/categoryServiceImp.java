package cn.it.shop.Service.Imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.it.shop.Pojo.category;
import cn.it.shop.Service.categoryService;

@Service("categoryService")
@Transactional
public class categoryServiceImp extends BaseServiceImp<category> implements categoryService
{
	//服务层的精品挑选
	@Override
	public List<category> homejt()
	{
		List<category> list= categoryDao.homejp();
		return list;
	}
	//服务层的精品下层选择
	@Override
	public List<category> homeci()
	{
		
		return categoryDao.honeci();
	}
	@Override
	public List<category> cateall()
	{
		// TODO 自动生成的方法存根
		return categoryDao.cateall();
	}
	
	//
	@Override
	public void deletebylist(List shanclist)
	{
		// TODO 自动生成的方法存根
		categoryDao.deletebylist(shanclist);
	}

}
