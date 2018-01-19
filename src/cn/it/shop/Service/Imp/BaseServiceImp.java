package cn.it.shop.Service.Imp;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;















import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.it.shop.Dao.BaseDao;
import cn.it.shop.Dao.proandcateDao;
import cn.it.shop.Dao.administorDao;
import cn.it.shop.Dao.categoryDao;
import cn.it.shop.Dao.merchantsDao;
import cn.it.shop.Dao.productDao;
import cn.it.shop.Dao.userDao;
import cn.it.shop.Pojo.product;
import cn.it.shop.Service.BaseService;

@Service("baseService")
@Transactional
@Lazy(true)
public class BaseServiceImp<T> implements BaseService<T>
{
	private Class clazz;
	public BaseServiceImp()
	{
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz= (Class) parameterizedType.getActualTypeArguments()[0];
	}
	
	@PostConstruct
	public void init() {
		//根据clazz的类型，把不同的dao对象复制给baseDao对象
		String clazzName = clazz.getSimpleName();
		String clazzDao = clazzName.substring(0, 1).toLowerCase() 
				+ clazzName.substring(1) + "Dao"; //例如Account==>accountDao
		System.out.println(clazzDao);
		try {
			Field clazzField = this.getClass().getSuperclass().getDeclaredField(clazzDao);
			Field baseField = this.getClass().getSuperclass().getDeclaredField("baseDao");
			baseField.set(this, clazzField.get(this)); //baseDao就有值了
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	protected BaseDao<T> baseDao;
	//对象的注入
	@Autowired
	protected userDao userDao;
	@Autowired
	protected administorDao administorDao;
	@Autowired
	protected categoryDao categoryDao;
	@Autowired
	protected productDao productDao;
	@Autowired
	protected merchantsDao merchantsDao;
	@Autowired
	protected proandcateDao proandcateDao;
	
	@Override
	public void save(T t)
	{
		baseDao.save(t);
		
	}

	@Override
	public void update(T t)
	{
		baseDao.update(t);
		
	}

	@Override
	public void delete(int id)
	{
		baseDao.delete(id);
		
	}

	@Override
	public T get(int id)
	{
		// TODO 自动生成的方法存根
		return (T)baseDao.get(id);
	}

	@Override
	public List<T> query()
	{
		// TODO 自动生成的方法存根
		return baseDao.query();
	}

}
