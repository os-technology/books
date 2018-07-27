package com.spring.source.code.beans.ch2;

import com.log.LogPortal;
import org.junit.Before;

/**
 * @author yuijnshui
 * @Title: BaseJunitTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/7/27下午3:40
 */
public class BaseJunitTest {
    @Before
    public void setLog(){
        LogPortal.setLogModule("SpringFrameworkSourceCode");
        LogPortal.setLogLevel(LogPortal.LogLevel.INFO);
    }
}
