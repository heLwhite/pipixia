package cn.it.shop.Service.Imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.it.shop.Pojo.administor;
import cn.it.shop.Service.administorService;

@Service("administorService")
@Transactional
public class administorServiceImp extends BaseServiceImp<administor> implements administorService
{

	@Override
	public List<administor> findall()
	{
		return administorDao.findall();
		
	}

	@Override
	public void deletebylist(List scshulist)
	{
		administorDao.deletebylist(scshulist);
		
	}

	@Override
	public Boolean findbyname(administor tModel)
	{
		// TODO 自动生成的方法存根
		return administorDao.findbyname(tModel);
	}

}
