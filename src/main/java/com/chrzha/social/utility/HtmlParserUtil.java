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

		Parser parser = new Parser(content);

		//得到摘要部分
		NodeFilter filter = new TagNameFilter("p");
		NodeList list = parser.extractAllNodesThatMatch(filter);
		PatentsInfo patentsInfo = new PatentsInfo();
		Node node = list.elementAt(0);
		TextNode textNode = new TextNode("p");
		textNode.setText(node.toPlainTextString());
		if (textNode.getText().trim().length() > 0) {
			patentsInfo = new PatentsInfo();
			patentsInfo.setAbstractContent(textNode.getText());
		}
		
		//得到ID
		Parser parserID = new Parser(content);
		NodeFilter IDfilter = new TagNameFilter("b");
		NodeList IDList = parserID.extractAllNodesThatMatch(IDfilter);
		Node IDNode = IDList.elementAt(0);
		TextNode textIDNode = new TextNode("b");
		textIDNode.setText(IDNode.toPlainTextString());
		if (textIDNode.getText().trim().length() > 0) {
			patentsInfo.setPatentNumber(textIDNode.getText());
		}
		return patentsInfo;
	}

	public List<PatentsInfo> getPatentInfo(List<HashMap<String, String>> list) {
		List<PatentsInfo> resultList = new ArrayList<PatentsInfo>();
		PatentsInfo patentsInfo = new PatentsInfo();

		return resultList;
	}
}
