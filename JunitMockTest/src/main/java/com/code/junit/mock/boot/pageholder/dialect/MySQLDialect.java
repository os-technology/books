package com.code.junit.mock.boot.pageholder.dialect;

import com.code.junit.mock.boot.pageholder.model.PageBounds;
import org.apache.ibatis.mapping.MappedStatement;

/**
 * @author code
 * @Title: MySQLDialect
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/2上午10:24
 */
public class MySQLDialect extends Dialect {
    public MySQLDialect(MappedStatement mappedStatement, Object parameterObject, PageBounds pageBounds) {
        super(mappedStatement, parameterObject, pageBounds);
    }


    protected String getLimitString(String sql, String offsetName, int offset,
                                    String limitName, int limit) {
        StringBuffer buffer = new StringBuffer(sql.length() + 20).append(sql);
        if (offset > 0) {
            buffer.append(" limit ?, ?");
            setPageParameter(offsetName, offset, Integer.class);
            setPageParameter(limitName, limit, Integer.class);
        } else {
            buffer.append(" limit ?");
            setPageParameter(limitName, limit, Integer.class);
        }
        return buffer.toString();
    }
}
