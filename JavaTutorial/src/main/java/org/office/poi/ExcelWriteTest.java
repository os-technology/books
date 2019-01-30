package org.office.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.Color;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * 
 * excel写入功能
 */
public class ExcelWriteTest {

	/**
	 * 
	 * @deprecated
	 */
	private void createXSSFWorkbook(File file) {
		XSSFWorkbook hwb = new XSSFWorkbook();// 用于表示高和低层次Excel文件格式的类
		// HSSFWorkbook hssf = new HSSFWorkbook();//用于Excel文件中的.xls格式
		try {
			FileOutputStream fos = new FileOutputStream(file);

			hwb.write(fos);
			fos.close();
			System.out.println("Excel_1.xlsx  successfully.");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @deprecated
	 */
	private void openXSSFWorkbook(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook xssf = new XSSFWorkbook(fis);

			if (file.isFile() && file.exists()) {
				System.out.println("Excel_1.xlsx file open successfully.");
			} else {
				System.out.println("Error to open Excel_1.xlsx file.");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean excelDemo_1(File file, List<Object[]> contents) {

		Workbook xssf = new XSSFWorkbook();
		Sheet sheet = xssf.createSheet("test1");
		Row row;

		// String类似于索引位置，保证数据的顺序一致性
		Map<Integer, Object[]> maplist = new TreeMap<Integer, Object[]>();
		for (int i = 0; i < contents.size(); i++) {
			maplist.put(i, contents.get(i));
		}

		Set<Integer> keyid = maplist.keySet();

		int rowid = 0;// TODO
		for (Integer key : keyid) {
			row = sheet.createRow(rowid++);
			Object[] objectArr = maplist.get(key);
			// int cellid = 0;
			for (int j = 0; j < objectArr.length; j++) {
				Cell cell = row.createCell(j); // row.createCell(cellid++);
				if (rowid == 1) {
					/******** 内容style设置 **********/
					XSSFCellStyle style = (XSSFCellStyle) xssf
							.createCellStyle();
					XSSFFont font = (XSSFFont) xssf.createFont();
					font.setFontName("宋体");
					font.setBoldweight(Font.BOLDWEIGHT_BOLD);
					Color fontcolor = Color.red;
					XSSFColor color = new XSSFColor(fontcolor);
					font.setColor(color);
					style.setFont(font);
					/******** 内容style设置 **********/
					cell.setCellStyle(style);
					cell.setCellValue((String) objectArr[j].toString());
				} else {
					cell.setCellValue(objectArr[j].toString());
				}
			}
		}

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			xssf.write(fos);
			fos.close();
			System.out.println("excel contents is successful");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	/**
	 * 
	 * 兼容xls,xlsx两种文件格式的创建
	 * 
	 * @return_type void
	 * @param file
	 *            File
	 * @param listSheetName
	 *            sheet名称集
	 * @param contents
	 *            文件内容【包含标题】
	 * @param password
	 *            文件密码
	 * @Author Yu Jinshui
	 * @createTime 2014年12月16日 下午3:29:15
	 * @since 0.2
	 */
	public void writeExcel_2(File file, List<Object> listSheetName,
			List<Object[]> contents, String password) {

		String info = Extension.getExtension(file);
		Workbook wb;
		if ("xls".equals(info)) {
			wb = new HSSFWorkbook();
		} else {
			wb = new XSSFWorkbook();

		}
		createSheetList(file, contents, wb, listSheetName);
		// 加密部分
		if (password != null && !"".equals(password)) {
			setPassWord(file.getName(), wb, password);
		}
	}

	/**
	 * 
	 * 创建sheet
	 ** 
	 * @param file
	 *            文件名称
	 * @param contents
	 *            数据内容
	 * @param wb
	 *            工作簿
	 * @param listSheetName
	 *            sheet名称集合
	 * @Author Yu Jinshui
	 * @createTime 2015年1月13日 上午9:30:08
	 */
	public void createSheetList(File file, List<Object[]> contents,
			Workbook wb, List<Object> listSheetName) {
		for (int i = 0; i < listSheetName.size(); i++) {
			Sheet sheet = wb.createSheet(listSheetName.get(i).toString());
			writeContent(file, contents, wb, sheet);
		}
	}

	/**
	 * 
	 * 内容写入
	 * 
	 * @param file
	 *            文件名称
	 * @param contents
	 *            数据内容
	 * @param password
	 *            excel密码
	 * @param wb
	 *            工作簿
	 * @param sheet
	 *            sheet参数
	 * @createTime 2015年1月13日 上午9:26:19
	 */
	public void writeContent(File file, List<Object[]> contents, Workbook wb,
			Sheet sheet) {
		Row row;
		Map<Integer, Object[]> maplist = new TreeMap<Integer, Object[]>();
		for (int i = 0; i < contents.size(); i++) {
			maplist.put(i, contents.get(i));
		}

		Set<Integer> keyid = maplist.keySet();
		int rowid = 0;
		for (Integer key : keyid) {
			row = sheet.createRow(rowid++);
			Object[] objectArr = maplist.get(key);
			for (int i = 0; i < objectArr.length; i++) {
				Cell cell = row.createCell(i);
				if (rowid == 1) {
					CellStyle style = wb.createCellStyle();
					Font font = wb.createFont();
					font.setColor(HSSFColor.RED.index);// 字体颜色
					font.setBoldweight(Font.BOLDWEIGHT_BOLD);// 粗体

					style.setFont(font);

					cell.setCellStyle(style);
					cell.setCellValue(objectArr[i].toString());
				} else {
					cell.setCellValue(objectArr[i].toString());
				}
			}
		}

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			wb.write(fos);
			fos.close();
			System.out.println("Excel write is OK!");
		} catch (FileNotFoundException e) {
			System.out.println("输出流创建错误");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * 得到文件扩展名
	 * 
	 * @param file
	 * @return
	 * @Author Yu Jinshui
	 * @createTime 2014年12月17日 下午1:56:01
	 * @since 0.3.0.0 {初始版本号}
	 */
	public String getResult(File file) {
		String info = file.getName().substring(
				file.getName().lastIndexOf(".") + 1);
		info = info.toLowerCase();
		return info;
	}

	/**
	 * 设置密码[仅限于xls文件格式]
	 * 
	 * @param filePath
	 * @param wb
	 * @param password
	 * @Author Yu Jinshui
	 * @createTime 2014年12月16日 下午9:10:47
	 * @since 0.3.0.0 {初始版本号}
	 */
	public void setPassWord(String filePath, Workbook wb, String password) {
		FileOutputStream fileOut = null;

		FileInputStream fileInputStream;
		POIFSFileSystem filesys;
		try {

			fileInputStream = new FileInputStream(filePath);
			filesys = new POIFSFileSystem(fileInputStream);
			wb = new HSSFWorkbook(filesys);
			((HSSFWorkbook) wb).writeProtectWorkbook(password, "user");// 给excel文件加密

			fileOut = new FileOutputStream(filePath);
			wb.write(fileOut);
			fileOut.close();
			if (fileOut != null) {
				try {
					fileOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public synchronized List<Object[]> getContents(Object[] header) {

		List<Object[]> list = new ArrayList<Object[]>();
		list.add(header);// title信息
		for (int i = 0; i < 4; i++) {
			Object[] e = { "璐璐" + i, "100" + i, "员工" + i,
					i % 3 == 1 ? "男" : "女" };
			list.add(e);
		}
		return list;
	}

	public static void main(String[] args) {
		ExcelWriteTest excel = new ExcelWriteTest();
		File file = new File("112.xlsx");
		Object[] e = { "姓名", "编号1", "职位", "性别" };// title
		List<Object> sheet = new ArrayList<Object>();
		sheet.add("888");
		excel.writeExcel_2(file, sheet, excel.getContents(e), null);

	}

}
