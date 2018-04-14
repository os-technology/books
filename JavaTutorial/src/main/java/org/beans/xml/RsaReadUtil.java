package org.beans.xml;


import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;


/**
 * <b>公私钥读取工具</b><br>
 * <br>
 * 
 * @author 行者
 * @version 4.1.0
 */
public final class RsaReadUtil {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RsaReadUtil.class);

	/**
	 * 读取私钥
	 * @param pfxCer
	 * @param pwd
	 * @return
	 */
	public static  PrivateKey getPrivateKeyFromFile(String pfxCer,String pwd){
		try {
            InputStream priKeyStream = RsaReadUtil.class.getClassLoader().getResourceAsStream(pfxCer);
            byte[] reads = new byte[priKeyStream.available()];
            priKeyStream.read(reads);

			char[] charPriKeyPass = pwd.toCharArray();
			KeyStore ks = KeyStore.getInstance("PKCS12");
			ks.load(new ByteArrayInputStream(reads), charPriKeyPass);
			String keyAlias = null;

			Enumeration<String> aliasEnum = ks.aliases();
			while (aliasEnum.hasMoreElements()) {
				keyAlias = (String) aliasEnum.nextElement();

				if (ks.isKeyEntry(keyAlias)) {
                    break;}

			}
			return (PrivateKey) ks.getKey(keyAlias, charPriKeyPass);
			
		} catch (KeyStoreException e) {
            logger.error("getPrivateKeyFromFile#加载证书异常",e);
		} catch (IOException e) {
            logger.error("getPrivateKeyFromFile#加载证书异常",e);
		} catch (NoSuchAlgorithmException e) {
            logger.error("getPrivateKeyFromFile#加载证书异常",e);
		} catch (CertificateException e) {
            logger.error("getPrivateKeyFromFile#加载证书异常",e);
		} catch (UnrecoverableKeyException e) {
            logger.error("getPrivateKeyFromFile#加载证书异常",e);
		}		
		return null;
		
	}
	
	/**
	 * 读取公钥
	 * @param pubCerPath
	 * @return
	 */
	@SuppressWarnings("hiding")
	public static PublicKey getPublicKeyFromFile(String pubCerPath) {
        InputStream pubKeyStream = null;
		try {
			CertificateFactory certificatefactory = CertificateFactory.getInstance("X.509");
            pubKeyStream = RsaReadUtil.class.getClassLoader().getResourceAsStream(pubCerPath);
            X509Certificate Cert = (X509Certificate) certificatefactory.generateCertificate(pubKeyStream);
            return Cert.getPublicKey();
		} catch (CertificateException e) {
			e.printStackTrace();
		}  finally {
			if (pubKeyStream != null) {
				try {
					pubKeyStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
