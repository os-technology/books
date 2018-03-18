package org.algorithm.password;

import java.util.UUID;

import org.algorithm.list.md5.Md5Util;

public class PasswordUtil {

	/**
	 * 使用加密盐加密value值
	 * 
	 * @param value
	 *            需要加密的值
	 * @param salt
	 *            加密盐
	 * @return
	 * @Author yujinshui
	 * @createTime 2017年4月3日 下午9:48:44
	 */
	public static String encrypt(String value, String salt) {
		return Md5Util.MD5Encode(value + (salt == null ? "" : salt));
	}

	/**
	 * 获取加密盐
	 * 
	 * @return
	 * @Author yujinshui
	 * @createTime 2017年4月3日 下午9:48:24
	 */
	private static String getSalt() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 密码比对
	 * 
	 * @param input
	 *            实际输入的密码明文
	 * @param salt
	 *            加密盐
	 * @param value
	 *            库中已保存的密码密文
	 * @return
	 * @Author yujinshui
	 * @createTime 2017年4月3日 下午9:37:25
	 */
	public static boolean compareValue(String input, String salt, String value) {
		if (input == null || value == null) {
			return false;
		}
		return value.equals(encrypt(input, salt));
	}

	public static String upperUuid() {
		return getSalt().toUpperCase();
	}

}
