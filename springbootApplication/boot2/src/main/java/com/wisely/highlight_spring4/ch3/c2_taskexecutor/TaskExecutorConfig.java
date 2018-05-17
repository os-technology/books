package com.wisely.highlight_spring4.ch3.c2_taskexecutor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: TaskExecutorConfig
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/16下午7:39
 */
@Configuration
@ComponentScan("com.wisely.highlight_spring4.ch3.c2_taskexecutor")
@EnableAsync//开启异步任务支持
public class TaskExecutorConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {

        // 配置类实现AsyncConfigurer接口并重写getAsyncExecutor方法，
        // 并返回一个ThreadPoolTaskExecutor，
        // 这样我们就获得了一个基于线程池TaskExecutor。
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
