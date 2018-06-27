package org.jvm;

import org.junit.Test;

public class JvmUnitTest {

    @Test
    public void pringGC() {
        byte[] bytes = null;
        for (int i = 0; i < 100; i++) {
            bytes = new byte[1 * 1024 * 1024];
        }
    }
}
