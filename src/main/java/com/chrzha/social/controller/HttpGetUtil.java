package com.chrzha.social.controller;

import org.apache.http.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpGetUtil {

	public static String getByString(String url,String para) throws Exception {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			// specify the host, protocol, and port
			HttpHost target = new HttpHost("premiumreports.myacxiom.loc", 8080,
					"http");
			// specify the get request
			HttpGet getRequest = new HttpGet("/v1/reports");
			System.out.println("executing request to " + target);
			HttpResponse httpResponse = httpclient.execute(target, getRequest);
			HttpEntity entity = httpResponse.getEntity();
			System.out.println("----------------------------------------");
			System.out.println(httpResponse.getStatusLine());
			Header[] headers = httpResponse.getAllHeaders();
			for (int i = 0; i < headers.length; i++) {
				System.out.println(headers[i]);
			}
			if (entity != null) {
				System.out.println(EntityUtils.toString(entity));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// When HttpClient instance is no longer needed,
			// shut down the connection manager to ensure
			// immediate deallocation of all system resources
			httpclient.getConnectionManager().shutdown();
		}
		return url;
	}
}