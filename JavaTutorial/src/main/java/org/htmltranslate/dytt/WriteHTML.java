package org.htmltranslate.dytt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteHTML {
    public void write(String html, String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(html);
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
