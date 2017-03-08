package org.sign.rsa;

import javax.crypto.Cipher;

import org.sign.base64.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA加密解密操作
 * 
 * @author yujinshui
 * @createTime 2016年10月10日 下午5:39:18
 */
public class RSA {
	private static final String PRIVATE_KEY_1 = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKWmOMF5zQBqc8xA41zq9BKHI8GUdZdJR8qP57mv8y2N7T/TD1YeNEx3UH7cSWpsZpdzV5BWKAhH7sTOWfhIU+EhrXrWbQWAndWcT2+ZDYlI0ctJ5Bo1gM0MEU01+g3mhOf70I9DJrYGvoVYV815m+F46bjq8qVEL06zZZLEKCTPAgMBAAECgYEAjZl3rrvFp/NXpWRadtVJaoUm5ZVYp8g2nEtDVJG5mFlYU1TCKWWMY0kjAC6ie1zKnfA1C+b6NYn36zhR5FE/kTSwUYT1P6INT4rD7JUEiwE8hi4MTvWIDCyqeUmb2H+abHpBo9VZymmh5wmwRTi1PgPQGTDq5uP519lgD00DzEECQQDZzHPSvgy0GztmD6Uip1mHDI9j7syIEVCEPtuIsNzH63GQdR5jLH7hZn0WRXEgrZa+f3gKZnFIew+lj6Ip1lPRAkEAwrQrwe6dcioJHdc0PsW/In5TOBTY+ppVKhrkJ6x9UOzZT/BYuXUFVJL8kiKGIK0wihOzMhHK57HjoN5fT5w2nwJBAJ5D4npmXgbWrxAYGFCZOQZYyy28DmZl5pNitdabZqPj5A8r/Bvm7oBOIGF5rp4nZh4htJIiJPmdax5MxHMQarECQH8yMPvqpJT2fSovcwQnL2ybVkZm6DEfLc/p7W81slBxyq38eBoAJtFPjQzy3Ojv+6vYntJw6Ttf7TMk0uMxTEUCQDw1ZXU5jiKoktSYjHjFL2EfqtfT9F8xTHVyaruKL+R67Z0OvxMNlM0j77ADUS/BAFlwF2bCsSkMT3PLvcNtpPk=";
	private static final String PUBLIC_KEY_1 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQClpjjBec0AanPMQONc6vQShyPBlHWXSUfKj+e5r/Mtje0/0w9WHjRMd1B+3ElqbGaXc1eQVigIR+7Ezln4SFPhIa161m0FgJ3VnE9vmQ2JSNHLSeQaNYDNDBFNNfoN5oTn+9CPQya2Br6FWFfNeZvheOm46vKlRC9Os2WSxCgkzwIDAQAB";

	private static final String PRIVATE_KEY_2 = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALtIEpWSusR6q7Zgf/ga5/5pfnGj/EMY88d9cWzhNnV5eXggbd6xpOuPA9HF6Jzpb+DVNqDol7Q15PupUIZSjzgHWjdi36T1MFu67cpvMtzuTDpTCctSGVgBZZlJ/FOaephYmL9dOfVvyiPRpRkQlXAp1bTR6vt82YlAqEGnYXZHAgMBAAECgYB6jwfaalNfEQgeKbiVHMaFb3QX2kDTiBjAjA8WOavx5LThMBe2jHpozQaq2OEJDprwf5doZc4hWMOpDXxs6spduKomQZnXMfjjsIWgHcZkILbWrm5t8yMJ9QKNHUj6IJLICxoPzhLgbGiarIRdFnbDSpErIYLRHU7WtjD99WHOQQJBAO19ItoiEjpmzxJId7V/DhWQf1TO+MxVtTI3MNP+cLc+dDFQSONBEYNvGJ53MMufOP3jvyj6zvJa7vsD/oIJBBUCQQDJ4RkMWGGeFnHQRbghhlYiWYHyBb5QXwoMqMjTdFDBosHYGOJZGkc0XCXEcpDFM5EUznIWHLYRG8d2oyOjmpvrAkBdmPT0bXsrozs3JHJxiIqfexyD6zJpLdpE2TWYR25a+fVHPjILxqhFWbKlOap0heMrROghGYAYSjhnm7Jhw3XlAkBfyaaQ7P6kfBHUuL/9aDhGZCH8LC15BR9Hkm53pqEKv6cqWeRMUuOmPHLPG20FpMoaDTqks0rQI1YpPI8Uea+xAkEA2+6/SzFV+K7v2rHA+LkBIuCr0m5JoZU11vSsXjyeY8PewIBDF8JBKLWOPO72RWsILeJf2Tr4fknha20BA+wNPw==";
	private static final String PUBLIC_KEY_2 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC7SBKVkrrEequ2YH/4Guf+aX5xo/xDGPPHfXFs4TZ1eXl4IG3esaTrjwPRxeic6W/g1Tag6Je0NeT7qVCGUo84B1o3Yt+k9TBbuu3KbzLc7kw6UwnLUhlYAWWZSfxTmnqYWJi/XTn1b8oj0aUZEJVwKdW00er7fNmJQKhBp2F2RwIDAQAB";
	
