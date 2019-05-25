package com.code.junit.mock.boot.dict.service;

import com.code.junit.mock.boot.dict.beans.MockTable;
import com.code.junit.mock.boot.exceptions.ObjectNullException;
import com.github.pagehelper.PageInfo;

/**
 * @author code
 * @Title: MockService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/1下午1:03
 */
public interface MockService {

    public void saveMock();

    public PageInfo<MockTable> getPageList(int pageNo,int pageSize,MockTable mockTable);

    MockTable saveWithoutSameId(MockTable mockTable);

    MockTable getById(Long id);

    void privateAndProtectedMethod(MockTable mockTable) throws ObjectNullException;


    MockTable saveMocktable();

    public boolean callInternalInstance(String path) ;
    /**
     * 手动方式回滚事务
     */
    void saveMocktableCatch();

    /**
     * 嵌套事务测试 - 内部try-catch,无回滚 外部正常
     */
    void saveInnerTryCatchWithoutRollback();

    /**
     * 嵌套事务测试 - 外部try-catch,手动回滚 内部正常
     */
    void saveOuterTryCatchWithRollback();

    /**
     * 嵌套事务测试 - 内部try-catch,手动回滚 外部正常
     */
    void saveInnerTryCatchWithRollback();

    /**
     * 嵌套事务测试 - 内部exception, 事务注解没有rollbackFor,外部正常
     */
    void saveInnerExceptionWithoutRollbackFor();

    /**
     * 嵌套事务测试 - 内部exception, 事务注解包含rollbackFor,外部正常
     */
    void saveInnerExceptionWithRollbackFor();

    /**
     * 嵌套事务测试 - 外部Exception， 内部正常
     */
    void saveOuterException();
}
