package com.code.junit.mock.boot.dict.dao.provider;

import com.code.junit.mock.boot.dict.beans.User;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author code
 * @Title: UserProvider
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/2下午1:49
 */
public class UserProvider {

    public String addUser(User user) {

        if (user == null) {
            return null;
        }
        String sql = new SQL() {{
            INSERT_INTO("user");
            if (StringUtils.hasText(user.getOrgid())) {
                VALUES("orgid","#{orgid}");
            }
            if (StringUtils.hasText(user.getUserid())) {
                VALUES("userid","#{userid}");
            }
            if (StringUtils.hasText(user.getUsername())){
                VALUES("username","#{username}");
            }
            if (user.getCreateTime()!=null){
                VALUES("create_time","#{createTime}");
            }
            if (user.getUpdateTime()!=null){
                VALUES("update_time","#{updateTime}");
            }

        }}.toString();

        return sql;
    }

    public String selectUserByCondition(User user) {

        if (user == null) {
            return null;
        }
        String sql = new SQL() {{
            SELECT("*");
            FROM("user");
            if (StringUtils.hasText(user.getOrgid())) {
                WHERE("orgid=#{orgid}");
            }
            if (StringUtils.hasText(user.getUserid())) {
                WHERE("userid=#{userid}");
            }
            if (user.getId() != null) {
                WHERE("id=#{id}");
            }

        }}.toString();

        return null;
    }
}
