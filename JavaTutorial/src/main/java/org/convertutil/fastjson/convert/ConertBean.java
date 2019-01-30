package org.convertutil.fastjson.convert;

import com.alibaba.fastjson.JSON;
import org.convertutil.fastjson.bean.Apple;
import org.convertutil.fastjson.bean.Fruit;

public class ConertBean {


    private static String convert() {
        Apple app = new Apple();
        app.setColor_info("red");
        app.setPlace("山东");
        app.setShape_info("圆形");
        app.setSize_1(10);

        return JSON.toJSONString(app);
    }

    private static <T> T convertResultData(String result, Class<T> clazz) {

        T t = null;
        try {
            t = JSON.parseObject(result, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }

    static void convertApple() {
        //		String result = convert();
//		System.out.println(result);
        String text = "{\"Color_info\":\"red\",\"Shape_Info\":\"很大\",\"PLACE\":\"北京\"}";
        Apple ap = convertResultData(text, Apple.class);
//		Apple ap = JSON.parseObject(text, Apple.class);
        System.out.println(JSON.toJSONString(ap));
    }

    static void convertFruit(){
        String text = "{\"color_1\":\"blue\",\"shape_info\":\"很大\",\"size_1\":\"100\"}";
        Fruit fruit = convertResultData(text, Fruit.class);
        System.out.println(fruit);
        System.out.println(JSON.toJSONString(fruit));
    }

    public static void main(String[] args) {
//		convertApple();
        convertFruit();
    }

}
