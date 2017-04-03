package org.algorithm.password;

import org.junit.Assert;
import org.junit.Test;

public class PasswordUtilTest {

	private String salt = "9E8FFCAA52644444872CA52F496813AC";
	String password = "Hello";

	@Test
	public void testEncrypt() {
		String result = PasswordUtil.encrypt(password, salt);
		System.out.println("密码：" + password);
		System.out.println("加密后：" + result);
	}

	@Test
	public void testCompare() {
		boolean bool = PasswordUtil.compareValue("Hell0", salt, "36e1125da34a61b951f50164f4acb415");
		Assert.assertTrue(bool);
	}
}
