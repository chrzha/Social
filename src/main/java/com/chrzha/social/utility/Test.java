package com.chrzha.social.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.htmlparser.Parser;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.TextExtractingVisitor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Test {

	public static void main(String[] args) throws ParserException {
		// TODO Auto-generated method stub
	/*	Pattern pattern = Pattern.compile("<FONT size=.*>.*</FONT>");
		String temp = "<FONT size=\"ds+1\">cec</FONT>";
		Matcher matcher = pattern.matcher(temp);
		boolean b = matcher.matches();

		System.out.println(matcher.group(0));*/
		String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
		Document doc = Jsoup.parse(html);
		Element link = doc.select("a").first();

		String text = doc.body().text(); // "An example link"
		String linkHref = link.attr("href"); // "http://example.com/"
		String linkText = link.text(); // "example""

		String linkOuterH = link.outerHtml(); 
		    // "<a href="http://example.com"><b>example</b></a>"
		String linkInnerH = link.html(); // "<b>example</b>"

	}

}
