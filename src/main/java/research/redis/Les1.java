package research.redis;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class Les1 {

	private Jedis jedis = null;

	@Before
	public void init() {
		jedis = new Jedis("192.168.88.25", 6379);
		
		//jedis = new Jedis("192.168.88.25", 6379);
		
		//collyer.test.server
	}
	
	@Test
	public void testString() throws Exception {
		jedis.set("nihao", "mao ge");
		
		System.out.println(jedis.get("nihao"));
	}

	@Test
	public void testImg() throws Exception {
		MyBean my = new MyBean();
		my.setName("ckk");
		jedis.set("my".getBytes(), SerializeUtil.serialize(my));

		byte[] beanB = jedis.get("my".getBytes());
		my = (MyBean) SerializeUtil.unserialize(beanB);

		System.out.println(my.getName());
	}
	
	@Test
	public void putObj() throws Exception {
	      MyBean my = new MyBean();
	      my.setName("ckk");
	      jedis.set("myObj".getBytes(), SerializeUtil.serialize(my));
	      
	}
	
	@Test
	public void getObj() throws Exception {

	      byte[] b = jedis.get("myObj".getBytes());
	      
	      MyBean myBean = (MyBean) SerializeUtil.unserialize(b);
	      
	      System.out.println(myBean.getName());
	}

	@Test
	public void putImg() throws Exception {
		String path = "C:/nicot/myImg.jpg";
		File file = new File(path);
		
		byte[] b = FileUtils.readFileToByteArray(file);
		
		jedis.set("imgCkk".getBytes(), b);
		
//		jedis.expire("imgCkk".getBytes(), 1);
	}
	
	@Test
	public void getImg() throws Exception {
		String path = "C:/nicot/myImg123.jpg";
		File file = new File(path);
		
		byte[] b = jedis.get("imgCkk".getBytes());
		
		
		
		System.out.println(b);
		
		FileUtils.writeByteArrayToFile(file, b);
		
	}

	@After
	public void destroy() {
		jedis.close();
	}

}
