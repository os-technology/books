package com.view.arithmetic.leecode;


import java.util.Arrays;

/**
 * 两个顺序数组，合并为一个顺序数组
 *
 * @author code
 * @Title: ASol
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2020/1/72:11 PM
 */
public class ASol {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int index = m + n - 1;
        while (index >= 0) {
            //前两个判断要放在前面，防止空指针异常
            if (i < 0) {
                nums1[index--] = nums2[j--];
            } else if (j < 0) {
                nums1[index--] = nums1[i--];
            } else if (nums1[i] > nums2[j] && i >= 0) {
                nums1[index--] = nums1[i--];
            } else if (nums1[i] <= nums2[j] && j >= 0) {
                nums1[index--] = nums2[j--];
            }
        }
        System.out.println(nums1);
    }

    public static int[] mergeTwoSortArray(int[] array1, int[] array2) {
        int i = 0;
        int j = 0;
        int k = 0;

        int[] c = new int[array1.length + array2.length];

        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                c[k] = array1[i];
                i++;
            } else {
                c[k] = array2[j];
                j++;
            }
            k++;
        }
        //针对i下标值一直大于j的情况
        while (i < array1.length) {
            c[k] = array1[i];
            k++;
            i++;
        }
        //针对j下标值大于i下标值的情况
        while (j < array2.length) {
            c[k] = array2[j];
            k++;
            j++;
        }
        System.out.println(Arrays.toString(c));


        return c;
    }

    public static void main(String[] args) {


        int[] a = {1, 3, 8};
        int[] b = {7, 9};
        mergeTwoSortArray(a, b);


    }
}
