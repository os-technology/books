package org.office.poi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WordWrite {

	/**
	 * 
	 * 创建docx文件
	 * 
	 * @param file
	 *            File
	 * @param contents
	 * @Author Yu Jinshui
	 * @createTime 2014年12月18日 上午10:46:07
	 */
	private void createWord(File file, StringBuffer contents) {
		XWPFDocument docx = new XWPFDocument();

		XWPFParagraph ph = docx.createParagraph();// 创建段落
		ph.setAlignment(ParagraphAlignment.CENTER);// 设置居中

		// ph.setBorderBottom(Borders.DOUBLE);// 设置边框线
		// ph.setBorderTop(Borders.DOUBLE);// 设置边框线
		// ph.setBorderLeft(Borders.DOUBLE);// 设置边框线
		// ph.setBorderRight(Borders.DOUBLE);// 设置边框线

		ph.setVerticalAlignment(TextAlignment.TOP);// ?

		// XWPFRun对象定义了文本区域的一组公共的属性
		XWPFRun run = ph.createRun();// ?
		run.setBold(true);
		run.setText("The first info");
		run.setBold(true);
		run.setFontFamily("宋体");
		run.setFontSize(30);
		// run.setStrike(true);//中划线
		// run.setUnderline(UnderlinePatterns.DOT_DOT_DASH);//去掉文字下方的线
		run.setTextPosition(0);// 100
		/********************/
		XWPFParagraph ph2 = docx.createParagraph();

		// XWPFRun对象定义了文本区域的一组公共的属性
		ph2.setWordWrap(true);
		XWPFRun run2 = ph2.createRun();// ?
		// File filePic = new File("f:/111.jpg");
		// InputStream pictureData = new FileInputStream(filePic );
		// int pictureType= Document.PICTURE_TYPE_JPEG;
		// String filename = "f:/111.jpg";
		// int width = 720;
		// int height = 960;
		// run2.addPicture(pictureData, pictureType, filename, width, height);
		run2.setFontFamily("宋体");
		run2.setItalic(true);// 斜体
		run2.setTextPosition(0);// 100
		run2.setText(contents.toString());
		XWPFParagraph ph3 = docx.createParagraph();
		ph3.setWordWrap(true);
		ph3.setPageBreak(true);// 在新的一页开始
		XWPFRun run3 = ph3.createRun();
		// run3.setTextPosition(0);
		// run3.setFontFamily("宋体");
		run3.setText("下一页开头：To be, or not to be: that is the question: "
				+ "Whether 'tis nobler in the mind to suffer "
				+ "The slings and arrows of outrageous fortune, "
				+ "Or to take arms against a sea of troubles, "
				+ "And by opposing end them? To die: to sleep; ");
		try {
			FileOutputStream out = new FileOutputStream(file);
			docx.write(out);
			out.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		WordWrite w = new WordWrite();
		String name = "example1.docx";
		File file = new File(name);
		StringBuffer contents = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			contents.append("hello" + i);
		}
		w.createWord(file, contents);
		System.out.println(name + " is ok!");
	}

}
