package com.view.arithmetic;

import java.util.Random;

/**
 * 在1000个数中找到前50个数字（适用于超大数量的数据选取topN）
 * 思路
 * 1. 构建前50个数字的小顶堆(直接取前50个数字构建即可)
 * 2. 从第51个数字开始与小顶堆的根节点进行比对，决定是否调整小顶堆的数据
 * 小顶堆特点：https://blog.csdn.net/u013625961/article/details/95594831
 *
 * @author code
 * @Title: TopN
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2020/1/811:02 AM
 */
public class TopN {
    // 父节点
    private int parent(int n) {
        return (n - 1) / 2;
    }

    // 左孩子
    private int left(int n) {
        return 2 * n + 1;
    }

    // 右孩子
    private int right(int n) {
        return 2 * n + 2;
    }

    // 构建堆
    private void buildHeap(int n, int[] data) {
        for(int i = 1; i < n; i++) {
            int t = i;
            // 调整堆
            while(t != 0 && data[parent(t)] > data[t]) {
                int temp = data[t];
                data[t] = data[parent(t)];
                data[parent(t)] = temp;
                t = parent(t);
            }
        }
    }

    // 调整data[i]
    private void adjust(int i, int n, int[] data) {
        if(data[i] <= data[0]) {
            return;
        }
        // 置换堆顶
        int temp = data[i];
        data[i] = data[0];
        data[0] = temp;
        // 调整堆顶
        int t = 0;
        while( (left(t) < n && data[t] > data[left(t)])
                || (right(t) < n && data[t] > data[right(t)]) ) {
            if(right(t) < n && data[right(t)] < data[left(t)]) {
                // 右孩子更小，置换右孩子
                temp = data[t];
                data[t] = data[right(t)];
                data[right(t)] = temp;
                t = right(t);
            } else {
                // 否则置换左孩子
                temp = data[t];
                data[t] = data[left(t)];
                data[left(t)] = temp;
                t = left(t);
            }
        }
    }

    // 寻找topN，该方法改变data，将topN排到最前面
    public void findTopN(int n, int[] data) {
        // 先构建n个数的小顶堆
        buildHeap(n, data);
        // n往后的数进行调整
        for(int i = n; i < data.length; i++) {
            adjust(i, n, data);
        }
    }

    // 打印数组
    public void print(int[] data) {
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        TopN topN = new TopN();

        // 第一组测试
        int[] arr1 = new int[]{56, 30, 71, 18, 29, 93, 44, 75, 20, 65, 68, 34};

        System.out.println("原数组：");
        topN.print(arr1);
        topN.findTopN(5, arr1);
        System.out.println("调整后数组：");
        topN.print(arr1);

        // 第二组测试
        int[] arr2 = new int[1000];
        for(int i=0; i<arr2.length; i++) {
            arr2[i] = i + 1;
        }

        System.out.println("原数组：");
        topN.print(arr2);
        topN.findTopN(50, arr2);
        System.out.println("调整后数组：");
        topN.print(arr2);

        // 第三组测试
        Random random =new Random();
        int[] arr3 = new int[1000];
        for(int i=0; i<arr3.length; i++) {
            arr3[i] = random.nextInt();
        }

        System.out.println("原数组：");
        topN.print(arr3);
        topN.findTopN(50, arr3);
        System.out.println("调整后数组：");
        topN.print(arr3);
    }

}
