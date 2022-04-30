package com.study.sort;

import java.util.Arrays;

/**
 * @author RenAshbell
 * @create 2022-04-30-23:32
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
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
}
