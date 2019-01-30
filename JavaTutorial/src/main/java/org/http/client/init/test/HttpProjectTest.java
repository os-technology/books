package org.http.client.init.test;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;

public class HttpProjectTest {

	private void qpay(){
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost("http://localhost:8080/api/m/face/detect");
		
		File file = new File("/Users/yujinshui/Desktop/img/a.jpg");
		
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.addBinaryBody("image", file);
		
		
		FileEntity entity = new FileEntity(file, ContentType.create("multipart/form-data", "UTF-8"));
		httppost.setEntity(builder.build());
		try {
			HttpResponse response = httpclient.execute(httppost);
			String res = EntityUtils.toString(response.getEntity());
			System.out.println(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		HttpProjectTest test = new HttpProjectTest();
		test.qpay();

	}

}
