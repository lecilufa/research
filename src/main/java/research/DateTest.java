package research;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;
import org.junit.Test;

public class DateTest {

	@Test
	public void testCase1() throws Exception {

		DateTime now = new DateTime("2016-09-27T03:45:31");
		
		System.out.println(now.toString("HH:mm:ss"));
		
		System.out.println(now.toString("yyyy-MM-dd&hh:mm:ss").replace('&', 'T'));
		
		
		
		DateTime future = now.plusMinutes(30);
		
		System.out.println(future.toString("HH:mm:ss"));
		
		
		System.out.println(now.isBefore(future));
	}
	
}
