package org.office.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.fastjson.JSON;

/**
 * 
 * excel读取功能
 */
public class ExcelCreateSql {
	/**
	 * 
	 * excel 文件读取
	 * 
	 * @param file
	 * @param password
	 *            对于不需要密码访问的文件，需要进行判断
	 * @Author Yu Jinshui
	 * @createTime 2014年12月18日 下午3:28:11
	 */
	public List<List<Object[]>> readExcel(File file, String password) {

		Workbook wb = null;
		List<List<Object[]>> listInfo = null;
		try {
			wb = getWorkbook(file, password);
			listInfo = sheetList(wb);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}

		return listInfo;
	}
	/**
	 * 读取Excel，并按照自定义格式输出
	 * 
	 * @param file
	 * @param password
	 * @return
	 * @Author yujinshui
	 * @createTime 2017年4月5日 下午6:50:25
	 */
	public List<StringBuffer> readExcelContent(File file, String password) {

		Workbook wb = null;
		List<StringBuffer> listInfo = null;
		try {
			wb = getWorkbook(file, password);
			listInfo = sheetContentList(wb);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}

		return listInfo;
	}
	/**
	 * 
	 * 得到文件的Workbook
	 * 
	 * @param file
	 * @param password
	 * @return
	 * @throws IOException
	 * @throws GeneralSecurityException
	 * @Author Yu Jinshui
	 * @createTime 2015年1月13日 下午1:40:26
	 */
	public Workbook getWorkbook(File file, String password) throws IOException, GeneralSecurityException {
		String info = Extension.getExtension(file);
		InputStream fis = new FileInputStream(file);
		Workbook wb = null;
		if (password != null && !"".equals(password)) {// 有密码
			if ("xlsx".equals(info)) {
				POIFSFileSystem pfs = new POIFSFileSystem(fis);
				EncryptionInfo encInfo = new EncryptionInfo(pfs);

				Decryptor decryptor = Decryptor.getInstance(encInfo);
				decryptor.verifyPassword(password);
				wb = new XSSFWorkbook(decryptor.getDataStream(pfs));
			} else {
				Biff8EncryptionKey.setCurrentUserPassword(password);
				try {
					wb = WorkbookFactory.create(fis);
				} catch (InvalidFormatException e) {
					e.printStackTrace();
				}

			}
		} else {// 无密码
			try {
				wb = WorkbookFactory.create(fis);
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			}
		}

		return wb;
	}

	/**
	 * 
	 * 返回sheet名称集(List<Object>)
	 * 
	 * @param file
	 * @param password
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2015年1月13日 下午1:50:33
	 */
	public List<Object> getSheetNames(File file, String password) {
		Workbook wb = null;
		List<Object> sheetList = new ArrayList<Object>();
		try {
			wb = getWorkbook(file, password);
		} catch (IOException | GeneralSecurityException e) {
			e.printStackTrace();
		}

		int sheetCount = wb.getNumberOfSheets();
		for (int i = 0; i < sheetCount; i++) {
			sheetList.add(wb.getSheetName(i));
		}

		return sheetList;
	}

	/**
	 * 
	 * sheet数遍历[返回内容信息]
	 * 
	 * @return_type List<List<Object[]>>
	 * @param wb
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2015年1月13日 下午1:41:26
	 */
	public List<List<Object[]>> sheetList(Workbook wb) {

		List<List<Object[]>> listInfo = new ArrayList<List<Object[]>>();

		int sheetCount = wb.getNumberOfSheets();// 得到sheet表的个数
		for (int i = 0; i < sheetCount; i++) {

			Sheet sheet = wb.getSheetAt(i);
			System.out.println("**********************************" + sheet.getSheetName()
					+ "************************************");
			List<Object[]> contents = outputContentList(sheet);
			listInfo.add(contents);

			System.out.println("********************end*************************");
		}
		return listInfo;

	}
	public List<StringBuffer> sheetContentList(Workbook wb) {

		List<StringBuffer> listInfo = new ArrayList<>();

		int sheetCount = wb.getNumberOfSheets();// 得到sheet表的个数
		for (int i = 0; i < sheetCount; i++) {

			Sheet sheet = wb.getSheetAt(i);
			System.out.println("**********************************" + sheet.getSheetName()
					+ "************************************");
			 StringBuffer contents = outputPointContent(sheet);
			listInfo.add(contents);

			System.out.println("********************end*************************");
		}
		return listInfo;

	}
	/**
	 * 
	 * 内容输出部分
	 * 
	 * @param sheet
	 * @createTime 2015年1月13日 上午9:06:17
	 */
	public StringBuffer outputContent(Sheet sheet) {
		StringBuffer buffer = new StringBuffer();
		Iterator<Row> rator = sheet.iterator();
		while (rator.hasNext()) {
			Row row = rator.next();
			Iterator<Cell> rowCell = row.cellIterator();
			while (rowCell.hasNext()) {
				Cell cell = rowCell.next();
				String infoValue = getValue(cell);
				buffer.append(infoValue + " ");
			}
			buffer.append("\r\n");
		}
		System.out.println(buffer.toString());

		return buffer;
	}

