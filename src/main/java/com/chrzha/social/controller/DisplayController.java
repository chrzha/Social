package com.chrzha.social.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chrzha.social.entity.PatentsInfo;
import com.chrzha.social.entity.User;
import com.chrzha.social.service.DataCatchService;

@Controller
@RequestMapping(value = "/")
public class DisplayController {

	@Autowired
	private DataCatchService dataCatchService;

	@RequestMapping(value = "/version", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getVersions(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		List<String> list = dataCatchService.getVersions(user.getUserId());
		list.add(0, "所有记录");
		return list;
	}

	@RequestMapping(value = "/allData", method = RequestMethod.GET)
	@ResponseBody
	public String getAllData(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize,HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		List<PatentsInfo> patentsInfoList = dataCatchService.getPatents(user.getUserId(),pageNum,pageSize);

		int totalCount = dataCatchService.getTotalCount(user.getUserId());
		int pageCount = totalCount/pageSize;
		if (totalCount%pageSize!=0) {
			pageCount = pageCount + 1;
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("patentsInfoList", patentsInfoList);
		data.put("pageCount", pageCount);
		
		return JSONArray.fromObject(data).toString();
	}
	
	@RequestMapping(value = "/deleteDataByVersion", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteDataByVersion(@RequestParam("version") String version) {

		dataCatchService.deletePatentsByVersion(version);
		return "success";
	}
	
	
	@RequestMapping(value = "/deleteAllData", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteAllData(HttpServletRequest  request) {
		User user = (User) request.getSession().getAttribute("user");
		dataCatchService.deleteAllPatents(user.getUserId());
		return "success";
	}
	
	@RequestMapping(value = "/getDataByVersion", method = RequestMethod.GET)
	@ResponseBody
	public String getDataByVersion(@RequestParam("version") String version,@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize) {
		List<PatentsInfo> patentsInfoList = dataCatchService.getPatentsByVersion(version,pageNum,pageSize);
		int totalCount = dataCatchService.getTotalCountByVersion(version);
		int pageCount = totalCount/pageSize;
		if (totalCount%pageSize!=0) {
			pageCount = pageCount + 1;
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("patentsInfoList", patentsInfoList);
		data.put("pageCount", pageCount);
		return JSONArray.fromObject(data).toString();
	}

}
