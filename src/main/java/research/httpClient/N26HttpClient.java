package research.httpClient;

import java.math.BigDecimal;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;




public class N26HttpClient {

	private static String domain = "localhost:8080";

	
	public static void main(String[] args) throws Exception {
		
		concurentTest();
	}

	//326.01599999999996
	
	public static void concurentTest() throws Exception{
		
		
		for(int i=0; i<23; i++){ //POST 17 transactions from http client
			
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					try {
						JSONObject json = new JSONObject();
						String url = "http://"+ domain +"/transactions";

						json.put("amount", mul(Math.random(),1000));
						json.put("timestamp", 0L);
						
						String body = postWithJson(url, json);
						
						System.out.println(body);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			t.start();
		}

	}
	
	
	
	public static String postWithJson(String url,JSONObject json) throws Exception{
		
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		
		httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");

		StringEntity se = new StringEntity(json.toString());

		se.setContentType("text/json");
		se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));

		httpPost.setEntity(se);
		
		HttpResponse response = httpClient.execute(httpPost);

		// =============================================================================
		
		Header[] headers = response.getAllHeaders();
		
		System.out.println(response.getStatusLine().getStatusCode());
		
		for (Header header : headers) {
			System.out.println(header);
		}

		// =============================================================================

		HttpEntity entity = response.getEntity();

		String body = null;
		if(entity != null){
			body = EntityUtils.toString(entity);
		}
		
		httpClient.getConnectionManager().shutdown();

		return body;
	}
	
	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

}