	private static final String PRIVATE_KEY_3 = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAN/lFh/G6d6phEgKypF5VGiCJfzAoHyV+nonjCuYwI4J25HiRkAeLWkkASGdKYatalQnwLhgOuGE6BBx2h4zQL72Vi+xP8H5h5t9KUvxvU1gHyZTWQT9gmChM6D29rFpuNam7m2oA5IEXLwEtuFQdJI8YzWqKNifQNvoFgkScklPAgMBAAECgYB0l4d95MfE++G24me6ecRK5/uAM49fUXquQgnsag9b6CY/QeXzXcOoDOfJ6V3GlGfaixkA6pu+9MckSSWctHPyBAIwmC0iiT/T03KkmY6E2FauxJ7PxFTPuNv4QWb8TKOUqUp4L1xEeCHcjQK/5mmo1DbvshaPqPTMzphmne3ZgQJBAPyIFk4ac1lxoEBHIr/Ar0yt7jO40OLGCg3nidGw+mb61WJeGPCXLNWj4q0RQKRLlqfbPvwW3/2IT5k9fDf0cq0CQQDi+E+tkws/NodGb7kBmIipQlvN6UMVTO4tMY7S8fWDZzi9bd/dUOHZV1vPq8WRzeTpoExOP5Cy+FrVtTnAxidrAkEA8pwDYdHDk+C35kjxN2t0fqRyvjoGZHeCXU1eeJggWSMOMczZBPsX1b/3G/IBOlZsTKMz5ZhMZRS59Cy/1DoCmQJAN6ogmHhMtNchvCOgYwTO13wf2dNQkYPJkinqVk/jH7QMFWFCGxxAF7a2HKuLC+RMNQQMUtCCI3KHjIwiuuWeOwJBAKYpLmWRYXeD6aTo8v0PXX9aUCBKA8gJ3rxDwUyp6yqYOeoajB/Uc5EcqpQCsVrG3xKDPWhcJkRH9lFf1S4y27U=";
	private static final String PUBLIC_KEY_3 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDb+8va4joVwB+cLDXLFd2F6SLOTpP4DasZ+gOizLxW0B/HPwMDRyrlRMOdZiCNSob1iH/NNmgYR5qcO8c/WdvmZ8xGDDq0qassLo1jSaU3sc8FiYA3oL7Xl8uOWnubZ07OronMSVFzlepvW5uDIyMhbDUCYqXmnI9dRrG6P2JvDQIDAQAB";
	
	public static String ALGORITHM = "RSA";

	public static String SIGN_ALGORITHMS = "SHA1WithRSA";// 摘要加密算饭

	private static String log = "RSAUtil";

	public static String CHAR_SET = "UTF-8";

