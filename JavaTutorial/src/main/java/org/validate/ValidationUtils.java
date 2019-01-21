package org.validate;


import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author code
 * @Title: ValidationUtils
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/1/17下午5:39
 */
public class ValidationUtils {
    /**
     * 使用hibernate的注解来进行验证
     */
    private static Validator validator = Validation
            .byProvider(HibernateValidator.class)
            .configure()
            .failFast(false)//快速失败返回模式(只要有一个验证失败，则返回)  failFast：true  快速失败返回模式    false 普通模式
            .buildValidatorFactory().getValidator();//返回的Factory：ValidatorFactoryImpl
    /**
     * 功能描述: <br>
     * 〈注解验证参数〉
     *
     * @param obj
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static <T> void validate(T obj) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        // 抛出检验异常
        if (constraintViolations.size() > 0) {
            throw new IllegalArgumentException(String.format("%s校验失败", constraintViolations.iterator().next().getPropertyPath()));
        }
    }
}
