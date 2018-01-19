package cn.it.shop.Service;

import java.util.List;

import cn.it.shop.Pojo.administor;

public interface administorService extends BaseService<administor>
{

	public List<administor> findall();

	public void deletebylist(List shanclist);

	public Boolean findbyname(administor tModel);

}
