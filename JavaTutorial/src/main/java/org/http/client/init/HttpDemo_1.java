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
		HttpGet httpGet = new HttpGet("http://172.30.21.20:9001/v1/face/auth/3211");
		httpGet.getURI();
		httpGet.addHeader("ContentType","application/json;charset=utf-8");
		httpGet.addHeader("Authorization","5b97b3138041437587646b37f52dc7f7");
		httpGet.addHeader("nonce","9979e09d6bc44f1880cc9484c27d857b");
		httpGet.addHeader("timestamp","1476756211867");
		httpGet.addHeader("sign","omAIgsgOcpNnsQkiA5bcqBDMDnXHcIOZkxco1IGKvCa5E5V3xdMaTah3oWLFsTZdCTIV/06MqlTBOL6Vw9x2sYJLLx2lbsghd0oLbYFl9LJqG19VbeTYaDKn1O+xUX6cT2sk4tKrhiXmDcMx9AW8UN6bWK4CuSRAVsXh0w0Iajc=");
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
			System.out.println(res);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpclient.close();
		}

	}

}
