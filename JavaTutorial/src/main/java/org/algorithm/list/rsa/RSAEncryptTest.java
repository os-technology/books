package org.algorithm.list.rsa;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @author code
 * @Title: RSAEncryptTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/7/1511:11 AM
 */
public class RSAEncryptTest {


    private static final String private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIXOiuVpwiTmXlOeL//b+Np+EVi9v2r2pHzhSmkqp1x6mlFGUQUm+/zzUYbIQjMH8SPE0d5FCo3LVif8ByMcAR2mVbADoSPzeOBE/SIsGWnk2VUtm4PUolX63VR02CR/g0aMe2h1mNuTRSHTxRKdPBSY1QaalQQ4GZZjZD4XyPtZAgMBAAECgYA7oLgq1b9LnFFKqAKx3T//dhCa4CvuKa1RbUAwr25XetdMAq7WQfInXfLlwlYl0ZM3Il131IKIf6WMOfagQbmI5dSJ1J+DxMwBhwEJ+4W2vQ3+11OFW0ecSgfdV13/l91fipf1lUziN8RFEWxZEZYjbK7mNpXMvUk8ezRB0UF6AQJBAPhZP8pqIkyiJF9Bz7UdUNd3HkMFaSZ9rmMVhFQ5oZCe3vByK1dKAN64belGPF43hx6QLcbx8znos/CQ8lXoLJkCQQCJ7ePyIaQlZhoFxhzbq1r9RBjEwDDVLUHscANlQEOKmKPP5dvwv74CewGm+GBv0G6iCSUuByh+KRXPrFLjV7zBAkEAisXsZGIsKmBMLMJsm0r3Wn8gdNj4Kd7+7DUgzaOqiVKNRxS07UDX/ZxXJovtvcQPh9+PBOU8QXar3dhQ4foruQJACxU0ZbZSTDcCDEi49OW17/fSzaxrwBVc4LS3cSFSzAYr036yx4uApw5fOZ1nklR7L0Xw2Nv2YvzGJePA3UelgQJAHPuO1IiW9vcWL5HtKG6mWwYj8fot8BWt6fdnVuqZ/GK3uUowW1xDMs/uKnUSA+q8ukC9tPIrGinc6HZ7eKH9rg==";
    private static final String public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCFzorlacIk5l5Tni//2/jafhFYvb9q9qR84UppKqdceppRRlEFJvv881GGyEIzB/EjxNHeRQqNy1Yn/AcjHAEdplWwA6Ej83jgRP0iLBlp5NlVLZuD1KJV+t1UdNgkf4NGjHtodZjbk0Uh08USnTwUmNUGmpUEOBmWY2Q+F8j7WQIDAQAB";


    private static final String PRIVATE_KEY_6 = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAM4NhpX3//6a67PBV8CRe+pn7qe5tOdnEIZefOshduS49OSD7qJ3IjXQGzC7MYMUDoUi/wzxbUu0S1AQfgm0xpkt8kUqF8XpgfUmjw3cc/xoccmNrKxuDMVsD3Prgw9foFKo+WoRJT0oosvmHszX+zSJCH3/4LZK8r04M++x8JB1AgMBAAECgYAPtsxax40IV7w9+zK8BtxSZha3R9xaAWwrMy2HqQeuLcTPYJhkX32GaRaJwtzlyDPLR333+LmDGn7b3kYea2DxzpyfXmTH5OD5/CS4CNo0JRYMoR5LjMaVdPctov4c8wpnopNolTFrTWkyRDT6CNO4juPr+pgGE0yEZq0bZ66fyQJBAOhZikhIaJKaVgS8jFNQxgaD9ePxk4EJhDKALkQ3/8nn2kdxuSNOXHZUS3TrPcOeRF/G9KBzeugBu2M3sVM2E6cCQQDjBsCrTcMUru1xLZEg8WACi+hmEow4MpIS6Cj2FUhHLnKYE9+cgEorDxt3SMB3VWOUsSca/vihMfhYpa1F766DAkEA3Aa20X5oMLQgUvnt9JPgApmCB6pjoWVOn7gMmCNjgWKirNc/l/SD0LZAgmamJZHBc+VnEG5q7Dt/pRQ/QupJrwJBAKtBI8PVRAxtLGYMxoaALjmdinC9GxMlarVidcu0IDK54e3ASBUJXWl/2usvcShTvGuk+ufNYIZQaJOOXtf7xrsCQBoOV02vozK8f85SjSI31bwts+L9I+9Wsk1LMtfZ00hfsROwP8mRCl1Uy4jMavdTmfURC550OxxkDUaaASrHbH8=";
    private static final String PUBLIC_KEY_6 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC9c4qIiYlX8iCdjElTcagocJB+iIoBLPup3BToZDg3ZZhHUJtdLA3ZtLooTY6HtjiFedgnMG6D3SG7c8sT9j9em0TRQDZUyFh8WHntHw/tq0vozv4Jg9gprRxFlnNhKbPCvUmSzYT4fQr96LQexreLDfk4OkqbqZViM2tN9QCWkwIDAQAB";