	/**
	 * 
	 * 内容返回----List<Object[]>格式
	 * 
	 * @param sheet
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2015年1月13日 下午1:42:40
	 */
	public List<Object[]> outputContentList(Sheet sheet) {

		List<Object[]> contents = new ArrayList<Object[]>();
		int flag = 0;
		Iterator<Row> rator = sheet.iterator();
		System.out.println("行数：" + sheet.getLastRowNum() + 1);
		while (rator.hasNext()) {
			Row row = rator.next();
			Iterator<Cell> rowCell = row.cellIterator();
			int colNum = sheet.getRow(flag).getLastCellNum();// 返回带空列的列数
			Object[] cont = new Object[colNum];
			int col = 0;
			while (rowCell.hasNext()) {
				Cell cell = rowCell.next();
				String infoValue = getValue(cell);
				cont[col] = infoValue;
				col++;
			}
			contents.add(cont);
			flag++;
		}
		return contents;
	}
	/**
	 * 输出指定格式内容，自定义格式
	 * 
	 * @param sheet
	 * @return
	 * @Author yujinshui
	 * @createTime 2017年4月5日 下午6:46:18
	 */
	public StringBuffer outputPointContent(Sheet sheet) {

		int flag = 0;
		StringBuffer buffer = new StringBuffer();
		Iterator<Row> rator = sheet.iterator();
		System.out.println("行数：" + sheet.getLastRowNum() + 1);
		while (rator.hasNext()) {
			Row row = rator.next();
			Iterator<Cell> rowCell = row.cellIterator();
			int col = 0;
			buffer.append("insert into BANK_BATCH_CODE (ID,BANK_NAME,BANK_BATCH_CODE) values(SEQ_BANK_BATCH_CODE.NEXTVAL");
			while (rowCell.hasNext()) {
				Cell cell = rowCell.next();
				String infoValue = getValue(cell);
				buffer.append(",'" + infoValue + "'");
				col++;
			}
			buffer.append(");\r\n");
			flag++;
		}
		return buffer;
	}

	private String getValue(Cell cell) {
		String value = "";

		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_BLANK:
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			value = cell.getBooleanCellValue() + "";
			break;
		case Cell.CELL_TYPE_ERROR:
			value = "[未知类型数据或非法字符]";
			break;
		case Cell.CELL_TYPE_FORMULA:
			value = cell.getNumericCellValue() + "";
			break;
		case Cell.CELL_TYPE_NUMERIC:
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				value = cell.getDateCellValue() + "";
			} else {
				value = cell.getNumericCellValue() + "";
			}
			break;
		case Cell.CELL_TYPE_STRING:
			value = cell.getStringCellValue();
			break;
		}
		return value;
	}

	public static void main(String[] args) {
		ExcelCreateSql excelRead = new ExcelCreateSql();

		ExcelWriteTest we = new ExcelWriteTest();

		// String fileName = "f:/电话表20140703更新.xls";
		String fileName = "/Users/yujinshui/Desktop/bank_code.xlsx";

		File file = new File(fileName);// Excel_1.xlsx
		String password = "";
		 List<StringBuffer> info = excelRead.readExcelContent(file, password);
		System.out.println(info);
		// List<Object> sheetlist = excelRead.getSheetNames(file, password);

		// String fileName2 = "f:/writeInfo.xls";
		//
		// File file2 = new File(fileName2);
		//
		// for (int i = 0; i < info.size(); i++) {
		// we.writeExcel_2(file2, sheetlist, info.get(i), "");
		// }
	}
}
