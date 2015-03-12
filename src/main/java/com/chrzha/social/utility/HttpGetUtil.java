package com.chrzha.social.utility;

import org.apache.http.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
@Component
public class HttpGetUtil {

	public static String getHtmlContent(String endpoint,String para) throws Exception {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String result="";
		try {
			// specify the host, protocol, and port
			HttpHost target = new HttpHost(endpoint, 80,
					"http");
			// specify the get request
			HttpGet getRequest = new HttpGet(para);
			//System.out.println("executing request to " + target);
			HttpResponse httpResponse = httpclient.execute(target, getRequest);
			HttpEntity entity = httpResponse.getEntity();
			//System.out.println("----------------------------------------");
			//System.out.println(httpResponse.getStatusLine());
			Header[] headers = httpResponse.getAllHeaders();
			for (int i = 0; i < headers.length; i++) {
				//System.out.println(headers[i]);
			}
			if (entity != null) {
				result = EntityUtils.toString(entity) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// When HttpClient instance is no longer needed,
			// shut down the connection manager to ensure
			// immediate deallocation of all system resources
			httpclient.getConnectionManager().shutdown();
		}
		return result;
	}
}