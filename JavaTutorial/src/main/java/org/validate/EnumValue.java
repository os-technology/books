package org.validate;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 校验枚举值有效性
 *
 * @author code
 * @Title: EnumValue
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/1/18上午9:31
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValue.Validator.class)

public @interface EnumValue {

    String message() default "{custom.value.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<? extends Enum<?>> enumClass();

    String enumMethod();

    class Validator implements ConstraintValidator<EnumValue, Object> {
        private Class<? extends Enum<?>> enumClass;
        private String enumMethod;

        @Override
        public void initialize(EnumValue enumValue) {
            enumClass = enumValue.enumClass();
            enumMethod = enumValue.enumMethod();

        }

        @Override
        public boolean isValid(Object value, ConstraintValidatorContext context) {

            if (value == null || enumClass == null || enumMethod == null) {
                return Boolean.TRUE;
            }

            Class<?> clazz = value.getClass();

            try {
                Method method = enumClass.getMethod(enumMethod, clazz);
                if (!enumClass.equals(method.getReturnType())) {
                    throw new RuntimeException(String.format("%s method return is not boolean type in the %s class", enumMethod, enumClass));
                }

                if(!Modifier.isStatic(method.getModifiers())) {
                    throw new RuntimeException(String.format("%s method is not static method in the %s class", enumMethod, enumClass));
                }

                Object result = method.invoke(null, value);
                return result == null ? false : true;

            } catch (NoSuchMethodException e) {
                throw new RuntimeException(String.format("This %s(%s) method does not exist in the %s", enumMethod, clazz, enumClass), e);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }


            return false;
        }
    }
}
