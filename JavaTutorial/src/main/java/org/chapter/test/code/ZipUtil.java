package org.chapter.test.code;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

// 将一个字符串按照zip方式压缩和解压缩
public class ZipUtil {

	// 压缩
	public static String compress(String str) throws IOException {
		if (str == null || str.length() == 0) {
			return str;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(out);
		gzip.write(str.getBytes());
		gzip.close();
		return out.toString("ISO-8859-1");
	}

	// 解压缩
	public static String uncompress(String str) throws IOException {
		if (str == null || str.length() == 0) {
			return str;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
		GZIPInputStream gunzip = new GZIPInputStream(in);
		byte[] buffer = new byte[256];
		int n;
		while ((n = gunzip.read(buffer)) >= 0) {
			out.write(buffer, 0, n);
		}
		// toString()使用平台默认编码，也可以显式的指定如toString(&quot;GBK&quot;)
		return out.toString();
	}

	// 测试方法
	public static void main(String[] args) throws IOException {
		String str = Base64Util.getImgBase64Str("/Users/yujinshui/Desktop/result_05.jpg");

		// 测试字符串
		// String str =
		// "%5B%7B%22lastUpdateTime%22%3A%222011-10-28+9%3A39%3A41%22%2C%22smsList%22%3A%5B%7B%22liveState%22%3A%221";

		System.out.println("原长度：" + str.length());
		String zipStr = ZipUtil.compress(str);
//		zipStr = ZipUtil.compress(zipStr);
		System.out.println("压缩后：" + zipStr.length());
		String unStr = ZipUtil.uncompress(zipStr);
		// System.out.println("解压缩：" + unStr);
		String img = Base64Util.getBase64ToImg(unStr, "/Users/yujinshui/Desktop/");
		System.out.println(img);
	}

}
