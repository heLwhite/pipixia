package cn.it.shop.Pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="pandc")
public class proandcate implements Serializable
{
	private Integer id;
	private Integer pid;
	private Integer cid;
	private Integer salesvolume;   //销售情况
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	@Column(name="product",length=20,nullable=false,unique=true)
	public Integer getPid()
	{
		return pid;
	}
	public void setPid(Integer pid)
	{
		this.pid = pid;
	}
	
	@Column(name="categery",length=20,nullable=false)
	public Integer getCid()
	{
		return cid;
	}
	public void setCid(Integer cid)
	{
		this.cid = cid;
	}
	public Integer getSalesvolume()
	{
		return salesvolume;
	}
	public void setSalesvolume(Integer salesvolume)
	{
		this.salesvolume = salesvolume;
	}
	
	
}
