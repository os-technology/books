package org.springmvc.redis;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.StandardCharsets;

/**
 * 自定义Redis序列化器
 * 暂不使用
 *
 * @author code
 * @Title: RedisConverter
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/11/84:25 PM
 */
public class RedisConverter implements RedisSerializer<Object> {
    private Converter<Object, byte[]> serializer = new SerializingConverter();//序列化器
    private Converter<byte[], Object> deserializer = new DeserializingConverter();//反序列化器

    @Override
    public byte[] serialize(Object o) throws SerializationException {//将对象序列化成字节数组
        if (o == null) return new byte[0];
        try {
            return serializer.convert(o);
        } catch (Exception e) {
            System.out.println("对象缓存序列化失败");
            return new byte[0];
        }


    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {//将字节数组反序列化成对象
        if (bytes == null || bytes.length == 0) return null;

        //如果为数字类型，则byte字节第一位大于0， 如果为对象序列化的结果，则第一位小于0，以此来进行序列化方式的区分
        //因为incr函数没有经过自定义的序列化操作，故反序列化需要进行区分操作
        if (bytes[0] > 0) {
            return (bytes == null ? null : new String(bytes, StandardCharsets.UTF_8));
        }

        try {
            return deserializer.convert(bytes);
        } catch (Exception e) {
            System.out.println("对象缓存反序列化失败");
            throw e;
        }
    }
}
