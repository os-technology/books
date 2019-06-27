package com.notes.boot.dict.dao.provider;

import com.notes.boot.dict.beans.User;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

/**
 * @author code
 * @Title: UserMapperProvider
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/2下午1:49
 */
public class UserMapperProvider {

    public String addUser(User user) {

        if (user == null) {
            return null;
        }
        String sql = new SQL() {{
            INSERT_INTO("user");

            if (StringUtils.hasText(user.getCompanyId())) {
                VALUES("company_id", "#{companyId}");
            }
            if (StringUtils.hasText(user.getUsername())) {
                VALUES("username", "#{username}");
            }
            if (user.getCreateTime() != null) {
                VALUES("create_time", "#{createTime}");
            }
            if (user.getUpdateTime() != null) {
                VALUES("update_time", "#{updateTime}");
            }

        }}.toString();

        return sql;
    }

    /**
     * 多表关联查询
     *
     * @return
     */
    public String getUserDataList() {
        String sql = new SQL() {
            {
                SELECT("u.id as userId,username,c.company_name as companyName,c.address,u.create_time as userCreateTime");
                FROM("user u");
                FROM("company c");
                WHERE("u.company_id=c.id");
                ORDER_BY("u.create_time desc");
            }
        }.toString();

        return sql;
    }


    public String selectUserByCondition(User user) {

        if (user == null) {
            return null;
        }
        String sql = new SQL() {{
            SELECT("*");
            FROM("user");

            if (StringUtils.hasText(user.getCompanyId())) {
                WHERE("userid=#{companyId}");
            }
            if (user.getId() != null) {
                WHERE("id=#{id}");
            }

        }}.toString();

        return null;
    }
}
