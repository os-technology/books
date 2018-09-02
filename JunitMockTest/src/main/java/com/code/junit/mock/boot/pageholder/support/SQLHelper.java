package com.code.junit.mock.boot.pageholder.support;

import com.code.junit.mock.boot.pageholder.dialect.Dialect;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.transaction.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author code
 * @Title: SQLHelper
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/2上午10:10
 */
public class SQLHelper {

    /**
     * 查询总纪录数
     *
     * @param mappedStatement
     *            mapped
     * @param parameterObject
     *            参数
     * @param boundSql
     *            boundSql
     * @param dialect
     *            database dialect
     * @return 总记录数
     * @throws SQLException
     *             sql查询错误
     */
    public static int getCount(final MappedStatement mappedStatement,
                               final Transaction transaction, final Object parameterObject,
                               final BoundSql boundSql, Dialect dialect) throws SQLException {

        final String count_sql = dialect.getCountSQL();
//        logger.debug("Total count SQL [{}] ", count_sql);
//        logger.debug("Total count Parameters: {} ", parameterObject);

        Connection connection = transaction.getConnection();
        PreparedStatement countStmt = connection.prepareStatement(count_sql);
        DefaultParameterHandler handler = new DefaultParameterHandler(
                mappedStatement, parameterObject, boundSql);
        handler.setParameters(countStmt);

        ResultSet rs = countStmt.executeQuery();
        int count = 0;
        if (rs.next()) {
            count = rs.getInt(1);
        }
//        logger.debug("Total count: {}", count);
        return count;

    }
}
