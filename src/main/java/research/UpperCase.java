package research;

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
import org.junit.Test;

public class UpperCase {

	//@Test
	public void testCase1() throws Exception {

		String filePath = this.getClass().getResource("/aa.sql").getPath();

		File file = new File(filePath);

		String s = FileUtils.readFileToString(file);

		System.out.println(s.toUpperCase());
		
		
	}
	
}
