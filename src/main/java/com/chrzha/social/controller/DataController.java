package com.chrzha.social.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chrzha.social.entity.PatentsInfo;
import com.chrzha.social.service.DataCatchService;


@Controller
@RequestMapping(value="/catch")
public class DataController {

	@Autowired
	private DataCatchService dataCatchService;
	
	@Autowired
	private  HttpGetUtil httpGetUtil ;
	
	 @RequestMapping(value = "/url", method = RequestMethod.GET)
	    public @ResponseBody
	    String  LoadData(@RequestParam(required = false, value = "url") String url,
	    		@RequestParam(required = false, value = "term1") String term1,
	    		@RequestParam(required = false, value = "field1") String field1,
	    		@RequestParam(required = false, value = "operator") String operator,
	    		@RequestParam(required = false, value = "term2") String term2,
	    		@RequestParam(required = false, value = "field2") String field2) throws Exception {
		 String endpoint = "patft.uspto.gov";
		 String urlString = "/netacgi/nph-Parser?"
		 		+ "Sect1=PTO2&Sect2=HITOFF&p=1&u=%2Fnetahtml%2FPTO%2Fsearch-bool.html&r=0&f=S&l=50&TERM1="+term1+"&FIELD1="+field1+"&co1="+operator+"&TERM2="+term2+"&FIELD2="+field2+"&d=PTXT";
		    String result = httpGetUtil.getByString(endpoint, urlString);
		    System.out.println(result);
	        List<PatentsInfo> patentsInfoList =  dataCatchService.getPatents();
	        
	        return JSONArray.fromObject(patentsInfoList).toString();
	    }
}
