package research.websocket;

import java.net.URI;

public class Test {

	public static void main(String[] args) throws Exception {
		
		URI uri = new URI("ws://localhost:8080/CUSTOMER/websocket");
		
		// open websocket
		WebsocketClient clientEndPoint = new WebsocketClient(uri);

		// send message to websocket
		clientEndPoint.sendMessage("{'event':'addChannel','channel':'ok_btccny_ticker'}");
		
		// wait 5 seconds for messages from websocket   这一步是必须的  服务器回消息也是需要时间的 所以要等
		Thread.sleep(5000);
	}
}