	public static String sign(String content, String privateKey) {
		try {
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
			KeyFactory keyf = KeyFactory.getInstance("RSA");
			PrivateKey priKey = keyf.generatePrivate(priPKCS8);

			java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);

			signature.initSign(priKey);
			signature.update(content.getBytes(CHAR_SET));

			byte[] signed = signature.sign();

			return Base64.encode(signed);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static boolean verify(String content, String sign, String public_key) {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			byte[] encodedKey = Base64.decode(public_key);
			PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

			java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);

			signature.initVerify(pubKey);
			signature.update(content.getBytes(CHAR_SET));

			boolean bverify = signature.verify(Base64.decode(sign));
			return bverify;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 通过公钥解密
	 *
	 * @param content
	 *            待解密数据
	 * @param pk
	 *            公钥
	 * @return 返回 解密后的数据
	 */
	protected static byte[] decryptByPublicKey(String content, PublicKey pk) {

		try {
			Cipher ch = Cipher.getInstance(ALGORITHM);
			ch.init(Cipher.DECRYPT_MODE, pk);
			InputStream ins = new ByteArrayInputStream(Base64.decode(content));
			ByteArrayOutputStream writer = new ByteArrayOutputStream();
			// rsa解密的字节大小最多是128，将需要解密的内容，按128位拆开解密
			byte[] buf = new byte[128];
			int bufl;
			while ((bufl = ins.read(buf)) != -1) {
				byte[] block = null;

				if (buf.length == bufl) {
					block = buf;
				} else {
					block = new byte[bufl];
					for (int i = 0; i < bufl; i++) {
						block[i] = buf[i];
					}
				}

				writer.write(ch.doFinal(block));
			}

			return writer.toByteArray();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 通过私钥加密
	 *
	 * @param content
	 * @param pk
	 * @return,加密数据，未进行base64进行加密
	 */
	protected static byte[] encryptByPrivateKey(String content, PrivateKey pk) {

		try {
			Cipher ch = Cipher.getInstance(ALGORITHM);
			ch.init(Cipher.ENCRYPT_MODE, pk);
			return ch.doFinal(content.getBytes(CHAR_SET));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("通过私钥加密出错");
		}
		return null;

	}

	/**
	 * 解密数据，接收端接收到数据直接解密
	 *
	 * @param content
	 * @param publicKey
	 * @return
	 */
	public static String decrypt(String content, String publicKey) {
		System.out.println(log + "：decrypt方法中key=" + publicKey);
		if (null == publicKey || "".equals(publicKey)) {
			System.out.println(log + "：decrypt方法中key=" + publicKey);
			return null;
		}
		PublicKey pk = getPublicKey(publicKey);
		byte[] data = decryptByPublicKey(content, pk);
		String res = null;
		try {
			res = new String(data, CHAR_SET);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * 对内容进行加密
	 *
	 * @param content
	 * @param privateKey
	 *            私钥
	 * @return
	 */
	public static String encrypt(String content, String privateKey) {
		PrivateKey pk = getPrivateKey(privateKey);
		byte[] data = encryptByPrivateKey(content, pk);
		String res = null;
		try {
			res = Base64.encode(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;

	}

	/**
	 * 得到私钥对象
	 * 
	 * @param privateKey
	 *            密钥字符串（经过base64编码的秘钥字节）
	 * @throws Exception
	 */
	public static PrivateKey getPrivateKey(String privateKey) {
		try {
			byte[] keyBytes;

			keyBytes = Base64.decode(privateKey);

			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);

			KeyFactory keyFactory = KeyFactory.getInstance("RSA");

			PrivateKey privatekey = keyFactory.generatePrivate(keySpec);

			return privatekey;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取公钥对象
	 * 
	 * @param publicKey
	 *            密钥字符串（经过base64编码秘钥字节）
	 * @throws Exception
	 */
	public static PublicKey getPublicKey(String publicKey) {

		try {

			byte[] keyBytes;

			keyBytes = Base64.decode(publicKey);

			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

			KeyFactory keyFactory = KeyFactory.getInstance("RSA");

			PublicKey publickey = keyFactory.generatePublic(keySpec);

			return publickey;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	private static void checkSign() {
		String str = Base64.encode("test".getBytes());
		System.out.println("Base64加密-->" + str);
		String aaa = sign(str, PRIVATE_KEY_3);
		System.out.println("加签-->" + aaa);
		System.out.println("验签-->" + verify(str, aaa, PUBLIC_KEY_3));
		System.out.println("原文-->" + new String(Base64.decode(str)));
	}

	public static void integrationTest(String content) {
		if (content == null) {
			content = "Hello,world";
		}
		String encryptText = encrypt(content, PRIVATE_KEY_3);
		System.out.println("密文：" + encryptText.length());
		String decryptText = decrypt(encryptText, PUBLIC_KEY_3);
		System.out.println("原文：" + decryptText);
	}

	public static void main(String[] args) {
//		integrationTest(null);
		checkSign();
	}

}
