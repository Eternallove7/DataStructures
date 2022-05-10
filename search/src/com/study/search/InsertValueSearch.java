package com.study.search;

import java.util.Arrays;

/**
 * @author RenAshbell
 * @create 2022-05-10-9:28
 */

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = i + 1;
        }
        int index = insertValueSearch(arr, 0, arr.length - 1, 8888);
        System.out.println("index=" + index);

    }

    // 编写插值查找算法
    /**
     *
     * @param arr 数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param findVal 要查找的值
     * @return 如果找到就返回下标, 如果没有就返回-1
     */
    public static int insertValueSearch(int[] arr,int left,int right,int findVal){
        System.out.println("查找次数");
        // 注意：findVal < arr[0] || findVal > arr[arr.length - 1] 必须要有
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]){
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal){ //说明应该向右边递归
            return insertValueSearch(arr,mid + 1,right,findVal);
        } else if (findVal < midVal){
            return insertValueSearch(arr,left,mid - 1,findVal);
        } else {
            return mid;
        }
    }
}
