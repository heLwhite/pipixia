package cn.it.shop.Pojo;


/*
 * 服务连接对象
 */
public class Message
{
	private String admin;        //服务
	private String allcustomer;  //服务对象
	private String custype;      //服务用户类型
	public String getAdmin()
	{
		return admin;
	}
	public void setAdmin(String admin)
	{
		this.admin = admin;
	}
	
	public String getCustype()
	{
		return custype;
	}
	public void setCustype(String custype)
	{
		this.custype = custype;
	}
	public String getAllcustomer()
	{
		return allcustomer;
	}
	public void setAllcustomer(String allcustomer)
	{
		this.allcustomer = allcustomer;
	}

	
}
