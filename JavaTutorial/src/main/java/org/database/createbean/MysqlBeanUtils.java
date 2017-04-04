package org.database.createbean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.database.createbean.JavaBeanUtils.MySql;
import org.database.createbean.JavaBeanUtils.Ora;

/**
 * 
 * MySQL数据库Javabean创建
 * 
 * @author yujinshui
 * @createTime 2017年4月4日 上午10:07:22
 */
public class MysqlBeanUtils {
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private static Connection con = null;
	private CallableStatement cst = null;

	static class Ora {
		static final String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
		static final String DATABASE_URL = "jdbc:oracle:thin:@172.30.21.43:1521:orcl";
		static final String DATABASE_USER = "lxjr_main";
		static final String DATABASE_PASSWORD = "q1w2e3r4";
		static final String DATABASE_TABLE = "t_pay_batch"; // 需要生成的表名
	}

	static class MySql {
		static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
		static final String DATABASE_URL = "jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf-8";
		static final String DATABASE_USER = "root";
		static final String DATABASE_PASSWORD = "root";
	}

	public static Connection getOracleConnection() {
		try {
			Class.forName(Ora.DRIVER_CLASS);
			con = DriverManager.getConnection(Ora.DATABASE_URL, Ora.DATABASE_USER, Ora.DATABASE_PASSWORD);
			return con;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return con;
	}

	public static Connection getMySqlConnection() {
		try {
			Class.forName(MySql.DRIVER_CLASS);
			con = DriverManager.getConnection(MySql.DATABASE_URL, MySql.DATABASE_USER, MySql.DATABASE_PASSWORD);
			return con;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}

	public static List<Map> getMysqlTable(String Table) throws SQLException {
		getMySqlConnection();
		List<Map> list = new ArrayList<Map>();
		try {
			DatabaseMetaData m_DBMetaData = con.getMetaData();
			// getColumns(java.lang.String catalog, java.lang.String
			// schema,java.lang.String table, java.lang.String col)
			ResultSet colrs = m_DBMetaData.getColumns(null, MySql.DATABASE_USER.toUpperCase(), Table.toUpperCase(),
					"%");
			while (colrs.next()) {

				Map map = new HashMap();
				String columnName = colrs.getString("COLUMN_NAME");
				String columnType = colrs.getString("TYPE_NAME");
				int datasize = colrs.getInt("COLUMN_SIZE");
				int digits = colrs.getInt("DECIMAL_DIGITS");
				int nullable = colrs.getInt("NULLABLE");
				String remarks = colrs.getString("REMARKS");

				// System.out.println(columnName+" "+columnType+" "+datasize+"
				// "+digits+" "+ nullable);
				map.put("columnName", columnName);
				map.put("columnType", columnType);
				map.put("datasize", datasize);
				map.put("remarks", remarks);
				list.add(map);

			}
			while (colrs.next()) {
				System.out.print("列名：" + colrs.getString("COLUMN_NAME"));
				System.out.print("  数据类型是：" + colrs.getString("DATA_TYPE"));
				System.out.print("  类型名称是：" + colrs.getString("TYPE_NAME"));
				System.out.print("  列大小是：" + colrs.getString("COLUMN_SIZE"));
				System.out.println("  注释是：" + colrs.getString("REMARKS"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return list;
	}

	/**
	 * 把Oracle字段类型 转化为 java类型
	 * 
	 * @param sqlType
	 *            字段类型
	 * @param size
	 *            字段大小
	 * @param scale
	 *            默认=0
	 * @return
	 */
	public static String mySqlType2JavaType(String sqlType, int size, int scale) {
		if (sqlType.equals("int") || sqlType.equals("tinyint")) {
			return "Integer";
		} else if (sqlType.equals("long") || sqlType.equals("bigint")) {
			return "Long";
		} else if (sqlType.equals("double") || sqlType.equals("float")) {
			return "Double";
		} else if (sqlType.equals("decimal")) {
			return "BigDecimal";
		} else if (sqlType.equals("varchar") || sqlType.equals("charinfo") || sqlType.equals("longtext")
				|| sqlType.equals("nvarchar") || sqlType.equals("mediumtext") || sqlType.equals("text")
				|| sqlType.equals("tinytext")) {
			return "String";
		} else if (sqlType.equals("enum")) {
			return "Enum";
		} else if (sqlType.equals("datetime") || sqlType.equals("date") || sqlType.equals("time")
				|| sqlType.equals("year") || sqlType.equals("timestamp")) {
			return "Date";
		} else if (sqlType.equals("blob") || sqlType.equals("binary") || sqlType.equals("blobsize")
				|| sqlType.equals("longblob") || sqlType.equals("mediumblob") || sqlType.equals("tinyblob")
				|| sqlType.equals("geometry") || sqlType.equals("varbinary")) {
			return "byte[]";
		} else if (sqlType.equals("json") || sqlType.equals("set")) {
			return "Character";
		}
		return "String";
	}

	public static String getItems(List<Map> map, String tablename) {
		// 记得转化成小写
		StringBuffer sb = new StringBuffer();
		sb.append("package com.databi.bean;");
		sb.append("\r\n");
		sb.append("import java.util.Date;\r\n");
		sb.append("import java.math.BigDecimal;\r\n");
		sb.append("import java.io.Serializable;\r\n");
		sb.append("/** \r\n " + " *  \r\n" + " * @author lsp  \r\n" + " *\r\n" + "*/\r\n");
		sb.append("\r\n");
		sb.append("public class " + tableNameToClass(tablename.toLowerCase()) + "  implements Serializable  {\r\n");
		// 得到私有属性
		for (Map map0 : map) {
			String columnname = map0.get("columnName").toString();
			String columntype = map0.get("columnType").toString();
			String columnsize = map0.get("datasize").toString();
			String remarks = map0.get("remarks") == null ? "" : map0.get("remarks").toString();
			String javaType = mySqlType2JavaType(columntype.toLowerCase(), Integer.parseInt(columnsize), 0);
			String temp = "\t/**" + remarks + "*/\r\n"//
					+ "private " + javaType + " " + getLowerOne(cleanUnderLineAndUpperAlpha(columnname.toLowerCase()))
					+ "; //" + remarks + "\r\n";
			sb.append(temp);
		}
		// 得到getter和setter
		for (Map map0 : map) {
			String columnname = map0.get("columnName").toString();
			String columntype = map0.get("columnType").toString();
			String columnsize = map0.get("datasize").toString();
			String remarks = map0.get("remarks") == null ? "" : map0.get("remarks").toString();
			String javaType = mySqlType2JavaType(columntype.toLowerCase(), Integer.parseInt(columnsize), 0);
			String temp = "\t/**" + remarks + "*/\r\n"//
					+ "public " + javaType + " " + "get" + cleanUnderLineAndUpperAlpha(columnname.toLowerCase())
					+ "(){\r\n";
			String temp1 = "\t\treturn " + getLowerOne(cleanUnderLineAndUpperAlpha(columnname.toLowerCase())) + ";\r\n";
			String temp2 = "\t}\r\n";
			sb.append(temp + temp1 + temp2);
			temp = "\t/**" + remarks + "*/\r\n"//
					+ "public void " + "set" + cleanUnderLineAndUpperAlpha(columnname.toLowerCase()) + "(" + javaType
					+ " " + getLowerOne(cleanUnderLineAndUpperAlpha(columnname.toLowerCase())) + "){\r\n";
			temp1 = "\t\tthis." + getLowerOne(cleanUnderLineAndUpperAlpha(columnname.toLowerCase())) + " = "
					+ getLowerOne(cleanUnderLineAndUpperAlpha(columnname.toLowerCase())) + ";\r\n";
			temp2 = "\t}\r\n";
			sb.append(temp + temp1 + temp2);
		}
		sb.append("}");
		return sb.toString();

	}

	/**
	 * 把输入字符串的首字母改成大写
	 * 
	 * @param str
	 * @return
	 */
	public static String getUpperOne(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);
	}

	public static String getLowerOne(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'A' && ch[0] <= 'Z') {
			ch[0] = (char) (ch[0] + 32);
		}
		return new String(ch);
	}

	/***********/
	public static String getFirstUpperAlpha(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);
	}

	private static String cleanUnderLineAndUpperAlpha(String input) {
		if (input == null) {
			return null;
		}
		String[] words = input.split("_");
		StringBuffer sb = new StringBuffer();
		for (String word : words) {
			if (word.length() > 0)
				sb.append(getFirstUpperAlpha(word));
		}

		return sb.toString();
	}

	public static String tableNameToClass(String tableName) {
		return cleanUnderLineAndUpperAlpha(tableName);
	}

	/**
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @Author yujinshui
	 * @createTime 2017年4月1日 上午11:03:22
	 */
	private static void createJavaBean(String tables) throws IOException, FileNotFoundException {
		// JavaBeanUtils.sysoutOracleTCloumns("pexam_items_title", "his_yhkf");
		try {

			String[] arr = tables.split(",");
			for (String string : arr) {
				String name = tableNameToClass(string);
				List<Map> map = getMysqlTable(string);
				String a = getItems(map, string);
				File file = new File("/Users/yujinshui/Desktop/packBean/" + name + ".java");
				file.delete();
				if (!file.exists()) {
					file.createNewFile();
				}

				FileOutputStream fos = new FileOutputStream(file, true);// true表示在文件末尾追加
				fos.write(a.getBytes());
				fos.close();// 流要及时关闭
			}
			System.out.println("生成java完成");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			createJavaBean("tableType,t_face");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
