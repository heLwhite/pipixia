package cn.it.shop.Pojo;

public class sendto
{
	private String sender;      //发送消息者
	private String recipient;   //接受消息的人
	private String Date;        //时间接受
	private String talk;         //交流话
	public String getSender()
	{
		return sender;
	}
	public void setSender(String sender)
	{
		this.sender = sender;
	}
	public String getRecipient()
	{
		return recipient;
	}
	public void setRecipient(String recipient)
	{
		this.recipient = recipient;
	}
	public String getDate()
	{
		return Date;
	}
	public void setDate(String date)
	{
		Date = date;
	}
	public String getTalk()
	{
		return talk;
	}
	public void setTalk(String talk)
	{
		this.talk = talk;
	}
	

}
