package org.office.itext;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.rtf.RtfWriter2;

public class CreateItextWord {
	public void createWord(String filePath) {
		Document doc = new Document(PageSize.A4);// 创建文件并设置纸张大小

		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(filePath);
			RtfWriter2.getInstance(doc, outputStream);
			doc.open();
			Paragraph ph = new Paragraph();
			Font font = new Font();
			Paragraph p = new Paragraph("出口合同", new Font(Font.NORMAL, 18, Font.BOLDITALIC, new Color(0, 0, 0)));
			p.setAlignment(1);// TODO
			doc.add(p);

			ph.setFont(font);

			// 设置中文字体

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			doc.close();
		}
	}
	public static void main(String[] args) {
		CreateItextWord word = new CreateItextWord();
		word.createWord("/Users/yujinshui/Desktop/itext.doc");
	}
}
