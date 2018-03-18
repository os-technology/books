package org.office.poi;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;

public class TempTest {
	/**
	 * 
	 * word table的创建
	 * 
	 * @throws Exception
	 * @Author Yu Jinshui
	 * @createTime 2014年12月18日 下午3:29:42
	 */
	public void testWriteTable() throws Exception {
		XWPFDocument doc = new XWPFDocument();
		// 创建一个5行5列的表格
		XWPFTable table = doc.createTable(5, 5);
		// 这里增加的列原本初始化创建的那5行在通过getTableCells()方法获取时获取不到，但通过row新增的就可以。
		// table.addNewCol(); //给表格增加一列，变成6列
		table.createRow(); // 给表格新增一行，变成6行
		List<XWPFTableRow> rows = table.getRows();
		// 表格属性
		CTTblPr tablePr = table.getCTTbl().addNewTblPr();
		// 表格宽度
		CTTblWidth width = tablePr.addNewTblW();
		width.setW(BigInteger.valueOf(8000));
		XWPFTableRow row;
		List<XWPFTableCell> cells;
		XWPFTableCell cell;
		int rowSize = rows.size();
		int cellSize;
		for (int i = 0; i < rowSize; i++) {
			row = rows.get(i);
			// 新增单元格
			row.addNewTableCell();
			// 设置行的高度
			row.setHeight(500);
			// 行属性
			// CTTrPr rowPr = row.getCtRow().addNewTrPr();
			// 这种方式是可以获取到新增的cell的。
			// List<CTTc> list = row.getCtRow().getTcList();
			cells = row.getTableCells();
			cellSize = cells.size();
			for (int j = 0; j < cellSize; j++) {
				cell = cells.get(j);
				if ((i + j) % 2 == 0) {
					// 设置单元格的颜色
					cell.setColor("ff0000"); // 红色
				} else {
					cell.setColor("0000ff"); // 蓝色
				}
				// 单元格属性
				CTTcPr cellPr = cell.getCTTc().addNewTcPr();
				cellPr.addNewVAlign().setVal(STVerticalJc.CENTER);
				if (j == 3) {
					// 设置宽度
					cellPr.addNewTcW().setW(BigInteger.valueOf(3000));
				}
				cell.setText(i + ", " + j);
			}
		}
		// 文件不存在时会自动创建
		OutputStream os = new FileOutputStream("table.docx");
		// 写入文件
		doc.write(os);
		os.close();
	}

	public static void main(String[] args) {
		TempTest t = new TempTest();
		try {
			t.testWriteTable();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
