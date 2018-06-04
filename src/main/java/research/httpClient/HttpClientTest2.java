package research.httpClient;

import java.io.File;

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

import net.sf.json.JSONObject;

public class HttpClientTest2 {

	//本机
	private static String domain = "192.168.88.5:8080";
	private static String only_ip = "192.168.88.5";
	
	//production
//	private static String domain = "119.29.61.223";
//	private static String only_ip = "119.29.61.223";
	
	public static void main(String[] args) throws Exception {
		
		String body = null;
		
		String sessionID = "63CD0897A874F52E423FEE5A2AC483B2";
		String userToken = "37ce9339aba33a6164fbd01ae90a4e8d";
		

		
//		body = login(sessionID,userToken);
		
//		body = logout(sessionID,userToken);

//		body = listAgentCountries(sessionID,userToken);
		
//		body = listCitiesByCountryID(sessionID,userToken);
				
		body = listCompaniesByCity(sessionID,userToken);
		
//		body = getCompanyById(sessionID,userToken);

		System.out.println(body);
	}

	public static String login(String sessionID, String userToken) throws Exception {
		
		JSONObject json = new JSONObject();
		
		String url = "http://"+ domain +"/rest-api/login/loginByRestful";
		
		json.put("requestFrom", "www.collyerlogistics.com");
		json.put("username", "l.luo@shz.collyerlogistics.com");  //l.luo@shz.collyerlogistics.com    gdatta@acsshipping.in
		json.put("pwd", "123456"); //Ovi-04
		
		// l.luo@shz.collyerlogistics.com  123456
		// b.hollmann@ovibell-int.de   Ovi-04
		
		return postWithJson(url, json,sessionID,userToken);
	}
	
	public static String logout(String sessionID, String userToken) throws Exception {
		
		JSONObject json = new JSONObject();
		
		String url = "http://"+ domain +"/rest-api/login/logoutByRestful";
		
		return postWithJson(url, json,sessionID,userToken);
	}
	

	public static String listAgentCountries(String sessionID, String userToken) throws Exception{
		
		JSONObject json = new JSONObject();
		String url = "http://"+ domain +"/rest-api/zone/listAgentCountries";

		json.put("requestFrom", "www.collyerlogistics.com");
				
		return postWithJson(url, json,sessionID,userToken);
	}
	
	public static String listCitiesByCountryID(String sessionID, String userToken) throws Exception{
		
		JSONObject json = new JSONObject();
		String url = "http://"+ domain +"/rest-api/zone/listCitiesByCountryID";

		json.put("requestFrom", "www.collyerlogistics.com");
		json.put("country_id", 20);//81 france  22 autralia
		
				
		return postWithJson(url, json,sessionID,userToken);
	}
	
	
	public static String listCompaniesByCity(String sessionID, String userToken) throws Exception{
		
		JSONObject json = new JSONObject();
		String url = "http://"+ domain +"/rest-api/zone/listCompaniesByCity";  //listCompaniesByCity  listContactsByCity

		json.put("requestFrom", "www.collyerlogistics.com");
		json.put("userId", 326);  //1023  821     21794
		json.put("city_id", 1043); //1006 MUNICH 942 BRISBANE  875 SYDNEY    994 DUBLIN    943 LYON   1147
		
		return postWithJson(url, json,sessionID,userToken);
	}
	
	
	public static String getCompanyById(String sessionID, String userToken) throws Exception{
		
		JSONObject json = new JSONObject();
		String url = "http://"+ domain +"/rest-api/zone/getCompanyById";  

		json.put("requestFrom", "www.collyerlogistics.com");
		json.put("companyId", 49); //1026    536   1212   49   22150
		json.put("city_id", 1079); //1026    536   1212    1079
		
		return postWithJson(url, json,sessionID,userToken);
	}
	
	
	
	public static String postWithJson(String url,JSONObject json, String sessionID, String userToken2) throws Exception{
		
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		
		//DF7E372C19BE14DB9B6420B47D1B1956

		BasicClientCookie sessionCookie = new BasicClientCookie("JSESSIONID", sessionID);
		sessionCookie.setVersion(0);
		sessionCookie.setDomain(only_ip);
		sessionCookie.setPath("/rest-api");
		
		BasicClientCookie userToken = new BasicClientCookie("userToken", userToken2);
		userToken.setVersion(0);
		userToken.setDomain(only_ip);
		userToken.setPath("/rest-api");
		
		
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
