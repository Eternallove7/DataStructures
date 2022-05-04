package com.study.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author RenAshbell
 * @create 2022-04-30-23:32
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8,9,1,7,2,3,5,4,6,0};
//        shellSort(arr);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[80000];
        for (int i = 0; i < 80000;i++){
            arr[i] = (int) (Math.random() * 8000000);// 生成一个[0,8000000)数
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是=" + date1Str);

        // 测试希尔排序
        shellSort2(arr);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序前的时间是=" + date2Str);


    }

    public static void shellSort(int[] arr){
        int temp = 0;
        // 把每次的步长都除2处理
        for (int i = arr.length / 2; i > 0; i /= 2) {
            // 按照步长把数组平均分为 j 份
            for (int j = i; j < arr.length; j++) {
                // 遍历各组中所有的元素(共 i 组, 每组有个元素), 步长为 i
                for (int k = j - i; k >= 0; k -= i) {
                    // 如果当前元素大于加上步长后的那个元素, 说明交换
                    if (arr[k] >= arr[k + i]) {
                        temp = arr[k];
                        arr[k] = arr[k + i];
                        arr[k + i] = temp;
                    }
                }
            }
        }


        /*
        // 第一遍步长为 10/2 = 5 的时候
            for (int j = 5; j < arr.length; j++) {
                // 遍历各组中所有的元素(共 5 组, 每组有2个元素), 步长为 5
                for (int k = j - 5; k >= 0; k -= 5) {
                    // 如果当前元素大于加上步长后的那个元素, 说明交换
                    if (arr[k] >= arr[k + 5]) {
                        temp = arr[k];
                        arr[k] = arr[k + 5];
                        arr[k + 5] = temp;
                    }
                }
            }

            // 第二遍步长为 5/2 = 2 时
            for (int j = 2; j < arr.length; j++) {
                // 遍历各组中所有的元素(共 2 组, 每组有5个元素), 步长为 2
                for (int k = j - 2; k >= 0; k -= 2) {
                    // 如果当前元素大于加上步长后的那个元素, 说明交换
                    if (arr[k] >= arr[k + 2]) {
                        temp = arr[k];
                        arr[k] = arr[k + 2];
                        arr[k + 2] = temp;
                    }
                }
            }

            // 第三遍步长为 5/2/2 = 1 时
            for (int j = 1; j < arr.length; j++) {
                // 遍历各组中所有的元素(共 1 组, 每组有10个元素), 步长为 1
                for (int k = j - 1; k >= 0; k -= 1) {
                    // 如果当前元素大于加上步长后的那个元素, 说明交换
                    if (arr[k] >= arr[k + 1]) {
                        temp = arr[k];
                        arr[k] = arr[k + 1];
                        arr[k + 1] = temp;
                    }
                }
            }
         */
    }

    // 对交换式的希尔排序进行优化 -> 移位法
    public static void shellSort2(int[] arr){
        for (int i = arr.length / 2; i > 0; i /= 2) {
            // 从第 i 个元素开始, 逐个对其所在的组进行直接插入排序
            for (int j = i; j < arr.length; j++) {
                int insertIndex = j;
                int insertValue = arr[insertIndex];
                // 跟上一步比较
                if (arr[insertIndex] < arr[insertIndex - i]){
                    // 如果比上一步小的话就进行插入排序
                    while (insertIndex - i >0 && insertValue < arr[insertIndex - i]){
                        // 移动
                        arr[insertIndex] = arr[insertIndex - i];
                        insertIndex -= i;
                    }
                    // 当退出while后, 就给temp找到插入的位置
                    arr[insertIndex] = insertValue;
                }
            }
        }
    }
}
