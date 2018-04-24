package org.qrcode.zxing;

import org.junit.Test;

public class QrcodeTest {
	@Test
	public void createNoLogoQrCode() {
		String text = "HTTPS://AAX0.CN/5YF8AJFUMFNW1BT5QRYD";
		String file = "pic1.jpg";
		try {
			QRCodeUtil.encode(text, "", "/Users/yujinshui/Desktop", true, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void createLogoQrCode() {
		String text = "HTTPS://AAX0.CN/6YF8AJFUMFNW1BT5QRYA";
		String file = "logo.jpg";
		try {
			QRCodeUtil.encode(text, "/Users/yujinshui/Desktop/11.jpg", "/Users/yujinshui/Desktop", true, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void translateQrCode() {
		try {
			String result = QRCodeUtil.decode("/Users/yujinshui/Desktop/2.jpg");
			System.out.println("解析结果：" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void output() {
		String info = "f4de502e58723e6252e8856d4dc8fc3b";
		int len = info.length();
		for (int a = len-1; a >= 0; a--) {
			System.out.print((char)info.getBytes()[a]);
		}
	}

}
