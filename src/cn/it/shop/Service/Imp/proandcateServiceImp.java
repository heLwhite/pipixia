package cn.it.shop.Service.Imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.it.shop.Pojo.proandcate;
import cn.it.shop.Service.proandcateService;

@Service("pandcateService")
@Transactional
public class proandcateServiceImp extends BaseServiceImp<proandcate> implements proandcateService
{

	@Override
	public List<proandcate> profindcatebyId(Integer id)
	{
		
		return proandcateDao.profindcatebyId(id);
	}

}
