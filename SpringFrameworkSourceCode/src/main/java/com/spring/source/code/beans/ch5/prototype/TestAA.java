package com.spring.source.code.beans.ch5.prototype;

/**
 * @author code
 * @Title: TestA
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/14下午3:39
 */
public class TestAA {

    private TestBB testBB;


    public void a(){
        testBB.b();
    }

    public TestBB getTestBB() {
        return testBB;
    }

    public TestAA setTestBB(TestBB testBB) {
        this.testBB = testBB;
        return this;
    }
}
