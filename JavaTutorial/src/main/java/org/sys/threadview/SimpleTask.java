package org.sys.threadview;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author code
 * @Title: SimpleTask
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/12/311:16 AM
 */
public class SimpleTask {private final int mIndex;
    private Executor mExecutors = Executors.newSingleThreadExecutor();

    public SimpleTask(int index) {
        mIndex = index;
    }

    public void runTask(int y) {
        mExecutors.execute(() -> {
            System.out.println(mIndex);
//            System.out.println(y);
            System.out.println(Thread.currentThread().getName());
        });

    }

    public Executor getmExecutors() {
        return mExecutors;
    }
}


