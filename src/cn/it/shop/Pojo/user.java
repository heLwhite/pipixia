package cn.it.shop.Pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * uid为主键名称
 * uname 为用户名称
 * upwd 为用户密码
 * uloginname为用户的登录时的名称
 * usex为用户的性别
 * uphone 为用户使用的电话号码
 * uimg 为用户的所使用的照片
 * 
 */
@Entity
@Table
public class user implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2382540779497969246L;
	
	
	private Integer uid;
	private String uname;
	private String upwd;
	private String uloginname;
	private String usex;
	private String uphone;
	private String uimg;
	
	
	public user()
	{
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getUid()
	{
		return uid;
	}
	public void setUid(Integer uid)
	{
		this.uid = uid;
	}
	
	@Column(length=10,nullable=false,name="name")
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	
	@Column(length=20,nullable=false,name="password")
	public String getUpwd()
	{
		return upwd;
	}
	public void setUpwd(String upwd)
	{
		this.upwd = upwd;
	}
	
	@Column(length=20,nullable=false,name="loginname")
	public String getUloginname()
	{
		return uloginname;
	}
	public void setUloginname(String uloginname)
	{
		this.uloginname = uloginname;
	}
	
	@Column(length=20,name="sex")
	public String getUsex()
	{
		return usex;
	}
	public void setUsex(String usex)
	{
		this.usex = usex;
	}

	@Column(length=20,name="phone")
	public String getUphone()
	{
		return uphone;
	}
	public void setUphone(String uphone)
	{
		this.uphone = uphone;
	}
	
	@Column(length=50,name="img")
	public String getUimg()
	{
		return uimg;
	}
	public void setUimg(String uimg)
	{
		this.uimg = uimg;
	}
	
}
