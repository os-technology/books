package com.wisely.highlight_spring4.ch3.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: AsyncTaskService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/16下午7:50
 */
@Service
public class AsyncTaskService {
//通过@Async注解表明该方法是个异步方法，如果注解在类级别，
//则表明该类所有的方法都是异步方法， 而这里的方法自动被注入使用
//ThreadPoolTaskExecutor作为TaskExecutor。
    @Async
    public void executeAsyncTask(Integer i){
        System.out.println("异步执行任务："+i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("异步执行任务+1："+(i+1));
    }
}
