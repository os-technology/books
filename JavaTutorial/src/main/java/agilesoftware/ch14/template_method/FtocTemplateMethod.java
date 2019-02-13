package agilesoftware.ch14.template_method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 模板方法模式
 *
 * @author code
 * @Title: FtocTemplateMethod
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/2/13下午3:02
 */
public class FtocTemplateMethod extends Application {

    private InputStreamReader isr;
    private BufferedReader br;

    public static void main(String[] args) {
        (new FtocTemplateMethod()).run();
    }

    @Override
    protected void init() {

        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);

    }

    @Override
    protected void idle() {
        String fahrString = readLineAndReturnNullIfError();
        if (fahrString == null || fahrString.length() == 0) {
            setDone();
        } else {
            double fahr = Double.parseDouble(fahrString);
            double celcius = 5.0 / 9.0 * (fahr - 32);
            System.out.println("F=" + fahr + ",C=" + celcius);
        }
    }

    private String readLineAndReturnNullIfError() {
        String s;

        try {
            s = br.readLine();
        } catch (IOException e) {
            s = null;
        }
        return s;
    }

    @Override
    protected void cleanup() {
        System.out.println("ftoc exit");
    }
}
