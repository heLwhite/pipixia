package cn.it.shop.Service.Imp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.it.shop.Pojo.user;
import cn.it.shop.Service.userService;
@Service("userService")
@Transactional
public class userServiceImp extends BaseServiceImp<user> implements userService
{

	@Override
	public Boolean login(user tModel)
	{
		Boolean loginyz=userDao.login(tModel);
		return loginyz;
	}

	

	

}
