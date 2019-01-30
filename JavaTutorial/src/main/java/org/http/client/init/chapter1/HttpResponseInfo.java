package org.http.client.init.chapter1;

import org.apache.http.*;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicHttpResponse;

/**
 * response部分
 * 
 * @author yujinshui
 * @createTime 2016年7月8日 下午2:26:51
 */
public class HttpResponseInfo {
	public static void responseInfo() {
		HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
		System.out.println(response.getProtocolVersion());
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(response.getStatusLine().getReasonPhrase());
		System.out.println(response.getStatusLine().toString());

	}

	private static void responseHeaders() {
		HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
		response.addHeader("Set-Cookie", "c1=a;path=/;domain=localhost");
		response.addHeader("Set-Cookie", "c2=b; path=\"/\", c3=c; domain=\"localhost\"");
		// Get Headers method 1
		Header h1 = response.getFirstHeader("Set-Cookie");
		Header h2 = response.getLastHeader("Set-Cookie");
		// System.out.println(h1);
		// System.out.println(h2);
		Header[] hs = response.getHeaders("Set-Cookie");
		// System.out.println(hs.length);
		// Get Headers method 2
		HeaderIterator it = response.headerIterator("Set-Cookie");

		// while (it.hasNext()) {
		// System.out.println(it.next());
		// }
		// Get Headers method 3
		HeaderElementIterator itelements = new BasicHeaderElementIterator(response.headerIterator("Set-Cookie"));
		while (itelements.hasNext()) {
			HeaderElement elem = itelements.nextElement();
			System.out.println(elem.getName() + " = " + elem.getValue());
			NameValuePair[] params = elem.getParameters();
			for (int i = 0; i < params.length; i++) {
				System.out.println(" " + params[i]);
			}
		}
	}

	public static void main(String[] args) {
		// responseInfo();
		responseHeaders();
	}
}
