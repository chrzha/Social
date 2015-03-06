package com.chrzha.social.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chrzha.social.entity.PatentsInfo;


@Controller
@RequestMapping(value="/catch")
public class DataController {

	 @RequestMapping(value = "/url", method = RequestMethod.GET)
	    public @ResponseBody
	    String  LoadData(@RequestParam(required = true, value = "url") String url) {
	        List<PatentsInfo> patentsInfoList = new ArrayList<PatentsInfo>();
	        for (int i = 0; i < 10; i++) {
				patentsInfoList.add(new PatentsInfo(i+1, "A","B", "CHN"));
			}
	        return JSONArray.fromObject(patentsInfoList).toString();
	    }
}
