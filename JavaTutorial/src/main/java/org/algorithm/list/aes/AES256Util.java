package org.algorithm.list.aes;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

/**
 * @author code
 * @Title: AES256Util
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/10/23上午9:56
 */
public class AES256Util {
    public static boolean initialized = false;

    public static final String ALGORITHM = "AES/ECB/PKCS7Padding";

    /**
     * @param  str  要被加密的字符串
     * @param  key  加/解密要用的长度为32的字节数组（256位）密钥
     * @return byte[]  加密后的字节数组
     */
    public static byte[] Aes256Encode(String str, byte[] key) {
        initialize();
        byte[] result = null;
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM, "BC");
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES"); //生成加密解密需要的Key
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            result = cipher.doFinal(str.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param  bytes  要被解密的字节数组
     * @param  key    加/解密要用的长度为32的字节数组（256位）密钥
     * @return String  解密后的字符串
     */
    public static String Aes256Decode(byte[] bytes, String key) {
        initialize();
        String result = null;
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM, "BC");
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES"); //生成加密解密需要的Key
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decoded = cipher.doFinal(bytes);
            result = new String(decoded, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Android的Java运行环境中包含了"AES/ECB/PKCS7Padding"算法，但一般的JRE（如Oracle JRE、OpenJRE）里面只有"AES/ECB/PKCS5Padding"算法，
     * 没有"AES/ECB/PKCS7Padding"算法。故我们需要引入BouncyCastle的库，并给Cipher.getInstance方法传入参数"BC"来指定Java使用这个库里的加/解密算法。
     * BouncyCastle的加/解密类库在Maven仓库中的位置：<groupId>org.bouncycastle</groupId><artifactId>bcprov-jdk15on</artifactId>，
     * 其Jar包的下载地址：http://www.bouncycastle.org/latest_releases.html
     * <p>
     * 在这段代码可以运行之前，还有一个问题需要解决。Java本身限制密钥的长度最多128位，而AES256需要的密钥长度是256位，
     * 因此需要到Java官网上下载一个Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files。
     * 在Java SE的下载页面下面的Additional Resources那里会有下载链接。下载后打开压缩包，里面有两个jar文件。
     * 把这两个jar文件解压到JRE目录下的lib/security文件夹，覆盖原来的文件。这样Java就不再限制密钥的长度了。
     */
    public static void initialize() {
        if (initialized) return;
        Security.addProvider(new BouncyCastleProvider());
        initialized = true;
    }
}
