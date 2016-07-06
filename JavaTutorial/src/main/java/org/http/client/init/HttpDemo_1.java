package org.http.client.init;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpDemo_1 {

	public static void main(String[] args) {
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet("http://localhost:8080/");
		try {
			HttpResponse response = httpclient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream instream = entity.getContent();
				int l;
				byte[] tmp = new byte[2048];
				while ((l = instream.read(tmp)) != -1) {
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
