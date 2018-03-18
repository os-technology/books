package org.htmltranslate.dytt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlParse {

    public String getHtmlByUrl(String u){
        return getHtmlByUrl(u,"UTF-8");
    }
    /**
     * 获取网站源码[核心方法1]
     *
     * @param u 网站地址
     * @return
     */
    public String getHtmlByUrl(String u,String encoding) {
        StringBuffer buf = new StringBuffer();

        try {

            URL url = new URL(u);
            InputStream is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is,encoding);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while (true) {
                line = br.readLine();
                if (line == null)
                    break;
                buf.append(line).append("\n");
            }

            br.close();
            isr.close();
            is.close();

        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }
}
