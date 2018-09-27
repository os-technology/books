package com.spring.source.code.beans.ch5.prototype;


/**
 * @author code
 * @Title: TestC
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/14下午3:40
 */
public class TestCC {
    private TestAA testAA;


    public void c() {
        testAA.a();
    }

    public TestAA getTestAA() {
        return testAA;
    }

    public TestCC setTestAA(TestAA testAA) {
        this.testAA = testAA;
        return this;
    }
}
