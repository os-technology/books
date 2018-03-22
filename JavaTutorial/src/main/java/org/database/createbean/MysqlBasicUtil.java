package org.database.createbean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: MysqlBasicUtil
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/3/19下午4:51
 */

public class MysqlBasicUtil {

    private static Connection con = null;
    // 创建Statement对象
    private static Statement stsm;

    static class MySql {

        static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
        static final String DATABASE_URL = "jdbc:mysql://localhost/ds_0?useUnicode=true&characterEncoding=utf-8";
        static final String DATABASE_USER = "root";
        static final String DATABASE_PASSWORD = "root";
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
    /**
     * 三：释放资源，断开连接 参数列表：conn。stsm
     */

    public static void close(Connection conn, Statement stsm) {

        if (stsm != null) {
            try {
                stsm.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    public void executeSql() {
        getMySqlConnection();
        // 准备sql语句
        //String sql = "CREATE TABLE person(id INT PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR(10),sex VARCHAR(5),age INT,psot VARCHAR(10),email VARCHAR(20),phone INT)";

        String sql = "alter table user_part add partition(\n" +
                "partition user_4 values less than (UNIX_TIMESTAMP('2018-03-21'))\n" +
                ")";


        // 发送sql语句
        try {
            stsm = con.createStatement();
            int result = stsm.executeUpdate(sql);
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(con,stsm);
        }
    }

    public static void main(String[] args) {
        MysqlBasicUtil util = new MysqlBasicUtil();
        util.executeSql();
    }

}
