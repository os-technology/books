package com.wisely.highlight_spring4.ch3.c5_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * 从Spring 2开始， 为了响应JDK 1.5推出的注解功
 * 能， Spring开始大量加入注解来替代xml配置。 Spring的
 * 注解主要用来配置注入Bean， 切面相关配置
 * （@Transactional） 。 随着注解的大量使用， 尤其相同
 * 的多个注解用到各个类中， 会相当啰嗦。 这就是所谓的
 * 模板代码， 是Spring设计原则中要消除的代码。
 *
 * 所谓元注解其实就是可以注解到别的注解上的注
 * 解， 被注解的注解称之为组合注解、 是可能有点拗口，
 * 体会含义最重要） ， 组合注解具备元注解的功能。
 * Spring的很多注解都可以作为元注解， 而且Spring本身
 * 已经有很多组合注解， 如@Configuration就是一个组合
 * '@Component'注解， 表明这个类其实也是一个Bean。
 *
 * 我们前面的章节里大量使用@Configuration和
 * '@ComponentScan'注解到配置类上， 如果你跟着本书一
 * 直在敲代码的话是不是觉得已经有点麻烦了呢？ 下面我
 * 将这两个元注解组成一个组合注解， 这样我们只需写一
 * 个注解就可以表示两个注解。
 *
 * @Created on 2018/5/17下午4:28
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration//组合@Configuration元注解
@ComponentScan//组合@ComponentScan元注解
public @interface WiselyConfiguration {

    String[] value() default {};//覆盖value参数

}
