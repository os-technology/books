package org.JavaTutorial;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void info() {
		System.out.println("info start ...");
		if (1 == 17) {
			return;
		}
		System.out.println("Execute is ok");
	}

	private String prop = null;
	@Test
	public void test() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			getProperties("property.conf");
			Thread.sleep(2000);
			System.out.println(i + "当前参数值=" + prop);
		}
	}

	private void getProperties(String fileName) {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			System.out.println("配置文件读取失败，请检查.");
			e1.printStackTrace();
		}
		setPropertiesValues(p);
	}

	private void setPropertiesValues(Properties p) {
		prop = p.getProperty("HELLO");

	}

}
