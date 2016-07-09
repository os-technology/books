package org.http.client.init.chapter1;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * 1.1.4.2 HTTP实体
 * 
 * @author yujinshui
 * @createTime 2016年7月8日 下午5:25:42
 */
public class EntityContent {
	static void entity() {
		StringEntity myEntity = new StringEntity("important message", "UTF-8");
		System.out.println(myEntity.getContentType());
		System.out.println(myEntity.getContentLength());
		System.out.println(EntityUtils.getContentCharSet(myEntity));
		try {
			System.out.println(EntityUtils.toString(myEntity));
			System.out.println(EntityUtils.toByteArray(myEntity).length);
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
	}

	/** 1.1.5 确保低级别资源释放 */
	static void abortMethod() {
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet("http://localhost:8081/");
		HttpResponse response;
		try {
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream instream = entity.getContent();
				int byteOne = instream.read();
				int byteTwo = instream.read();
				httpget.abort();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
//		entity();
		abortMethod();
		System.out.println("Execute is OK.");

	}

}
