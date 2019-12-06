package org.chapter.databasic.thread;

//http://www.importnew.com/9994.html
public class RunnableImpl implements Runnable {
    private Thread th;
    private int a;

    public RunnableImpl() {
    }

    public RunnableImpl(Thread th,int a) {
        this.th = th;
        this.a = a;
    }

    @Override
    public void run() {
        try {
            if (th != null) {
                th.join();
            }
            System.out.println(a+"-Begin sleep-" + Thread.currentThread().getId());
//			Thread.sleep(2000);
            System.out.println(a+"-End sleep-" + Thread.currentThread().getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
