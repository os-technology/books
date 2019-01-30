package org.database.createbean;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 为了链接oracle数据库 生成表对应的javabean
 * 
 * @author Administrator
 *
 */
public class JavaBeanUtils implements Serializable {
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
		static final String DATABASE_URL = "jdbc:mysql://localhost/plusoft_test?useUnicode=true&characterEncoding=GBK";
		static final String DATABASE_USER = "root";
		static final String DATABASE_PASSWORD = "1234";
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

	public static List<Map> getOracleTable(String Table) throws SQLException {
		getOracleConnection();
		List<Map> list = new ArrayList<Map>();
		try {
			DatabaseMetaData m_DBMetaData = con.getMetaData();
			// getColumns(java.lang.String catalog, java.lang.String
			// schema,java.lang.String table, java.lang.String col)
			ResultSet colrs = m_DBMetaData.getColumns(null, Ora.DATABASE_USER.toUpperCase(), Table.toUpperCase(), "%");
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
	public static String oracleSqlType2JavaType(String sqlType, int size, int scale) {
		if (sqlType.equals("integer")) {
			return "Integer";
		} else if (sqlType.equals("long")) {
			return "Long";
		} else if (sqlType.equals("float") || sqlType.equals("float precision") || sqlType.equals("double")
				|| sqlType.equals("double precision")) {
			return "BigDecimal";
		} else if (sqlType.equals("number") || sqlType.equals("decimal") || sqlType.equals("numeric")
				|| sqlType.equals("real")) {
			return scale == 0 ? (size < 10 ? "Integer" : "Long") : "BigDecimal";
		} else if (sqlType.equals("varchar") || sqlType.equals("varchar2") || sqlType.equals("char")
				|| sqlType.equals("nvarchar") || sqlType.equals("nchar")) {
			return "String";
		} else if (sqlType.equals("datetime") || sqlType.equals("date") || sqlType.equals("timestamp")) {
			return "Date";
		}
		return "String";
	}

	public static String getItems(List<Map> map, String tablename) {
		// 记得转化成小写
		StringBuffer sb = new StringBuffer();
		sb.append("package com.databi.bean;");
		sb.append("\r\n");
		sb.append("import java.util.Date;\r\n");
		sb.append("/** \r\n " + " *  \r\n" + " * @author lsp  \r\n" + " *\r\n" + "*/\r\n");
		sb.append("\r\n");
		sb.append("public class " + tableNameToClass(tablename.toLowerCase())
				+ "  implements java.io.Serializable  {\r\n");
		// 得到私有属性
		for (Map map0 : map) {
			String columnname = map0.get("columnName").toString();
			String columntype = map0.get("columnType").toString();
			String columnsize = map0.get("datasize").toString();
			String remarks = map0.get("remarks") == null ? "" : map0.get("remarks").toString();
			String javaType = oracleSqlType2JavaType(columntype.toLowerCase(), Integer.parseInt(columnsize), 0);
			String temp = "\t/***/private " + javaType + " "
					+ getLowerOne(cleanUnderLineAndUpperAlpha(columnname.toLowerCase())) + "; //" + remarks + "\r\n";
			sb.append(temp);
		}
		// 得到getter和setter
		for (Map map0 : map) {
			String columnname = map0.get("columnName").toString();
			String columntype = map0.get("columnType").toString();
			String columnsize = map0.get("datasize").toString();
			String javaType = oracleSqlType2JavaType(columntype.toLowerCase(), Integer.parseInt(columnsize), 0);
			String temp = "\tpublic " + javaType + " " + "get" + cleanUnderLineAndUpperAlpha(columnname.toLowerCase())
					+ "(){\r\n";
			String temp1 = "\t\treturn " + getLowerOne(cleanUnderLineAndUpperAlpha(columnname.toLowerCase())) + ";\r\n";
			String temp2 = "\t}\r\n";
			sb.append(temp + temp1 + temp2);
			temp = "\tpublic void " + "set" + cleanUnderLineAndUpperAlpha(columnname.toLowerCase()) + "(" + javaType
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
	public static String getUpperAlpha(String str) {
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
				sb.append(getUpperAlpha(word));
		}

		return sb.toString();
	}

	public static String tableNameToClass(String tableName) {
		return cleanUnderLineAndUpperAlpha(tableName);
	}

	/***********/

	public static void main(String[] args) throws IOException {
		// JavaBeanUtils util = new JavaBeanUtils();
		// String result = util.tableNameToClass("t_pay_batch");
		// System.out.println(result);
		// String a = util.getLowerOne("TBat");
		// System.out.println(a);
		String tables = "t_pay_refund_offer_data";
		// createJavaBean(tables);
		System.out.println("执行完成");

	}

	private void printsql() {
		String Table = "t_pay_refund_offer_data";
		String sql = "select " + "         comments as \"Name\"," + "         a.column_name \"Code\","
				+ "         a.DATA_TYPE as \"DataType\"," + "         b.comments as \"Comment\","
				+ "         decode(c.column_name,null,'FALSE','TRUE') as \"Primary\","
				+ "         decode(a.NULLABLE,'N','TRUE','Y','FALSE','') as \"Mandatory\"," + "         '' \"sequence\""
				+ "   from " + "       all_tab_columns a, " + "       all_col_comments b," + "       ("
				+ "        select a.constraint_name, a.column_name"
				+ "          from user_cons_columns a, user_constraints b"
				+ "         where a.constraint_name = b.constraint_name" + "               and b.constraint_type = 'P'"
				+ "               and a.table_name = '" + Table + "'" + "       ) c" + "   where "
				+ "     a.Table_Name=b.table_Name " + "     and a.column_name=b.column_name" + "     and a.Table_Name='"
				+ Table + "'" + "     and a.owner=b.owner " +
				// " and a.owner='"+Owner+"'"+
				"     and a.COLUMN_NAME = c.column_name(+)" + "  order by a.COLUMN_ID";
		System.out.println(sql);
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
				String name = tableNameToClass(tables);
				List<Map> map = getOracleTable(string);
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

	public String propertyToColumnName(String propertyName) {
		return splitAndDown(propertyName);
	}

	@Deprecated
	private String splitAndDown(String original) {
		if (original == null) {
			return null;
		}
		String[] words = original.split("(?=[A-Z])");
		StringBuffer sb = new StringBuffer();
		for (String word : words) {
			if (word.length() > 0)
				sb.append(word.toLowerCase() + "_");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}