package com.bizoe.web.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author wangxinxin
 */
@ServerEndpoint("/my-websocket")
@Component
public class MyWebSocket {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	private static int onlineCount = 0;
	private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<>();

	private Session session;

	@Override
	public int hashCode(){
		return session != null ? session.hashCode() : 0;
	}

	@Override
	public boolean equals(Object obj){
		//判断传入的是否为同一个对象
		if (this == obj) {
			return true;
		}
		//判断传入的对象是否为空，是不是相同的类
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		//强转
		MyWebSocket socket = (MyWebSocket) obj;

		//判断session是否相同
		if(session != null){
			return session.equals(socket.session);
		}
		return false;
	}

	@OnOpen
	public void onOpen(Session session) throws IOException{
		this.session = session;
		webSocketSet.add(this);
		incrOnlineCount();
		for(MyWebSocket item : webSocketSet){
			//send to others only.
			if(!item.equals(this)) {
				item.sendMessage("someone just joined in.");
			}
		}
		logger.info("new connection...current online count: {}", getOnlineCount());
	}

	@OnClose
	public void onClose() throws IOException{
		webSocketSet.remove(this);
		decOnlineCount();
		for(MyWebSocket item : webSocketSet){
			item.sendMessage("someone just closed a connection.");
		}
		logger.info("one connection closed...current online count: {}", getOnlineCount());
	}

	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		logger.info("message received: {}", message);
		// broadcast received message
		for(MyWebSocket item : webSocketSet){
			item.sendMessage(message);
		}
	}

	public void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
	}

	public static synchronized int getOnlineCount(){
		return MyWebSocket.onlineCount;
	}

	public static synchronized void incrOnlineCount(){
		MyWebSocket.onlineCount++;
	}

	public static synchronized void decOnlineCount(){
		MyWebSocket.onlineCount--;
	}
}
