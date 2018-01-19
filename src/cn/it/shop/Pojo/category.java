package cn.it.shop.Pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
/*
 * 
 * cid为种类主键 
 * type为类型名称
 * hot为是否热度消息
 * 
 */

@SuppressWarnings("serial")
@Entity
@Table
public class category implements Serializable
{
	private Integer cid;                            
	private String type;
	private Boolean hot;
	private String cname;
	private String cimgaddress;
	private String simple;
	private List<product> pro;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCid()
	{
		return cid;
	}
	public void setCid(Integer cid)
	{
		this.cid = cid;
	}
	
	@Column(name="type",length=20,unique=true)
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	
	@Column(name="hot",length=5,nullable=false)
	public Boolean getHot()
	{
		return hot;
	}
	public void setHot(Boolean hot)
	{
		this.hot = hot;
	}
	
	@Column(name="cname",length=10,nullable=true)
	public String getCname()
	{
		return cname;
	}
	public void setCname(String cname)
	{
		this.cname = cname;
	}
	
	@Column(name="img",length=20)
	public String getCimgaddress()
	{
		return cimgaddress;
	}
	public void setCimgaddress(String cimgaddress)
	{
		this.cimgaddress = cimgaddress;
	}
	@Column(name="simple",length=100)
	public String getSimple()
	{
		return simple;
	}
	public void setSimple(String simple)
	{
		this.simple = simple;
	}
	
	@Transient
	public List<product> getPro()
	{
		return pro;
	}
	public void setPro(List<product> pro)
	{
		this.pro = pro;
	}
	
	
	
}
