package com.chrzha.social.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chrzha.social.entity.PatentsInfo;

@Component
public class HtmlParserUtil {

	@Autowired
	private HttpGetUtil httpGetUtil;

	public Map<String, Object> getPatentsURL(String content,
			Map<String, Object> urlMap) throws Exception {
		String endpoint = "patft.uspto.gov";
		// get URL
		Document doc = Jsoup.parse(content);
		Elements link = doc.select("a");
		for (int i = 10; i < link.size(); i++) {
			String linkHref = link.get(i).attr("href");
			if (linkHref.startsWith("/netacgi/nph-Parser?")
					&& !linkHref.contains("Page=Next")&&!linkHref.contains("Page=Prev")) {
				System.out.println(i+"=>"+linkHref);
				urlMap.put(linkHref, "URL");
			} else if (linkHref.startsWith("/netacgi/nph-Parser?")
					&& linkHref.contains("Page=Next")) {
				System.out.println(linkHref);
				String nextHtml = httpGetUtil
						.getHtmlContent(endpoint, linkHref);
				getPatentsURL(nextHtml, urlMap);
			}
		}
		
		return urlMap;
	}

	public List<String> mapToList(Map<String, Object> urlMap) {
		List<String> list = new ArrayList<String>();
		for (String key : urlMap.keySet()) {
			list.add(key);
		}
		return list;

	}

	public PatentsInfo getPatentInfo(String urlString, String content) {
		PatentsInfo patentsInfo = new PatentsInfo();
		patentsInfo.setPatentUrl(urlString);
		Document doc = Jsoup.parse(content);
		// 得到patent number
		Elements b = doc.select("b");
		if (b.size() > 2) {
			String numString = b.get(1).text();
			patentsInfo.setPatentNumber(numString);
		}

		// 得到名字-title
		Elements link = doc.select("FONT");
		for (int i = 0; i < link.size(); i++) {
			String sizeAttr = link.get(i).attr("size");
			if (sizeAttr.equals("+1")) {
				patentsInfo.setPatentName(link.get(i).text().toString());
			}
		}
		// 得到摘要部分-abstract
		Elements p = doc.select("p");
		String abstractContent = p.get(0).text();
		patentsInfo.setAbstractContent(abstractContent);

		// 得到inventors
		Elements td = doc.select("table").get(3).select("td");

		String inventors = td.get(0).text();

		if (inventors.startsWith("**Please see images for:")) {
			Elements adjustTd = doc.select("table").get(4).select("td");
			inventors = adjustTd.get(0).text();
		}
		patentsInfo.setOwnerName(inventors);
		// 得到Issue Date

		// 得到Claim(s)
		// 得到Description/Specification
		// 得到Current US Classification
		// 得到Current CPC Classification
		// 得到Current CPC Classification Class
		// 得到International Classification
		// 得到Application Serial Number
		// 得到Application Date
		// 得到Application Type

		return patentsInfo;
	}

	public List<PatentsInfo> getPatentInfo(List<HashMap<String, String>> list) {
		List<PatentsInfo> resultList = new ArrayList<PatentsInfo>();
		PatentsInfo patentsInfo = new PatentsInfo();

		return resultList;
	}
}
