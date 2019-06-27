package com.notes.boot.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Aspect //1
@Component //2
public class LogAspect {

    @Around("execution(* com.code.junit.mock.boot.dict.service.impl..*(..))") //6
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature method = (MethodSignature) joinPoint.getSignature();

        Object[] args = joinPoint.getArgs();

        StringBuffer sb = new StringBuffer();
        for (Object object : args) {
            sb.append(object == null ? null : object.toString()).append(" | ");
        }

        long start = System.currentTimeMillis();
        Object obj = null;
        try {
            obj = joinPoint.proceed();
        }finally {
            long end = System.currentTimeMillis();

            System.out.println("执行时间:"+(end - start)+"ms,执行类名:"+joinPoint.getTarget().getClass().getName()
                    +",执行方法:"+method.getName()+",传入参数:"+sb.toString()+",返回数据:"+(obj == null ? null : obj.toString()));
        }


        return obj;
    }


}
