package com.notes.boot.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 自定义 mybatis参数校验
 *使用方法  @com.code.junit.mock.boot.util.MybatisParamsUtil#
 * @author code
 * @Title: MybatisParamsUtil
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/3/26上午9:49
 */
public class MybatisParamsUtil {

    public static boolean isNotEmpty(CharSequence cs){
        boolean flag = StringUtils.isNotEmpty(cs);
//        if (!flag){
//            throw new NullPointerException("请求参数不能为空");
//        }
        return flag;
    }
}
