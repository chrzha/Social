package com.chrzha.social.controller;

import java.util.List;

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
@RequestMapping(value = "/")
public class DisplayController {

	@Autowired
	private DataCatchService dataCatchService;

	@RequestMapping(value = "/version", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getVersions() {
		List<String> list = dataCatchService.getVersions();
		list.add(0, "所有记录");
		return list;
	}

	@RequestMapping(value = "/allData", method = RequestMethod.GET)
	@ResponseBody
	public String getAllData() {
		List<PatentsInfo> patentsInfoList = dataCatchService.getPatents();

		return JSONArray.fromObject(patentsInfoList).toString();
	}
	
	@RequestMapping(value = "/deleteDataByVersion", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteDataByVersion(@RequestParam("version") String version) {

		dataCatchService.deletePatentsByVersion(version);
		return "success";
	}
	
	
	@RequestMapping(value = "/deleteAllData", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteAllData() {
		dataCatchService.deleteAllPatents();
		return "success";
	}
	
	@RequestMapping(value = "/getDataByVersion", method = RequestMethod.GET)
	@ResponseBody
	public String getDataByVersion(@RequestParam("version") String version) {
		List<PatentsInfo> patentsInfoList = dataCatchService.getPatentsByVersion(version);
		return JSONArray.fromObject(patentsInfoList).toString();
	}

}
