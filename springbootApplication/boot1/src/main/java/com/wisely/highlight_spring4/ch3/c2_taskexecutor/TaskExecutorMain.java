package com.wisely.highlight_spring4.ch3.c2_taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: TaskExecutorMain
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/5/16下午8:06
 */

public class TaskExecutorMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);

        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);


        for (int i=0;i<10;i++){
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
        context.close();
    }

}
