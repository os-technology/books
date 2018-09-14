package com.spring.source.code.beans.ch5.circle_dependency;

/**
 * @author code
 * @Title: TestC
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/14下午3:40
 */
public class TestC {
    private TestA testA;

    public TestC(TestA testA){
        this.testA = testA;
    }
    public void c() {
        testA.a();
    }

    public TestA getTestA() {
        return testA;
    }

    public TestC setTestA(TestA testA) {
        this.testA = testA;
        return this;
    }
}
