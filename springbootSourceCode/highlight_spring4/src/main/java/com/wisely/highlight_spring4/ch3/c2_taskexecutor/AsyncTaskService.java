package com.wisely.highlight_spring4.ch3.c2_taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
@Service
public class AsyncTaskService {
	
	@Async //1
    public void executeAsyncTask(Integer i){
        System.out.println("ִ���첽����: "+i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("ִ���첽����+1: "+(i+1));
    }

}
