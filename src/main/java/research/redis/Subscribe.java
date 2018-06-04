package research.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Subscribe {
	
	private Jedis jedis = null;

	@Before
	public void init() {
		jedis = new Jedis("192.168.0.25", 6379);
	}
	
	
	@Test   
    public void subcribe() {  
          
        JedisPubSub jedisPubSub = new JedisPubSub(){

			@Override
			public void onMessage(String channel, String message) {
				System.out.println(message);
			}
        	
			
			@Override
			public void onSubscribe(String channel, int subscribedChannels) {
				System.out.println("订阅");
			}
			
        };  
        
        //监听管道  
        jedis.subscribe(jedisPubSub  , "ckk");  
        

        
        
        
    } 
	
	
	@After
	public void destroy() {
		jedis.close();
	}

}
