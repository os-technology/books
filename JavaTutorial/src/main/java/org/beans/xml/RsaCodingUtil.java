package org.beans.xml;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;


/**
 * <b>Rsa加解密工具</b><br>
 * <br>
 * 公钥采用X509,Cer格式的<br>
 * 私钥采用PKCS12加密方式的PFX私钥文件<br>
 * 加密算法为1024位的RSA，填充算法为PKCS1Padding<br>
 * 
 * @author 行者
 * @version 4.1.0
 */
public final class RsaCodingUtil {

    private static BouncyCastleProvider provider= new BouncyCastleProvider();
	

	/**
	 * 指定Cer公钥路径解密
	 * 
	 * @param src
	 * @param pubCerPath
	 * @return
	 */
	public static String decryptByPubCerFile(String src, String pubCerPath) {
		PublicKey publicKey = RsaReadUtil.getPublicKeyFromFile(pubCerPath);
		if (publicKey == null) {
			return null;
		}
		System.out.println("值："+publicKey.toString());
		return decryptByPublicKey(src, publicKey);
	}
	
	
	/**
	 * 根据私钥路径加密
	 * @param src
	 * @param pfxCer
	 * @param priKeyPass
	 * @return
	 */
	public static String encryptByPriPfxFile(String src, String pfxCer, String priKeyPass) {

		PrivateKey privateKey = RsaReadUtil.getPrivateKeyFromFile(pfxCer, priKeyPass);
		if (privateKey == null) {
			return null;
		}
		System.out.println("值："+privateKey.toString());
		return encryptByPrivateKey(src, privateKey);

	}
	
	/**
	 * 根据私钥加密
	 * 
	 * @param src
	 * @param privateKey
	 */
	public static String encryptByPrivateKey(String src, PrivateKey privateKey) {

		byte[] destBytes = CryptCore(src.getBytes(), (Key)privateKey, Cipher.ENCRYPT_MODE);

		if (destBytes == null) {
			return null;
		}
		return FormatUtil.byte2Hex(destBytes);

	}
	
	/**
	 * 根据公钥解密
	 * 
	 * @param src
	 * @param publicKey
	 * @return
	 */
	public static String decryptByPublicKey(String src, PublicKey publicKey) {
		try {
			byte[] destBytes = CryptCore(FormatUtil.hex2Bytes(src), (Key)publicKey, Cipher.DECRYPT_MODE);

			if (destBytes == null) {
				return null;
			}
			return new String(destBytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();		
			System.out.println("解密内容不是正确的UTF8格式:");
		}
		return null;
	}

	
	/**
	 * 加密
	 * @param srcData
	 * @param mode
	 * @return
	 */
	public static byte[] CryptCore(byte[] srcData, Key PCkey, int mode) {
		try {
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", provider);
			cipher.init(mode, PCkey);
			// 分段加密
			int blockSize = cipher.getBlockSize();
			System.out.println("分段长度："+blockSize);			
			byte[] decryptData = null;
			
			for (int i = 0; i < srcData.length; i += blockSize) {
				byte[] doFinal = cipher.doFinal(subarray(srcData, i, i + blockSize));				
				decryptData = addAll(decryptData, doFinal);
			}
			return decryptData;
		} catch (NoSuchAlgorithmException e) {//私钥算法-不存在的解密算法
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {//私钥算法-无效的补位算法
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {//私钥算法-无效的块大小
			e.printStackTrace();
		} catch (BadPaddingException e) {//私钥算法-补位算法异常
			e.printStackTrace();
		} catch (InvalidKeyException e) {//私钥算法-无效的私钥
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	/**
	 * 辅助方法
	 * @param array
	 * @param startIndexInclusive
	 * @param endIndexExclusive
	 * @return
	 */
	public static byte[] subarray(byte[] array, int startIndexInclusive, int endIndexExclusive) {
		if (array == null) {
			return null;
		}
		if (startIndexInclusive < 0) {
			startIndexInclusive = 0;
		}
		if (endIndexExclusive > array.length) {
			endIndexExclusive = array.length;
		}
		int newSize = endIndexExclusive - startIndexInclusive;
				
		if (newSize <= 0) {
			return new byte[0];
		}

		byte[] subarray = new byte[newSize];

		System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);

		return subarray;
	}

	public static byte[] addAll(byte[] array1, byte[] array2) {
		if (array1 == null) {
			return clone(array2);
		} else if (array2 == null) {
			return clone(array1);
		}
		byte[] joinedArray = new byte[array1.length + array2.length];
		System.arraycopy(array1, 0, joinedArray, 0, array1.length);
		System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
		return joinedArray;
	}

	public static byte[] clone(byte[] array) {
		if (array == null) {
			return null;
		}
		return (byte[]) array.clone();
	}

}
