package com.view.arithmetic;

/**
 * 二分查找算法
 */
public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};// 源数据
        int key = 12;
//        int ret = bb(arr, key);
//        System.out.println(ret);
        order();
    }

    public static int biSearch(int arr[], int a) {
        int start = 0;
        int end = arr.length - 1;

        int mid;
        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] < a) {
                start = mid + 1;
            } else if (arr[mid] > a) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;//找不到
    }

    public static int bb(int[] arr, int input) {
        int begin = 0;
        int end = arr.length - 1;
        int mid;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (arr[mid] > input) {
                end = mid - 1;
            } else if (arr[mid] < input) {
                begin = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;
    }



    public static void order(){
        int tmp;
        int[] array = {2,1,5,4,3};
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array.length-i-1;j++){
                if (array[j]<array[j+1]){
                    tmp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
        }
        for (int a:array)
        System.out.println(a);
    }
}
