package com.notes.boot.dict.threadlocal;

import java.lang.ref.WeakReference;

/**
 * @author code
 * @Title: TestWeakRef
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/8/244:01 PM
 */
public class TestWeakRef {

    public static class User {
        private String name;
        private int id;

        public User(int id, String name) {
            this.name = name;
            this.id = id;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }

    public static void main(String[] args) {
//        strong();
        weak();
    }

    /**
     * 弱引用示例
     * GC 前可以打印，GC之后为null
     */
    private static void weak() {
        User user = new User(1, "shui");
        WeakReference<User> userWeak = new WeakReference<>(user);

        user = null;
        System.out.println(userWeak.get());
        System.gc();
        System.out.println("After GC");
        System.out.println(userWeak.get());

    }

    /**
     * 强引用，gc前后都会打印
     */
    private static void strong() {
        User user = new User(1, "shui");
        User user1 = user;//这是强引用，故执行GC之后，new User 对象 不会被回收

        user = null;
        System.out.println(user1);
        System.gc();
        System.out.println("After GC");
        System.out.println(user1);
    }
}
