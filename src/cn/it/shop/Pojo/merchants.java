package cn.it.shop.Pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * name 为商户名称
 * mpwd 为登录密码
 * maddress为注册地址
 * mshoptype为售卖类型
 * money为注册保证金
 * mindate为申请日期
 * mlongdate为商户注册时间
 */
@SuppressWarnings("serial")
@Entity
@Table
public class merchants implements Serializable
{
	
	private Integer mid;
	private String mname;
	private String mpwd;
	private String maddress;
	private String mshoptype;
	private double money;
	private Date mindate;
	private int mlongdate;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getMid()
	{
		return mid;
	}
	public void setMid(Integer mid)
	{
		this.mid = mid;
	}
	
	@Column(name="name",nullable=false,length=50)
	public String getMname()
	{
		return mname;
	}
	public void setMname(String mname)
	{
		this.mname = mname;
	}
	
	@Column(name="password",nullable=false,length=30)
	public String getMpwd()
	{
		return mpwd;
	}
	public void setMpwd(String mpwd)
	{
		this.mpwd = mpwd;
	}
	public String getMaddress()
	{
		return maddress;
	}
	public void setMaddress(String maddress)
	{
		this.maddress = maddress;
	}
	public String getMshoptype()
	{
		return mshoptype;
	}
	public void setMshoptype(String mshoptype)
	{
		this.mshoptype = mshoptype;
	}
	public double getMoney()
	{
		return money;
	}
	public void setMoney(double money)
	{
		this.money = money;
	}
	public Date getMindate()
	{
		return mindate;
	}
	public void setMindate(Date mindate)
	{
		this.mindate = mindate;
	}
	public int getMlongdate()
	{
		return mlongdate;
	}
	public void setMlongdate(int mlongdate)
	{
		this.mlongdate = mlongdate;
	}
	
}
