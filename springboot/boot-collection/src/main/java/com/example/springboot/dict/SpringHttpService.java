package com.example.springboot.dict;

import com.alibaba.fastjson.JSONObject;
import com.example.springboot.dict.featuretask.ShuiFutureTask;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

/**
 * 自定义futureTask使用
 *
 * @author code
 * @Title: SpringHttpService
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/6/166:39 PM
 */
@Service
public class SpringHttpService {
    ExecutorService executor = Executors.newFixedThreadPool(2);

    /**
     * 模拟高并发情况下的数据获取方式操作，以节省时间消耗(jd,ali通用)
     *
     * @return
     */
    public String futureExecute() {
        long time = System.currentTimeMillis();
        Callable<JSONObject> userInfo = () -> {
            Thread.sleep(3000);//模拟调用接口耗时
            return JSONObject.parseObject("{\"user\":\"userinfo is ok\"}");
        };

        Callable<JSONObject> moneyInfo = new Callable<JSONObject>() {
            @Override
            public JSONObject call() throws Exception {
                Thread.sleep(2000);//模拟调用接口耗时
                return JSONObject.parseObject("{\"money\":\"moneyInfo is ok\"}");
            }
        };

//        ShuiFutureTask userTask = new ShuiFutureTask(userInfo);
//        ShuiFutureTask moneyTask = new ShuiFutureTask(moneyInfo);


        FutureTask<JSONObject> userTask = new FutureTask<>(userInfo);
        FutureTask<JSONObject> moneyTask = new FutureTask<>(moneyInfo);

        executor.submit(userTask);
        executor.submit(moneyTask);

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.putAll(userTask.get());
            jsonObject.putAll(moneyTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("futureExecute is success ,time is " + (System.currentTimeMillis() - time));
        return jsonObject.toJSONString();
    }
}
/**
 * 包含返回值的线程为 Callable，没有返回值的线程为 Runnable
 *FutureTask 中的get()方法是一个阻塞方法，在 FutureTask 执行完成后才会进行结果值的获取
 * 线程池负责提交需要执行的 FutureTask 信息
 *
 */