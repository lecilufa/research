package research.httpClient;

import net.sf.json.JSONObject;

public class TestMain {

	public static void main(String[] args) throws Exception {
		
		JSONObject json = new JSONObject();
		String url = "http://localhost/rest-api/billing/listExchangeRate";  

		json.put("issued_date", "2018-01-01"); 
		json.put("branch_id", 8); 
		
		
		String res = HttpClientTest2.postWithJson(url, json, "", "");
		
		System.out.println(res);
	}
	
	

}
