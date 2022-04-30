package com.study.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author RenAshbell
 * @create 2022-04-30-22:35
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {101,34,119,1};
//        insertSort(arr);
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
        insertSort(arr);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序前的时间是=" + date2Str);
    }

    // 插入排序
    public static void insertSort(int[] arr){
        // {101,34,119,1}
        for (int i = 0; i < arr.length; i++) {
            // 定义待插入的数
            int insertValue = arr[i];
            // 定义待插入的索引
            int insertIndex = i - 1;
            // 说明
            // 1.insertIndex >= 0 保证在给insertValue 找插入位置, 不越界
            // 2.insertValue < arr[insertIndex] 待插入的数, 还没有找到插入位置
            // 3.就需要将arr[insertIndex] 后移
            while (insertIndex >= 0 && insertValue < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                // 没找到比待插入的数还小的数的话就指针往前移
                insertIndex--;
            }
            // 当退出while循环时, 说明插入的位置找到, insertIndex + 1
            arr[insertIndex + 1] = insertValue;
        }

        /*
        // {101,34,119,1}
        for (int i = 0; i < arr.length; i++) {
            // i = 1时
            int insertValue = arr[i];// 34
            int insertIndex = i - 1;// 0
            while (insertIndex >= 0 && insertValue < arr[insertIndex]){
                // 符合循环条件时
                // {101,101,119,1}
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;// -1
            }
            // 此时index = -1, 因此+1后为0, 且insertValue已保存
            // {34,101,119,1}
            arr[insertIndex + 1] = insertValue;
        }
         */

    }
}
