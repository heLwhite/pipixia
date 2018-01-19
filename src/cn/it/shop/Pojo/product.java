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
@Table
public class product implements Serializable
{
	private Integer pid;
	private String pname;
	private Integer pprice;
	private String psimpimf;
	private String pzhenimf;
	private String pimg;
	private Integer pfouce;
	private String specifications;    // 产品价格的规格
	private String activity;      // 促销活动

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getPid()
	{
		return pid;
	}
	public void setPid(Integer pid)
	{
		this.pid = pid;
	}
	
	
	@Column(name="name",length=100,nullable=false)
	public String getPname()
	{
		return pname;
	}
	public void setPname(String pname)
	{
		this.pname = pname;
	}
	@Column(name="price",nullable=false)
	public Integer getPprice()
	{
		return pprice;
	}
	public void setPprice(Integer pprice)
	{
		this.pprice = pprice;
	}
	
	@Column(name="simple",nullable=false,length=20)
	public String getPsimpimf()
	{
		return psimpimf;
	}
	public void setPsimpimf(String psimpimf)
	{
		this.psimpimf = psimpimf;
	}
	@Column(name="detail",nullable=false,length=200)
	public String getPzhenimf()
	{
		return pzhenimf;
	}
	public void setPzhenimf(String pzhenimf)
	{
		this.pzhenimf = pzhenimf;
	}
	
	@Column(name="img")
	public String getPimg()
	{
		return pimg;
	}
	public void setPimg(String pimg)
	{
		this.pimg = pimg;
	}
	@Column(name="fouce")
	public Integer getPfouce()
	{
		return pfouce;
	}
	public void setPfouce(Integer pfouce)
	{
		this.pfouce = pfouce;
	}
	
	@Column(length=20,name="guige")
	public String getSpecifications()
	{
		return specifications;
	}
	public void setSpecifications(String specifications)
	{
		this.specifications = specifications;
	}
	
	@Column(length=20,name="active")
	public String getActivity()
	{
		return activity;
	}
	public void setActivity(String activity)
	{
		this.activity = activity;
	}
	
	
}