    private static final String PRIVATE_KEY_7 = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAPLZ6a3fDxwtHJvFMICYGxgceaAY521NsEYFE4NLcVvcRUcjlOHz6rqT71cC9Db2aNGwS7dKoULGwQ2O5xMV2Pvh0dcHoW/bXgm6bxU570d9hSjtK2Kj/YnNe79hfgO9RQTypYa/ihTFm4jwRcZBLwr/SQ+nPVKQF9lZ3ii7/EIBAgMBAAECgYEApz8nzZSGxXLT9vsQch9O2YYSxQ0hpIcSVMZ+L7evNAI4u8tnZ00iZKgo9pWUNp3whiiRnIOLF3/lyD6YKO6s5UOPkV2oYaI7ZZ5W0Yu+Jor+Yok1zx4IarCb9y6JrVLaPyDUSIWaIXJYmBzF3SBhD6YtgNpd+I+1pgrHY3174gECQQD/l/1SdSFjSuz2ag3EkSYiSfvw0VYdo3fYjcZekOzBtBjBNKJbnsI6YTdGXV9RMPl6Ag0a1Y8VkLxw6XFhepHRAkEA8zy85fn0XDU8Z9X5kfqefzKdGcx/JT0PN499Xs7Bt9sxH99aMsjgSM732HPPHo75/HNtXUFHjBkzzLw7oYYJMQJBAMkVYo9E54eeot8agMptB3tiiXvktcOLn/YXVEGB80JR1kfqiPFb7aLQaRRK0Xqm9R8wDe9WpMNqo1aR0knGjIECQCRU1S5QuIQxW3VzC5UXZyc+qyKYXgF07lnxL9vCbEMHFX5aQUHGqWGWsIR/P9ejqYlgwFwmjQZLGWaiUxHcUHECQQCFU+8HuGaZhcDQ3KOVpXl+uaSGhClCKCPSN1ie7M7BVfuBFjsPcyHgxQw4+bA2w3s6kq3O2osyohg0j5hCH9ls";
    private static final String PUBLIC_KEY_7 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC9c4qIiYlX8iCdjElTcagocJB+iIoBLPup3BToZDg3ZZhHUJtdLA3ZtLooTY6HtjiFedgnMG6D3SG7c8sT9j9em0TRQDZUyFh8WHntHw/tq0vozv4Jg9gprRxFlnNhKbPCvUmSzYT4fQr96LQexreLDfk4OkqbqZViM2tN9QCWkwIDAQAB";


    private static Map<Integer, String> keyMap = new HashMap<>();  //用于封装随机产生的公钥与私钥

    public static void main(String[] args) throws Exception {
//        execute();
//        exe1(private_key,public_key);
        exe1(PRIVATE_KEY_7,PUBLIC_KEY_7);


    }

    private static void exe1(String private_key, String public_key) throws Exception {
        //加密字符串
        String message = "数据信息";

        String messageEn = encrypt(message, public_key);
        System.out.println(message + "\t加密后的字符串为:" + messageEn);
        String messageDe = decrypt(messageEn, private_key);
        System.out.println("还原后的字符串为:" + messageDe);
    }

    private static void execute() throws Exception {
        //生成公钥和私钥
        genKeyPair();
        //加密字符串
        String message = "数据信息";
        System.out.println("随机生成的公钥为:" + keyMap.get(0));
        System.out.println("随机生成的私钥为:" + keyMap.get(1));
        String messageEn = encrypt(message, keyMap.get(0));
        System.out.println(message + "\t加密后的字符串为:" + messageEn);
        String messageDe = decrypt(messageEn, keyMap.get(1));
        System.out.println("还原后的字符串为:" + messageDe);
    }

    /**
     * 随机生成密钥对
     *
     * @throws NoSuchAlgorithmException
     */
    public static void genKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(1024, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
        // 得到私钥字符串
        String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
        // 将公钥和私钥保存到Map
        keyMap.put(0, publicKeyString);  //0表示公钥
        keyMap.put(1, privateKeyString);  //1表示私钥
    }

    /**
     * RSA公钥加密
     *
     * @param str       加密字符串
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     */
    public static String encrypt(String str, String publicKey) throws Exception {
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * RSA私钥解密
     *
     * @param str        加密字符串
     * @param privateKey 私钥
     * @return 铭文
     * @throws Exception 解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws Exception {
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }
}
