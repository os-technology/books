package com.design.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.design.model.decorator.stream.LowerCaseInputStream;

public class LowerTest {
	/***
	 * 测试自定义大小写转换类
	 * 
	 * @throws FileNotFoundException
	 * @author Yujinshui
	 * @time 2016年1月12日 上午8:07:10
	 */
	public void testLowerCase() throws FileNotFoundException {
		int c;// 不支持中文
		InputStream in = new LowerCaseInputStream(
				new BufferedInputStream(new FileInputStream("src/test/resources/Noname1.txt")));
		try {
			while ((c = in.read()) >= 0) {
				System.out.print((char) c);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		LowerTest lower = new LowerTest();
		try {
			lower.testLowerCase();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
