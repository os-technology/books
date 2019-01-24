package org.jvm;

import org.junit.Test;

/**
 * http://www.cnblogs.com/leefreeman/category/1058724.html
 */
public class JvmUnitTest {

    @Test
    public void floatPrint(){
        System.out.println(Integer.toBinaryString(Float.floatToRawIntBits(-5)));
    }

    /**
     * vm配置：
     * -verbose:gc 查看GC
     * -XX:+PrintGC  查看GC
     * -XX:+PrintGCDetails 查看GC详情
     */
    @Test
    public void pringGC() {
        byte[] bytes = null;
        for (int i = 0; i < 100; i++) {
            bytes = new byte[1 * 1024 * 1024];
        }
    }
}
