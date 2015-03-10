package com.chrzha.social.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.nodes.TagNode;
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

	public List<HashMap<String, String>> getPatentsURL(String content) throws ParserException{
		List<HashMap<String, String>> resultList = new ArrayList<HashMap<String,String>>();
		Parser parser = new Parser(content);
		NodeFilter filter = new TagNameFilter("a");   
        NodeList list = parser.extractAllNodesThatMatch(filter);   
        System.out.println("IMG tags number :" + list.size());   
        SimpleNodeIterator iterator = list.elements();   
        while(iterator.hasMoreNodes()) {   
            //这个地方需要记住   
            Node node = iterator.nextNode();   
            TagNode tagNode = new TagNode();   
            //一旦得到了TagNode ， 就可以得到其中的属性值   
            tagNode.setText(node.toHtml());   
            System.out.println(tagNode.getAttribute("href"));   
        }   
		
		return resultList;
	}
	public List<PatentsInfo> getPatentInfo(List<HashMap<String, String>> list){
		List<PatentsInfo> resultList = new ArrayList<PatentsInfo>();
		PatentsInfo patentsInfo = new PatentsInfo();
		
		return resultList;
	}
}
