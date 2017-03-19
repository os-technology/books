package org.office.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static void main(String[] args) throws Exception {

		System.out.println("begin");

		String excelPath = "F:/a.xlsx";
		File file = new File(excelPath);

		InputStream fis = new FileInputStream(file);

		POIFSFileSystem pfs = new POIFSFileSystem(fis);
		EncryptionInfo encInfo = new EncryptionInfo(pfs);
		Decryptor decryptor = Decryptor.getInstance(encInfo);
		decryptor.verifyPassword("111");
		XSSFWorkbook workbook = new XSSFWorkbook(decryptor.getDataStream(pfs));

		Sheet sheet = workbook.getSheetAt(0);
		int startRowNum = sheet.getFirstRowNum();
		int endRowNum = sheet.getLastRowNum();
		for (int rowNum = startRowNum; rowNum <= endRowNum; rowNum++) {
			Row row = sheet.getRow(rowNum);
			if (row == null)
				continue;
			int startCellNum = row.getFirstCellNum();
			int endCellNum = row.getLastCellNum();
			for (int cellNum = startCellNum; cellNum < endCellNum; cellNum++) {
				Cell cell = row.getCell(cellNum);
				if (cell == null)
					continue;
				int type = cell.getCellType();
				switch (type) {
				case Cell.CELL_TYPE_NUMERIC:// 数值、日期类型
					double d = cell.getNumericCellValue();
					if (HSSFDateUtil.isCellDateFormatted(cell)) {// 日期类型
						Date date = cell.getDateCellValue();
						Date date1 = HSSFDateUtil.getJavaDate(d);
						System.out.print(" "
								+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
										.format(date) + " ");
					} else {// 数值类型
						System.out.print(" " + d + " ");
					}
					break;
				case Cell.CELL_TYPE_BLANK:// 空白单元格
					System.out.print(" null ");
					break;
				case Cell.CELL_TYPE_STRING:// 字符类型
					System.out.print(" " + cell.getStringCellValue() + " ");
					break;
				case Cell.CELL_TYPE_BOOLEAN:// 布尔类型
					System.out.println(cell.getBooleanCellValue());
					break;
				case HSSFCell.CELL_TYPE_ERROR: // 故障
					System.err.println("非法字符");// 非法字符;
					break;
				default:
					System.err.println("error");// 未知类型
					break;
				}
			}
			System.out.println();
		}
		System.out.println("end");
	}
}