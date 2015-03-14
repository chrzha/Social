package com.chrzha.social.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Pattern pattern = Pattern.compile("<FONT size=.*>.*</FONT>"); String
		 * temp = "<FONT size=\"ds+1\">cec</FONT>"; Matcher matcher =
		 * pattern.matcher(temp); boolean b = matcher.matches();
		 * 
		 * System.out.println(matcher.group(0));
		 */
		String html = "<table><tr><td><a href='http://example.com/'>ddd</a></td></tr></table>";
		Document doc = Jsoup.parse(html);
		Element link = doc.select("a").first();

		String text = doc.body().text(); // "An example link"
		String linkHref = link.attr("href"); // "http://example.com/"
		String linkText = link.text(); // "example""

		String linkOuterH = link.outerHtml();
		// "<a href="http://example.com"><b>example</b></a>"
		String linkInnerH = link.html(); // "<b>example</b>"

		String temp = "/netacgi/nph-Parser?Sect1=PTO2&Sect2=HITOFF&p=1&u=%2Fnetahtml%2FPTO%2Fsearch-bool.html&r=0&f=S&l=2147483647&TERM1=A device for provisioning&FIELD1=ABTX&co1=AND&TERM2=&FIELD2=&d=PTXT";
System.out.println(temp);
	}

}
