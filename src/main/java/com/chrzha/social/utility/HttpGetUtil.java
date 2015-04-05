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
			HttpHost target = new HttpHost(endpoint, 80,"http");
			HttpGet getRequest = new HttpGet(para);
			HttpResponse httpResponse = httpclient.execute(target, getRequest);
			HttpEntity entity = httpResponse.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return result;
	}
}