package agilesoftware.ch14.template_method;

/**
 * @author code
 * @Title: Application
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/2/13下午3:01
 */
public abstract class Application {

    private boolean isDone = false;

    protected abstract void init();

    protected abstract void idle();

    protected abstract void cleanup();

    protected void setDone() {
        isDone = true;
    }

    protected boolean done() {
        return isDone;
    }

    public void run() {
        init();
        while (!done()) {
            idle();
        }
        cleanup();
    }
}
