package cn.it.shop.Dao.Imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.it.shop.Dao.proandcateDao;
import cn.it.shop.Pojo.proandcate;

@Repository("proandcateDao")
public class proandcateDaoImp extends BaseDaoImp<proandcate> implements proandcateDao 
{

	@SuppressWarnings("unchecked")
	@Override
	public List<proandcate> profindcatebyId(Integer id)
	{
		String hql= "select pn.pid from proandcate pn where pn.cid=?";
		List<proandcate> list= getSession().createQuery(hql).setParameter(0, id).list();
		return list;
	}
	
}
