package org.http.client.init;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpDemo_1 {

	public static void main(String[] args) throws IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://localhost:8080/");
		httpGet.getURI();
		try {
			HttpResponse response = httpclient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			String res = EntityUtils.toString(entity);
			// if (entity != null) {
			// InputStream instream = entity.getContent();
			// int l;
			// byte[] tmp = new byte[2048];
			// while ((l = instream.read(tmp)) != -1) {
			// }
			// }

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpclient.close();
		}

	}

}
