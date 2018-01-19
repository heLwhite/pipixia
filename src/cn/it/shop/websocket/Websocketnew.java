package cn.it.shop.websocket;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.json.Json;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.aspectj.weaver.ast.Var;

import com.google.gson.Gson;

import cn.it.shop.Pojo.Message;
import cn.it.shop.Pojo.sendto;
import cn.it.shop.webconfig.wsconfigurator;



@ServerEndpoint(value="/shopweb",configurator=wsconfigurator.class)
public class Websocketnew
{
	private Session session;
	private String webstyle;
	private static ConcurrentMap<String, Websocketnew> adminmap = new ConcurrentHashMap<>(); 
	private static ConcurrentMap<String, Websocketnew> trip = new ConcurrentHashMap<>();
	private static List<Message> list=new ArrayList<>();
	private Message message=new Message();
	private sendto sendto=new sendto();
	private Gson gson=new Gson();
	@OnOpen
	public void open(Session session,EndpointConfig config)
	{
		System.out.println(session.getId());
		this.session=session;
		HttpSession httpSession= (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		String name=(String)httpSession.getAttribute("loginname");
		if(name!=null)
		{
			String fenString[]=name.split(":");
			this.getmap(fenString[0]).put(session.getId(), this);
			this.setWebstyle(fenString[0]);
			if(!"A".equals(fenString[0]))
			{
				//String sdate=(new SimpleDateFormat("yyyy年MM月dd日HH时")).format(new Date());
				Message message=new Message();
				message.setAdmin(selectmap());
				message.setCustype(fenString[0]);
				message.setAllcustomer(session.getId());
				list.add(message);
			}
		}else
		{

			this.getmap("N").put(session.getId(), this);
			this.setWebstyle("N");
			//String sdate=(new SimpleDateFormat("yyyy年MM月dd日HH时")).format(new Date());		
			message.setAdmin(selectmap());
			message.setCustype("N");
			message.setAllcustomer(session.getId());
			list.add(message);
		}
	}
	@OnMessage
	public void message(Session session,String msg) throws IOException
	{
		
	
		if(!"A".equals(getWebstyle()))
		{
			String sdate=(new SimpleDateFormat("MM月dd日HH时")).format(new Date());
			sendto.setDate(sdate);
			sendto.setRecipient(message.getAdmin());
			sendto.setSender(session.getId());
			sendto.setTalk(msg);
			String jsonString=gson.toJson(sendto);
			adminmap.get(findto(this.session.getId())).session.getAsyncRemote().sendText(jsonString);
		}else
		{
		    sendto sendto=gson.fromJson(msg, sendto.class);
		    sendto.setSender(session.getId());
		    String usertype=sendto.getRecipient();
			getmap(adfindto(usertype)).get(usertype).session.getAsyncRemote().sendText(msg);
			
			this.session.getAsyncRemote().sendText(msg);
		}
	}
	@OnClose
	public void close() 
	{
		System.out.println(getWebstyle()+"类型正在关闭");
		if(getWebstyle()!="A")
		{

			adminmap.get(findto(this.session.getId())).session.getAsyncRemote().sendText(session.getId());
			for (Iterator<Message> iterator=list.iterator(); iterator
					.hasNext();)
			{
				Message message = (Message) iterator.next();
				if(this.session.getId()==message.getAllcustomer())
				{
					iterator.remove();
					break;
				}
				
			}
			
		}
		try
		{
			this.session.close();
		} catch(IOException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		getmap(getWebstyle()).remove(this);
	}
	@OnError
	public void OnError(Throwable t) throws Throwable {
		t.printStackTrace();
	}
	//分类型的返回map
	public Map<String, Websocketnew> getmap(String arg0)
	{
		switch (arg0)
		{
			case "A":return adminmap;
			case "N":return trip;
		default:
			break;
		}
		return null;
	}
	
	//随机选出一个服务的人员
	public String selectmap()
	{
		String[] aa=adminmap.keySet().toArray(new String[0]);
		Random random=new Random();
		String select=aa[random.nextInt(aa.length)];	
		
		return select;
	}
	//寻找发送对象
	public String findto(String arg)
	{
		for (Message message : list)
		{
			if(arg.equals(message.getAllcustomer()))
			{
				return message.getAdmin();
			}
		}
		return null;
	}
	
	//admin寻求发送类型
	public String adfindto(String arg0)
	{
		for (Message message : list)
		{
			if(arg0.equals(message.getAllcustomer()))
			{
				
				return message.getCustype();
			}
		}
		return null;
	}
	//获取当前web的类型
	public String getWebstyle()
	{
		return webstyle;
	}
	public void setWebstyle(String webstyle)
	{
		this.webstyle = webstyle;
	}
	
	
	
}
