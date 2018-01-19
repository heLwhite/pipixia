package cn.it.shop.webconfig;


import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;


public class wsconfigurator extends ServerEndpointConfig.Configurator
{

	@Override
	public void modifyHandshake(ServerEndpointConfig sec,
			HandshakeRequest request, HandshakeResponse response)
	{
		HttpSession httpSession = (HttpSession) request.getHttpSession();
		if (httpSession != null) {
			sec.getUserProperties().put(HttpSession.class.getName(), httpSession);
		}
	}
	


}
