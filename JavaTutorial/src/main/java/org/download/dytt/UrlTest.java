package org.download.dytt;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//		import com.deal.file.FileWrite;

public class UrlTest {
    private JFrame f = new JFrame("电影天堂下载地址抓取器");
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel("前五页地址抓取完成");
    private JLabel label2 = new JLabel("文件存放位置：C:/movieslist.txt");

    public void showFace() {
        panel.setLayout(new GridLayout(2, 1));
        panel.add(label);
        panel.add(label2);
        f.add(panel);
        f.setSize(300, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = (int) dim.getWidth();
        int h = (int) dim.getHeight();
        f.setLocation((w - 300) / 2, (h - 200) / 2);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        UrlTest u = new UrlTest();
        String urls = "http://www.ygdy8.net/html/gndy/dyzz/";
        String url = "http://www.ygdy8.net/html/gndy/dyzz/index.html";
        String index = "list_23_";
        StringBuffer buffer = new StringBuffer();
        for (int i = 1; i < 2; i++) {
            buffer.append("\r\n\r\n\r\n第" + i + "页抓取开始——只抓取前五页\r\n\r\n\r\n");
            if (i == 1) {
                buffer.append(u.getInfoFromUrl(url, ""));
            } else {
                buffer.append(u.getInfoFromUrl(urls, index + i + ".html"));
            }
        }
        System.out.println(buffer);
        // FileWrite fw = new FileWrite();
        // String fileName = "c:/movieslist.txt";
        // try {
        //
        // fw.writeInfoFile_new(fileName, buffer);
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        u.showFace();
    }

    public StringBuffer getInfoFromUrl(String urlAddress, String htmlAddress) {
        UrlParse up = new UrlParse();
        HTMLParser hp = new HTMLParser();
        WriteHTML writeHtml = new WriteHTML();
        String html = up.getHtmlByUrl(urlAddress + htmlAddress);
        ArrayList<String> urls = hp.getAllPageUrl(html);
        int i = 0;

        StringBuffer buffer = new StringBuffer();// 存储内容信息

        for (String url : urls) {
            buffer.append(url + "\r\n");
            String htmlz = up.getHtmlByUrl(url);
            // System.out.println(hp.getName(htmlz) + "\n" + hp.getTel(htmlz));
            buffer.append(hp.getName(htmlz) + "\r\n");
            buffer.append(hp.getAddress(htmlz) + "\r\n");
            buffer.append("\r\n");
            i++;
        }

        // FileWrite fw = new FileWrite();
        // String fileName = "f:/movieslist.txt";
        // try {
        // fw.writeInfoFile_new(fileName , buffer);
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        return buffer;

    }

}
