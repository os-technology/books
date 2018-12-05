package org.algorithm.base64;

import org.algorithm.list.base64.Base64;
import org.junit.Test;

import java.io.*;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: Base64DocTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/4/19上午10:27
 */

public class Base64DocTest {
    @Test
    public void outputEnv() {
        System.out.println("环境变量：" + System.getenv("PAYRIGHT_ZOOKEEPER_HOST"));
    }

    @Test
    public void testDoc() throws IOException {
        File filename = new File("/Users/yujinshui/Desktop/commonpay_pri.pfx");
        FileInputStream inputFromFile = new FileInputStream(filename);
        byte[] byteData = new byte[inputFromFile.available()];
        inputFromFile.read(byteData);
        inputFromFile.close();

        String result = Base64.encode(byteData);
        System.out.println(result);

        byte[] out = Base64.decode(result);
        FileOutputStream fos = new FileOutputStream("/Users/yujinshui/Desktop/com.pfx");
        fos.write(out);
        fos.close();
    }

}
