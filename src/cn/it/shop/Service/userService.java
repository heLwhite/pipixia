package cn.it.shop.Service;

import cn.it.shop.Pojo.user;

public interface userService extends BaseService<user>
{

	public Boolean login(user tModel);

}
