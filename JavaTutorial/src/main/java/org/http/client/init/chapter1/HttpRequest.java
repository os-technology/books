package org.http.client.init.chapter1;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

/**
 * request部分
 * 
 * @author yujinshui
 * @createTime 2016年7月8日 下午1:56:54
 */
public class HttpRequest {

	static void httpGetPrint() {
		String httpurl = "http://www.google.com/search?hl=en&q=httpclient&btn=Google+Search&aq=f&oq=";
		HttpGet httpget = new HttpGet(httpurl);
		// System.out.println(httpget.getURI());

		try {
			URI uri = URIUtils.createURI("http", "www.google.com", -1, "/search", "hl=en&q=httpclient", null);
			HttpGet http = new HttpGet(uri);
			System.out.println(http.getURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	static void valuePair() {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("q", "httpclient"));
		params.add(new BasicNameValuePair("oq", null));

		try {

			URI uri = URIUtils.createURI("http", "www.google.com", -1, "/search",
					URLEncodedUtils.format(params, "UTF-8"), null);

			HttpGet httpget = new HttpGet(uri);
			System.out.println(httpget.getURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	static void valuePair4_5() {
		URI uri = null;
		try {
			uri = new URIBuilder().setScheme("http").setHost("www.google.com").setPath("/search")
					.setParameter("q", "httpclient").setParameter("btnG", "Google Search").setParameter("aq", "f")
					.setParameter("oq", "").build();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		HttpGet httpget = new HttpGet(uri);
		System.out.println(httpget.getURI());
	}

	public static void main(String[] args) {
		// httpGetPrint();
		// valuePair();
		valuePair4_5();

	}

}
