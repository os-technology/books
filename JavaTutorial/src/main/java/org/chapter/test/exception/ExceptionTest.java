package org.chapter.test.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ExceptionTest {

	public static void getImgBase64Str(String imgFile) {
		InputStream in = null;
		byte[] data = null;

		try {
			// FileInputStream inputStream = new FileInputStream(new
			// File("D:\\NEW_IMAGE"));

			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(new byte[0]);
			in.close();
		} catch (FileNotFoundException e1) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Exception");
		}
	}

	public static void main(String[] args) {
		String path = "/Users/yujinshui/Desktop/result_03.jpg";
		getImgBase64Str(path);
	}
}
