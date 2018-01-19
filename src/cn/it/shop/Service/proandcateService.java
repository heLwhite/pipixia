package cn.it.shop.Service;

import java.util.List;

import cn.it.shop.Pojo.proandcate;

public interface proandcateService extends BaseService<proandcate>
{
	public List<proandcate> profindcatebyId(Integer id);
}
