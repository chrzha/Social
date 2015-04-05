package com.chrzha.social.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.chrzha.social.entity.PatentsInfo;

@Component
public class HtmlParserUtil {

	public List<String> getPatentsURL(String content) {
		List<String> resultList = new ArrayList<String>();
		//得到名字-Title
		Document doc = Jsoup.parse(content);
		Elements link = doc.select("a");
		Map<String, Object> urlMap = new LinkedHashMap<String, Object>();
		for (int i = 0; i < link.size(); i++) {
			String linkHref = link.get(i).attr("href");
			 
			 if (linkHref.startsWith("/netacgi/nph-Parser?")&&!linkHref.contains("Page=Next")) {
				 urlMap.put(linkHref,"URL");
			}
		}
		for (String key : urlMap.keySet()) {
			System.out.println("urlMap:"+key);
		    resultList.add(key);
		}
		return resultList;
	}

	public PatentsInfo getPatentInfo(String urlString ,String content) {
		PatentsInfo patentsInfo = new PatentsInfo();
		patentsInfo.setPatentUrl(urlString);
		Document doc = Jsoup.parse(content);
		//得到patent number
		Elements b = doc.select("b");
		if (b.size()>2) {
			String numString = b.get(1).text();
			patentsInfo.setPatentNumber(numString);
		}

		//得到名字-title
		Elements link = doc.select("FONT");
		for (int i = 0; i < link.size(); i++) {
			String sizeAttr = link.get(i).attr("size");
			if (sizeAttr.equals("+1")) {
				patentsInfo.setPatentName(link.get(i).text().toString());
			}
		}
		//得到摘要部分-abstract
		Elements p = doc.select("p");
		String abstractContent = p.get(0).text();
		patentsInfo.setAbstractContent(abstractContent);
		 
		//得到inventors
		Elements td = doc.select("table").get(3).select("td");
		 
		String  inventors = td.get(0).text();
		
		if (inventors.startsWith("**Please see images for:")) {
			Elements adjustTd = doc.select("table").get(4).select("td");
			inventors = td.get(0).text();
		}
		patentsInfo.setOwnerName(inventors);
		//得到Issue Date
		
		//得到Claim(s)
		//得到Description/Specification
		//得到Current US Classification
		//得到Current CPC Classification
		//得到Current CPC Classification Class
		//得到International Classification
		//得到Application Serial Number
		//得到Application Date
		//得到Application Type
		
		
		return patentsInfo;
	}

	public List<PatentsInfo> getPatentInfo(List<HashMap<String, String>> list) {
		List<PatentsInfo> resultList = new ArrayList<PatentsInfo>();
		PatentsInfo patentsInfo = new PatentsInfo();

		return resultList;
	}
}
