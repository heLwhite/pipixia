package cn.it.shop.Dao.Imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.it.shop.Dao.merchantsDao;
import cn.it.shop.Pojo.merchants;

@Repository("merchantsDao")
public class merchantsDaoImp extends BaseDaoImp<merchants> implements merchantsDao
{
	//删除
	@Override
	public void deletebylist(List shanclist)
	{
		// TODO 自动生成的方法存根
		String hql="delete merchants s where s.mid in(:pidlist)";
		getSession().createQuery(hql).setParameterList("pidlist", shanclist).executeUpdate();
	}

}
