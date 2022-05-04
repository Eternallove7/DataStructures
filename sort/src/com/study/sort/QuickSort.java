package com.study.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author RenAshbell
 * @create 2022-05-04-10:07
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {-9,78,0,23,-567,70};
//        quickSort(arr,0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000;i++){
            arr[i] = (int) (Math.random() * 8000000);// 生成一个[0,8000000)数
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是=" + date1Str);

        // 测试快速排序
        quickSort(arr,0, args.length-1);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序前的时间是=" + date2Str);

    }

    public static void quickSort(int [] arr,int left,int right){
        int l = left;
        int r = right;

        // pivot 中轴值
        int pivot = arr[(left + right) / 2];

        int temp = 0;// 交换时使用
        // while循环的目的是让比pivot小的值放到左边
        // 比pivot值大的放到右边
        while (l < r){
            // 在pivot的左边一直找, 找到大于或等于pivot的值
            while (arr[l] < pivot){
                l += 1;
            }
            // 在pivot的右边一直找, 找到小于或等于pivot的值
            while (arr[r] > pivot){
                r -= 1;
            }
            // 如果l >= r 说明pivot左右两边的值, 已经按照左边全部是小于等于pivot
            if (l >= r){
                break;
            }

            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 如果交换完后, 发现arr[l] == pivot值 相等 --, 前移
            if (arr[l] == pivot){
                r -= 1;
            }
            // 如果交换完后, 发现arr[r] == pivot值 相等 ++, 后移
            if (arr[r] == pivot){
                l += 1;
            }
        }
        // 如果l == r, 必须l++ ,r-- ,否则会出现栈溢出
        if (l == r){
            l += 1;
            r -= 1;
        }
        // 向左递归
        if (left < r) {
            quickSort(arr,left,r);
        }
        // 向右递归
        if (right > l){
            quickSort(arr,l,right);
        }
    }
}
