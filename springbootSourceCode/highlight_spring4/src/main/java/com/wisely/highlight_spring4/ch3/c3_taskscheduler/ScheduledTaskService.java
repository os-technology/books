package com.wisely.highlight_spring4.ch3.c3_taskscheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {
	
	  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	  @Scheduled(fixedRate = 5000) //1
	  public void reportCurrentTime() {
	       System.out.println("ÿ������ִ��һ�� " + dateFormat.format(new Date()));
	   }

	  @Scheduled(cron = "0 28 11 ? * *"  ) //2
	  public void fixTimeExecution(){
	      System.out.println("��ָ��ʱ�� " + dateFormat.format(new Date())+"ִ��");
	  }

}
