package com.spring.source.code.beans;

import com.log.LogPortal;
import org.junit.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * 单元测试基础类
 *
 * @author yuijnshui
 * @Title: BaseJunitTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/27下午3:40
 */

//@ImportResource({"classpath:disconfig.xml"})//引入disconf
//@ImportResource({"classpath:replaceMethodTest_disconf.xml"})//引入disconf
public class BaseJunitTest {
    @Before
    public void setLog() {//日志配置
        LogPortal.setLogModule("SpringFrameworkSourceCode");
        LogPortal.setLogLevel(LogPortal.LogLevel.INFO);
    }
}
