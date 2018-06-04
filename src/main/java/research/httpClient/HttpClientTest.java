package research.httpClient;

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

import com.collyer.common.encryption.MD5Util;

import net.sf.json.JSONObject;

public class HttpClientTest {


	//192.168.0.7
	//192.168.0.7:8080
	
	private static String ip = "192.168.0.9:8080";
	private static String only_ip = "192.168.0.9";
	
	//production
//	private static String ip = "119.29.61.223";
//	private static String only_ip = "119.29.61.223";
	
	public static void main(String[] args) throws Exception {
		
		String body = "";
		
		String sessionID = "308CB5C5746251F04D45A0AEFE9EF570";
		String userToken = "de4634e099927698b0351525ccc9b16b";
		
		
//		body = login(sessionID,userToken);

//		body = listAgentCountries(sessionID,userToken);
		
//		body = listCitiesByCountryID(sessionID,userToken);
				
		body = listContactsByCity(sessionID,userToken);

		System.out.println(body);
	}

	public static String login(String sessionID, String userToken) throws Exception {
		
		JSONObject json = new JSONObject();
		
		String url = "http://"+ ip +"/CUSTOMER/loginByRestful.action";
		
		json.put("requestFrom", "www.collyerlogistics.com");
		json.put("username", "l.luo@shz.collyerlogistics.com");
		json.put("pwd", "123456"); //Ovi-04  
		
		// l.luo@shz.collyerlogistics.com  123456
		// b.hollmann@ovibell-int.de   Ovi-04
		
		return postWithJson(url, json,sessionID,userToken);
	}
	

	public static String listAgentCountries(String sessionID, String userToken) throws Exception{
		
		JSONObject json = new JSONObject();
		String url = "http://"+ ip +"/CUSTOMER/listAgentCountries.action";

		json.put("requestFrom", "www.collyerlogistics.com");
				
		return postWithJson(url, json,sessionID,userToken);
	}
	
	public static String listCitiesByCountryID(String sessionID, String userToken) throws Exception{
		
		JSONObject json = new JSONObject();
		String url = "http://"+ ip +"/CUSTOMER/listCitiesByCountryID.action";

		json.put("requestFrom", "www.collyerlogistics.com");
		json.put("country_id", 22);//81 france  22 autralia
		
				
		return postWithJson(url, json,sessionID,userToken);
	}
	
	
	public static String listContactsByCity(String sessionID, String userToken) throws Exception{
		
		JSONObject json = new JSONObject();
		String url = "http://"+ ip +"/CUSTOMER/listContactsByCity.action";

		json.put("requestFrom", "www.collyerlogistics.com");
		json.put("userId", 1023);  //1023  821 
		json.put("city_id", 1006); //1006 875 942 BRISBANE  875 SYDNEY    994 DUBLIN
		
				
		return postWithJson(url, json,sessionID,userToken);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String postWithJson(String url,JSONObject json, String sessionID, String userToken2) throws Exception{
		
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		
		//DF7E372C19BE14DB9B6420B47D1B1956

		BasicClientCookie sessionCookie = new BasicClientCookie("JSESSIONID", sessionID);
		sessionCookie.setVersion(0);
		sessionCookie.setDomain(only_ip);
		sessionCookie.setPath("/CUSTOMER");
		
		BasicClientCookie userToken = new BasicClientCookie("userToken", userToken2);
		userToken.setVersion(0);
		userToken.setDomain(only_ip);
		userToken.setPath("/CUSTOMER");
		
		
		//43765843e4e1ba93fff92482ef41335c

		httpClient.getCookieStore().addCookie(sessionCookie);
		httpClient.getCookieStore().addCookie(userToken);

		httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
		httpPost.addHeader("Collyer-Request-ID", "00001");
		httpPost.addHeader("Collyer-Request-Query", "listAgentCountries");

		StringEntity se = new StringEntity(json.toString());

		se.setContentType("text/json");
		se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));

		httpPost.setEntity(se);

		HttpResponse response = httpClient.execute(httpPost);

		// =============================================================================
		
		Header[] headers = response.getAllHeaders();

		for (Header header : headers) {
			System.out.println(header);
		}

		// =============================================================================

		HttpEntity entity = response.getEntity();

		String body = EntityUtils.toString(entity);

		httpClient.getConnectionManager().shutdown();

		return body;
	}

}
