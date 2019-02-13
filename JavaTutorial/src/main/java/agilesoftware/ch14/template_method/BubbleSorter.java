package agilesoftware.ch14.template_method;

/**
 * @author code
 * @Title: BubbleSorter
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/2/13下午4:07
 */
public abstract class BubbleSorter {
    private int operations = 0;
    protected int length = 0;

    protected int doSort() {
        operations = 0;
        if (length <= 1) {
            return operations;
        }
        for (int nextToLast = length - 2; nextToLast >= 0; nextToLast--) {
            for (int index = 0; index <= nextToLast; index++) {
                if (outOfOrder(index)) {
                    swap(index);
                    operations++;
                }
            }
        }
        return operations;
    }

    protected abstract boolean outOfOrder(int index);

    protected abstract void swap(int index);
}
