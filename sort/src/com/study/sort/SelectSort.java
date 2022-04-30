package com.study.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author RenAshbell
 * @create 2022-04-30-21:55
 */
public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {101,34,119,1};
//        selectSort(arr);
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[80000];
        for (int i = 0; i < 80000;i++){
            arr[i] = (int) (Math.random() * 8000000);// 生成一个[0,8000000)数
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是=" + date1Str);

        // 测试选择排序
        selectSort(arr);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序前的时间是=" + date2Str);
    }

    // 选择排序
    public static void selectSort(int[] arr){
        // 使用逐步推导的方式来, 讲解选择排序
        // 第1轮
        // 原始的数组:   101,34,119,1
        // 第一轮排序:   1,34,119,101
        // 第二轮排序:   1,34,119,101
        // 第三轮排序:   1,34,101,119


        // 选择排序的时间复杂度是O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {// 说明假定的最小值, 不是最小的
                    min = arr[j];// 重置min
                    minIndex = j;// 重置minIndex
                }
            }
            // 将最小值, 放在arr[i]中, 即交换
            if (minIndex != i){// 如果最小值就是假定的最小值, 那么无需交换
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
