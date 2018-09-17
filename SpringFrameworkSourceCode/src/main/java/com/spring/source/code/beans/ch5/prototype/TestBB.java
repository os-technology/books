package com.spring.source.code.beans.ch5.prototype;

import com.spring.source.code.beans.ch5.circle_dependency.TestC;

/**
 * @author code
 * @Title: TestB
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/14下午3:39
 */
public class TestBB {

    private TestCC testCC;


    public void b() {
        testCC.c();
    }

    public TestCC getTestCC() {
        return testCC;
    }

    public TestBB setTestCC(TestCC testCC) {
        this.testCC = testCC;
        return this;
    }
}
