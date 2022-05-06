package com.study.sort;

import java.util.Arrays;

/**
 * @author RenAshbell
 * @create 2022-05-06-10:47
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53,3,542,748,14,214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    // 基数排序方法
    public static void radixSort(int[] arr){

        int[][] bucket = new int[10][arr.length];

        // 为了记录每个桶中, 实际存放了多少个数据, 我们定义一个一维数组来记录各个桶的每次放入的数据个数
        int[] bucketElementCounts = new int[10];

        // 得到最大的数的位数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }

        // 得到最大数是几位数
        int maxLength = (max + "").length();

        for (int i = 0,n = 1; i < maxLength; i++,n*=10) {
            for (int j = 0;j < arr.length;j++){
                // 取出每个元素的对应位的值
                int digitOfElement = arr[j] / n % 10;
                // 放入到对应的桶中
                // 比如53 -> 3 -> bucket[3][0]
                // bucketElementCounts[3] 则代表第3个桶的元素个数
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            // 按照这个桶的顺序, 放入原来的数组
            int index = 0;
            // 遍历每一个桶, 并将桶中的数据放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 如果桶中有数据, 我们才放入到原数组
                if (bucketElementCounts[k] != 0){
                    // 循环该桶即第k个桶(即第k个一维数组), 放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        // 取出元素放入到arr中
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                // 第i+1轮处理后, 需要将每个bucketElementCounts[k] = 0
                bucketElementCounts[k] = 0;
            }
        }
        
        /*
        
        // 第一轮(针对每个元素的个位进行排序处理)

        // 定义一个二维数组, 表示10个桶, 每个桶就是一个一维数组
        // 说明
        // 1.二维数组包含10个一维数组
        // 2.为了防止在放入数的时候, 数据溢出, 则每个一维数组即桶, 大小只能定为arr.length
        // 3.明确, 基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        // 为了记录每个桶中, 实际存放了多少个数据, 我们定义一个一维数组来记录各个桶的每次放入的数据个数
        int[] bucketElementCounts = new int[10];

        for (int j = 0;j < arr.length;j++){
            // 取出每个元素的个位
            int digitOfElement = arr[j] % 10;
            // 放入到对应的桶中
            // 比如53 -> 3 -> bucket[3][0]
            // bucketElementCounts[3] 则代表第3个桶的元素个数
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }

        // 按照这个桶的顺序, 放入原来的数组
        int index = 0;
        // 遍历每一个桶, 并将桶中的数据放入到原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            // 如果桶中有数据, 我们才放入到原数组
            if (bucketElementCounts[k] != 0){
                // 循环该桶即第k个桶(即第k个一维数组), 放入
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    // 取出元素放入到arr中
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            // 第1轮处理后, 需要将每个bucketElementCounts[k] = 0
            bucketElementCounts[k] = 0;
        }
        System.out.println(Arrays.toString(arr));

        // =============================================
        // 第2轮(针对每个元素的十位进行排序)
        for (int j = 0;j < arr.length;j++){
            // 取出每个元素的个位
            int digitOfElement = arr[j] /10 % 10;
            // 放入到对应的桶中
            // 比如53 -> 3 -> bucket[3][0]
            // bucketElementCounts[3] 则代表第3个桶的元素个数
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }

        // 按照这个桶的顺序, 放入原来的数组
        index = 0;
        // 遍历每一个桶, 并将桶中的数据放入到原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            // 如果桶中有数据, 我们才放入到原数组
            if (bucketElementCounts[k] != 0){
                // 循环该桶即第k个桶(即第k个一维数组), 放入
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    // 取出元素放入到arr中
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

         */


    }
}
