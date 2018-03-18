package org.number;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ascii
 */
public class BinaryToAscii {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/yujinshui/job/workspace/books/JavaTutorial/src/main/resource/binary.txt")));
		String[] ss = null;// 用来保存第一行的各项
		for (;;) {
			String str = br.readLine();
			// 如果读到文件最后一行之后，则退出循环
			if (str == null)
				break;
			ss = str.split(" ");// 每一行的各项用空格分开
			for (String s : ss) {
				int numasc = Integer.parseInt(s, 2);
				System.out.print((char) numasc);// 强制转换成char类型，并输出
			}
		}
		br.close();

	}

}
