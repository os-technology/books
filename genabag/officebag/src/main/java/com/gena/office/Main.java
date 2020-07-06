package com.gena.office;

/**
 * @author code
 * @Title: Main
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2020/7/615:36
 */
public class Main {
    public static void main(String[] args) {

        String res = new PdfToWord().pdftoword("C:\\Users\\zyxf\\Desktop\\devops操作手.pdf");
        System.out.println(res);
    }
}
