package org.utils;

import java.sql.*;
import java.io.*;

/**
 * 文件二进制方式写入数据库
 */
public class FileToSQLUtil {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        FileToSQLUtil its = new FileToSQLUtil();
        //将F:\\11.doc文件的二进制数据写入到数据库中
        its.writeDataToDB("F:\\11.doc");
        //将数据库中的二进制数据读入到D:\\123.doc文件中
        its.readDataFromDB("D:\\123.doc");
    }

    public void readDataFromDB(String fileName) throws ClassNotFoundException, SQLException, IOException {
        Connection con = this.getConnection();
        String sql = "select * from imageTable";
        PreparedStatement pstm = con.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        rs.next();
        byte[] bytes = rs.getBytes(1);
        this.writeFileToFileSystem(bytes, fileName);
        rs.close();
        pstm.close();
        con.close();
    }

    public void writeDataToDB(String fileName) throws ClassNotFoundException, SQLException, IOException {
        Connection con = this.getConnection();
        String sql = "insert into imageTable values(?)";
        PreparedStatement pstm = con.prepareStatement(sql);
        byte[] bytes = this.readFileFromFileSystem(fileName);
        pstm.setBytes(1, bytes);
        pstm.execute();
        pstm.close();
        con.close();
    }

    public byte[] readFileFromFileSystem(String fileName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        //获取文件的字节数
        int length = fis.available();
        //写入到字节数组
        byte[] bytes = new byte[length];
        fis.read(bytes);
        fis.close();
        return bytes;
    }

    public void writeFileToFileSystem(byte[] bytes, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        //将字节数组写入到文件中
        fos.write(bytes);
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
        return DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=MyTestDB", "sa", "");
    }
}

