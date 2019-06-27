package com.notes.boot.dict.controller;

import com.alibaba.fastjson.JSON;
import com.notes.boot.dict.beans.MockTable;
import com.notes.boot.dict.service.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 项目访问地址：http://localhost:8095/junit/
 *
 * @author code
 * @Title: WebBootController
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/1下午1:00
 */
@RestController
public class MockController {
    @Autowired
    private MockService mockService;

    @RequestMapping("/")
    public String init() {
        return "JunitMockTest is success";
    }

    @RequestMapping("save")
    public String save() {
        mockService.saveMock();
        return "save is ok";
    }

    /**
     * 异常事务回滚测试-测试通过
     *
     * @return
     */
    @RequestMapping("saveException")
    public String transactionalTest() {
        mockService.saveMocktable();
        return "saveWithoutSameId is ok";
    }

    /**
     * 手动方式回滚事务-测试通过
     *
     * @return
     */
    @RequestMapping("savemanual")
    public String transactionalcatch() {
        mockService.saveMocktableCatch();
        return "saveWithoutSameId is ok";
    }


    /**
     * http://localhost:8095/junit/saveInnerTryCatchWithoutRollback
     * 嵌套事务测试 - 内部try-catch,无手动回滚 外部正常
     * 结果：所有数据正常插入，没有回滚
     *
     * @return
     */
    @RequestMapping("saveInnerTryCatchWithoutRollback")
    public String saveInnerTryCatchWithoutRollback() {
        mockService.saveInnerTryCatchWithoutRollback();
        return "saveInnerTryCatchWithoutRollback is ok";
    }

    /**
     * http://localhost:8095/junit/saveInnerTryCatchWithRollback
     * 嵌套事务测试 - 内部try-catch,手动回滚 外部正常
     * 结果：所有数据全部回滚，没有插入
     *
     * @return
     */
    @RequestMapping("saveInnerTryCatchWithRollback")
    public String saveInnerTryCatchWithRollback() {
        mockService.saveInnerTryCatchWithRollback();
        return "saveInnerTryCatchWithRollback is ok";
    }

    /**
     * http://localhost:8095/junit/saveInnerExceptionWithoutRollbackFor
     * 嵌套事务测试 - 内部exception, 事务注解没有rollbackFor,外部正常
     * 结果：所有数据正常回滚，没有插入
     *
     * @return
     */
    @RequestMapping("saveInnerExceptionWithoutRollbackFor")
    public String saveInnerExceptionWithoutRollbackFor() {
        mockService.saveInnerExceptionWithoutRollbackFor();
        return "saveInnerExceptionWithoutRollbackFor is ok";
    }

/**
     * http://localhost:8095/junit/saveInnerExceptionWithRollbackFor
     * 嵌套事务测试 - 内部exception, 事务注解包含rollbackFor,外部正常
     * 结果：所有数据正常回滚，没有插入
     *
     * @return
     */
    @RequestMapping("saveInnerExceptionWithRollbackFor")
    public String saveInnerExceptionWithRollbackFor() {
        mockService.saveInnerExceptionWithRollbackFor();
        return "saveInnerExceptionWithRollbackFor is ok";
    }




    /**
     * http://localhost:8095/junit/saveOuterTryCatchWithRollback
     * 嵌套事务测试 - 外部try-catch,手动回滚 内部正常
     * 结果：所有数据全部回滚
     *
     * @return
     */
    @RequestMapping("saveOuterTryCatchWithRollback")
    public String saveOuterTryCatchWithRollback() {
        mockService.saveOuterTryCatchWithRollback();
        return "saveOuterTryCatchWithRollback is ok";
    }

    /**
     * http://localhost:8095/junit/saveOuterTryCatchWithRollback
     * 嵌套事务测试 - 外部Exception， 内部正常
     * 结果：所有数据全部回滚
     *
     * @return
     */
    @RequestMapping("saveOuterException")
    public String saveOuterException() {
        mockService.saveOuterException();
        return "saveOuterException is ok";
    }


    @RequestMapping("addMock")
    public String addMock(MockTable mockTable) {

        mockTable = mockService.saveWithoutSameId(mockTable);
        System.out.println(JSON.toJSONString(mockTable));
        return "addMock is ok";
    }

    @RequestMapping("getModelAndView")
    public ModelAndView modelAndView(MockTable mockTable) {

        mockTable = mockService.saveWithoutSameId(mockTable);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("result", mockTable);
        return modelAndView;
    }

}
