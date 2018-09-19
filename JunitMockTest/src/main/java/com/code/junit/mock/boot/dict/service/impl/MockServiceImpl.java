package com.code.junit.mock.boot.dict.service.impl;

import com.alibaba.fastjson.JSON;
import com.code.junit.mock.boot.dict.beans.MockTable;
import com.code.junit.mock.boot.dict.dao.MockTableDAO;
import com.code.junit.mock.boot.dict.service.MockService;
import com.code.junit.mock.boot.exceptions.ObjectNullException;
import com.code.junit.mock.boot.util.LogPortal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

/**
 * @author code
 * @Title: MockServiceImpl
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/1下午1:03
 */
@Service("mockService")
public class MockServiceImpl implements MockService {
    @Autowired
    private MockTableDAO mockTableDAO;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void saveMock() {
        MockTable data = getMockTable();
        mockTableDAO.save(data);
    }

    @Override
    @Transactional
    public MockTable saveWithoutSameId(MockTable mockTable) {
        MockTable result = mockTableDAO.selectById(mockTable.getId());
        if (result != null) {
            return null;
        }
        mockTableDAO.save(mockTable);
        return mockTable;
    }

    @Override
    public MockTable getById(Long id) {
        return mockTableDAO.selectById(id);
    }

    @Override
    public void privateAndProtectedMethod(MockTable mockTable) throws ObjectNullException {
        if (mockTable == null) {
            throw new ObjectNullException("mocktable object is null");
        }

        String json = convertJson(mockTable);

        if (StringUtils.isEmpty(json)) {
            throw new NullPointerException("json is null");
        }

        mockTable = converMockTable(json);

        printObject(mockTable);
        mockTable.getName().equals(System.getProperty("mockName"));

    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public MockTable saveMocktable() {
        MockTable data = getMockTable();
        mockTableDAO.save(data);
        System.out.println(JSON.toJSONString(data));
        throw new IllegalArgumentException();
    }

    @Override
    @Transactional
    public void saveMocktableCatch() {//TransactionTemplate

        MockTable data = getMockTable();
        mockTableDAO.save(data);
        System.out.println(JSON.toJSONString(data));
        rollback();

    }

    private void rollback() {
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

    @Override
    @Transactional
    public void saveInnerTryCatchWithoutRollback() {
        for (int i = 0; i < 5; i++) {
            saveDataWithTryCatch(i, false);
        }

    }

    @Override
    @Transactional
    public void saveOuterTryCatchWithRollback() {
        try {
            for (int i = 0; i < 5; i++) {
                saveDataWithNothing(i);
                if (i == 3) {
                    int tmp = 1 / 0;//用于异常抛出
                }
            }
        } catch (Exception e) {
            //手动回滚
            rollback();
        }
    }

    @Override
    @Transactional
    public void saveInnerTryCatchWithRollback() {
        for (int i = 0; i < 5; i++) {
            saveDataWithTryCatch(i, true);
        }
    }

    @Override
    @Transactional
    public void saveInnerExceptionWithoutRollbackFor() {
        for (int i = 0; i < 5; i++) {
            saveDataInnerExceptionWithoutRollbackFor(i);
        }
    }

    @Override
    @Transactional
    public void saveInnerExceptionWithRollbackFor() {
        for (int i = 0; i < 5; i++) {
            saveDataInnerExceptionWithRollbackFor(i);
        }
    }

    @Override
    @Transactional
    public void saveOuterException() {
        for (int i = 0; i < 5; i++) {
            saveDataWithNothing(i);
            if (i == 3) {
                int tmp = 1 / 0;//用于异常抛出
            }
        }
    }

    @Transactional(rollbackFor = Throwable.class)
    public void saveDataInnerExceptionWithRollbackFor(int i) {
        MockTable mockdata = getMockTable(i);
        mockTableDAO.save(mockdata);
        System.out.println(JSON.toJSONString(mockdata));
        if (i == 3) {
            int b = 1 / 0;
        }
    }


    @Transactional
    public void saveDataInnerExceptionWithoutRollbackFor(int i) {
        MockTable mockdata = getMockTable(i);
        mockTableDAO.save(mockdata);
        System.out.println(JSON.toJSONString(mockdata));
        if (i == 3) {
            int b = 1 / 0;
        }
    }

    /**
     * @param i
     * @param flag true 执行回滚方法，false，不执行回滚方法
     */
    @Transactional
    public void saveDataWithTryCatch(int i, boolean flag) {
        try {
            MockTable mockdata = getMockTable(i);
            mockTableDAO.save(mockdata);
            System.out.println(JSON.toJSONString(mockdata));
            if (i == 3) {
                int b = 1 / 0;
            }
        } catch (Exception e) {
            LogPortal.error("saveDataWithTryCatch 出现异常", e);
            if (flag) {
                rollback();
            }
        }
        LogPortal.info("saveDataWithTryCatch 执行结束");
    }

    @Transactional
    public void saveDataWithNothing(int i) {

        MockTable mockdata = getMockTable(i);
        mockTableDAO.save(mockdata);
        LogPortal.info(i + " - saveDataWithTryCatch 执行结束");
    }


    protected MockTable converMockTable(String json) {

        MockTable mocktable = JSON.parseObject(json, MockTable.class);
        mocktable.setName(System.getProperty("mockName"));
        return mocktable;
    }

    private void printObject(MockTable json) {
        if (json != null) {
            System.out.println(json);
        }
    }

    private String convertJson(MockTable mockTable) {

        return JSON.toJSONString(mockTable);
    }


    private MockTable getMockTable() {
        MockTable table = new MockTable();
        table.setData("test1")//.setId(1)
                .setName("mock1");
        return table;
    }

    private MockTable getMockTable(int i) {
        MockTable table = new MockTable();
        table.setData(i + "-test")//.setId(1)
                .setName(i + "-mock");
        return table;
    }
}
