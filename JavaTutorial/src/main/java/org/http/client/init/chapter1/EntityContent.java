package org.http.client.init.chapter1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 1.1 HTTP实体
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

	/**
	 * 1.1.5 确保低级别资源释放
	 * 
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	static void abortMethodContent() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet("http://localhost:8081/");
		CloseableHttpResponse response = httpclient.execute(httpget);
		try {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream instream = entity.getContent();
				int byteOne = instream.read();
				int byteTwo = instream.read();
				// Do not need the rest
			}
		} finally {
			response.close();
		}

	}

	static void abortMethod() {
		try {
			abortMethodContent();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 1.1.6 消耗实体内容
	 * 
	 * @throws IOException
	 * 
	 * @Author yujinshui
	 * @createTime 2016年7月10日 上午8:36:41
	 */
	static void consumingEntityContent() throws IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet("http://localhost:8081/nexus#welcome");
		CloseableHttpResponse response = httpclient.execute(httpget);
		try {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				long len = entity.getContentLength();
				if (len != -1 && len < 2048) {
					System.out.println(EntityUtils.toString(entity));
				} else {
					// Stream content out
				}
				entity = new BufferedHttpEntity(entity);

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			response.close();
		}
	}

	/**
	 * 1.1.7 生成实体内容
	 * 
	 * @Author yujinshui
	 * @createTime 2016年7月11日 上午10:55:49
	 */
	static void productEntityContent() {
		File file = new File("/Users/yujinshui/Desktop/img/a.jpg");
		FileEntity entity = new FileEntity(file, ContentType.create("plain/text", "UTF-8"));
		HttpPost httppost = new HttpPost("http://localhost:8081/nexus");
		httppost.setEntity(entity);
	}

	/** 1.1.7.1 HTML 表单 */
	static void htmlForms() {
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("param1", "value1"));
		formparams.add(new BasicNameValuePair("param2", "value2"));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://localhost");
		httppost.setEntity(entity);
	}

	/**
	 * 1.1.8 响应控制器
	 * 
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	static void responseHandlers() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet("http://localhost:8081/nexus/json");
		ResponseHandler<MyJsonObject> rh = new ResponseHandler<MyJsonObject>() {
			@Override
			public MyJsonObject handleResponse(final HttpResponse response)
					throws ClientProtocolException, IOException {
				StatusLine statusLine = response.getStatusLine();
				HttpEntity entity = response.getEntity();
				if (statusLine.getStatusCode() >= 300) {
					throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
				}
				if (entity == null) {
					throw new ClientProtocolException("Response contains no content");
				}
				Gson gson = new GsonBuilder().create();
				ContentType contentType = ContentType.getOrDefault(entity);
				Charset charset = contentType.getCharset();
				Reader reader = new InputStreamReader(entity.getContent(), charset);
				return gson.fromJson(reader, MyJsonObject.class);
			}
		};
		MyJsonObject myjson = httpclient.execute(httpget, rh);
	}

	static void test() {
		// entity();
		// abortMethod();
		productEntityContent();
//		try {
//			// consumingEntityContent();
//			responseHandlers();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

	public static void main(String[] args) {
		test();
		System.out.println("Execute is OK.");

	}

}
