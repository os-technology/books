package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuijnshui@lxfintech.com
 * @Title: OOMTest
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: lxjr.com
 * @Created on 2018/6/10下午4:00
 */

public class OOMTest {

    /**
     * 我们常见的OOM（OutOfMemoryError）发生的原因不只是堆内存溢出，堆内存溢出只是OOM其中一种情况，OOM还可能发生在元空间、线程栈、直接内存。
     *
     * 程序启动设置：-Xmx50m -XX:+PrintGCDetails
     *
     * @param args
     */

    public static void main(String[] args) {

        List<Byte[]> list = new ArrayList<>();

        for (int i=0;i<100;i++){
            //构造1M大小的byte数值
            Byte[] bytes = new Byte[1024*1024];
            //将byte数组添加到list中，因为存在引用关系，所以byte数组不会被GC回收
            list.add(bytes);
        }
    }
}
