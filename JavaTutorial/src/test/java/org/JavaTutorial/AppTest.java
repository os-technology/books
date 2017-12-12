package org.JavaTutorial;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

import static java.lang.Math.PI;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testNum(){
        System.out.println("start");

        try {
            int a = Integer.valueOf("a");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println("program is end");
    }

    @Test
    public void strReplace(){
        String input = "123";
        input = input.replaceAll("2","");

        System.out.println(input);
        System.out.println(Long.valueOf(null));
    }

    @Test
    public void outputString() {
        String a = "123";
        String b = a;
        a = "345";
        System.out.println(a +"     "+b);
        System.out.println(PI);
    }


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
