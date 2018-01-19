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
 * aname为 管理员的账户
 * apwd 为密码
 * aindate 为入职
 * namestring为名称
 * wage 为工资
 * 
 */


@SuppressWarnings("serial")
@Entity
@Table
public class administor implements Serializable
{


	private int aid;
	private String aname;
	private String apwd;
	private Date aindate;
	private String namestring;
	private String wage;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getAid()
	{
		return aid;
	}
	public void setAid(int aid)
	{
		this.aid = aid;
	}
	
	@Column(length=20,nullable=false,name="name",unique=true)
	public String getAname()
	{
		return aname;
	}
	public void setAname(String aname)
	{
		this.aname = aname;
	}
	
	@Column(length=20,nullable=false,name="password")
	public String getApwd()
	{
		return apwd;
	}
	public void setApwd(String apwd)
	{
		this.apwd = apwd;
	}
	
	@Column(name="indate")
	public Date getAindate()
	{
		return aindate;
	}
	public void setAindate(Date aindate)
	{
		this.aindate = aindate;
	}
	@Column(name="loginname",length=40,nullable=false,unique=true)
	public String getNamestring()
	{
		return namestring;
	}
	public void setNamestring(String namestring)
	{
		this.namestring = namestring;
	}
	
	@Column(length=10,name="wage")
	public String getWage()
	{
		return wage;
	}
	public void setWage(String wage)
	{
		this.wage = wage;
	}
	
	
	
}
