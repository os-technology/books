package agilesoftware.ch14.template_method;

/**
 * 冒泡排序，模板方法模式实现
 * @author code
 * @Title: IntBubbleSorter
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2019/2/13下午4:11
 */
public class IntBubbleSorter extends BubbleSorter {

    public static void main(String[] args) {
        int[] intArr = {1, 5, 3, 7, 2};
        System.out.println((new IntBubbleSorter()).sort(intArr));
    }

    private int[] array = null;

    public int sort(int[] theArray) {
        array = theArray;
        length = array.length;
        return doSort();//返回排序次数
    }

    @Override
    protected boolean outOfOrder(int index) {
        return (array[index] > array[index + 1]);
    }

    @Override
    protected void swap(int index) {
        int tmp = array[index];
        array[index] = array[index + 1];
        array[index + 1] = tmp;
    }
}
