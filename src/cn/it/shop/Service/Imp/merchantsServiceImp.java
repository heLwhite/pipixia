package cn.it.shop.Service.Imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.it.shop.Pojo.merchants;
import cn.it.shop.Service.merchantsService;

@Service("merchantsService")
@Transactional
public class merchantsServiceImp extends BaseServiceImp<merchants> implements merchantsService
{

	@Override
	public void deletebylist(List shanclist)
	{
		// TODO 自动生成的方法存根
		merchantsDao.deletebylist(shanclist);
	}

}
