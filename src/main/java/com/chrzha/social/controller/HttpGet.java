package com.chrzha.social.controller;

import java.awt.image.RescaleOp;
import java.io.IOException;
import java.sql.Connection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/*
 * WPsiteCrawler
 * a web crawler for single WordPress site
 * Author:	John Hany
 * Site:	http://johnhany.net/
 * Source code updates:	https://github.com/johnhany/WPCrawler
 * 
 * Using:	Apache HttpComponents 4.3 -- http://hc.apache.org/
 * 			HTML Parser 2.0 -- http://htmlparser.sourceforge.net/
 * 			MySQL Connector/J 5.1.27 -- http://dev.mysql.com/downloads/connector/j/
 * Thanks for their work!
 */

/*
 * @getByString
 * get page content from an url link
 */
public class HttpGet {

    public  static String getByString(String url) throws Exception {
    	DefaultHttpClient httpclient = new DefaultHttpClient();
    	try {
    	// specify the host, protocol, and port
    	HttpHost target = new HttpHost("premiumreports.myacxiom.loc", 8080, "http");
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
    	System.out.println("----------------------------------------");
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
    }
}