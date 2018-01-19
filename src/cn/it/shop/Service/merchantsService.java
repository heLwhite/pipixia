package cn.it.shop.Service;

import java.util.List;

import cn.it.shop.Pojo.merchants;

public interface merchantsService extends BaseService<merchants>
{

	void deletebylist(List shanclist);

}
