package research.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Publish {
	
	private Jedis jedis = null;

	@Before
	public void init() {
		jedis = new Jedis("192.168.0.25", 6379);
	}
	
	
	@Test   
    public void subcribe() {  
          
		jedis.publish("ckk", "123");
		
    } 
	
	
	@After
	public void destroy() {
		jedis.close();
	}

}
