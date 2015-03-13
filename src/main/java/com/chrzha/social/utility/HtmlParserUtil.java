package com.chrzha.social.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.tags.BaseHrefTag;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.SimpleNodeIterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.chrzha.social.entity.PatentsInfo;

@Component
public class HtmlParserUtil {

	public List<HashMap<String, String>> getPatentsURL(String content)
			throws ParserException {
		List<HashMap<String, String>> resultList = new ArrayList<HashMap<String, String>>();
		List<PatentsInfo> patentsList = new ArrayList<PatentsInfo>();
		Parser parser = new Parser(content);
		Pattern pattern = Pattern.compile("(^[A-Z]{1,2})(\\d++).*");
		NodeFilter filter = new TagNameFilter("a");
		NodeList list = parser.extractAllNodesThatMatch(filter);
		SimpleNodeIterator iterator = list.elements();
		PatentsInfo patentsInfo = null;
		while (iterator.hasMoreNodes()) {

			Node node = iterator.nextNode();
			TextNode textNode = new TextNode("a");
			TagNode tagNode = new TagNode();
			textNode.setText(node.toPlainTextString());
			Matcher matcher = pattern.matcher(tagNode.getText());
			boolean b = matcher.matches();

			if (b && textNode.getText().trim().length() > 0) {
				patentsInfo = new PatentsInfo();
				patentsInfo.setPatentNumber(textNode.getText());
			} else if ((!b && textNode.getText().length() > 0)) {
				String tempString = textNode.getText().replace("\n", "");
				if (tempString.length() > 0) {
					patentsInfo.setPatentName(tempString);

				}
			}
			if (patentsInfo != null && patentsInfo.getPatentNumber() != null
					&& patentsInfo.getPatentName() != null) {
				patentsList.add(patentsInfo);
				patentsInfo = new PatentsInfo();
			}
		}
		return resultList;
	}

	public PatentsInfo getPatentInfo(String content) throws ParserException {
		PatentsInfo patentsInfo = new PatentsInfo();

		//得到名字
		Document doc = Jsoup.parse(content);
		Elements link = doc.select("FONT");
		for (int i = 0; i < link.size(); i++) {
			String sizeAttr = link.get(i).attr("size");
			if (sizeAttr.equals("+1")) {
				patentsInfo.setPatentName(link.get(i).text().toString());
			}
		}
		//得到摘要部分
		Elements p = doc.select("p");
		String abstractContent = p.get(0).text();
		patentsInfo.setAbstractContent(abstractContent);
		 
		//得到ID99
		Elements b = doc.select("b");
		if (b.size()>2) {
			String numString = b.get(1).text();
				patentsInfo.setPatentNumber(numString);
		}
		//得到inventor
		for (int i = 0; i <b.size(); i++) {
			 
			if (b.get(i).outerHtml().toString().contains("<br>")) {
				String inventors = b.get(i).text().toString();
				patentsInfo.setOwnerName(inventors);
			}
		}
		//得到field
		
		return patentsInfo;
	}

	public List<PatentsInfo> getPatentInfo(List<HashMap<String, String>> list) {
		List<PatentsInfo> resultList = new ArrayList<PatentsInfo>();
		PatentsInfo patentsInfo = new PatentsInfo();

		return resultList;
	}
}
