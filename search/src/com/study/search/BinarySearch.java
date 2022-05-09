package com.study.search;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author RenAshbell
 * @create 2022-05-09-9:36
 */
// 使用二分查找的前提是, 该数组是有序的
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,8,10,98,100,147};
        int resIndex = binarySearch(arr,0,arr.length - 1,11);
        System.out.println("resIndex="+resIndex);

        int[] arr2 = {2,5,8,9,46,47,55,55,101};
        ArrayList<Integer> resIndexList = binarySearch2(arr2, 0, arr2.length - 1, 55);
        System.out.println(resIndexList);
    }

    // 二分查找算法

    /**
     *
     * @param arr 数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param findVal 要查找的值
     * @return 如果找到就返回下标, 如果没有就返回-1
     */
    public static int binarySearch(int[] arr,int left,int right,int findVal){
        // 当left > right时, 说明递归完毕, 但是没有找到
        if (left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal){ //向右递归
            return binarySearch(arr,mid + 1,right,findVal);
        } else if (findVal < midVal){ //向左递归
            return binarySearch(arr,left,mid-1,findVal);
        } else {
            return mid;
        }
    }

    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal){
        // 当left > right时, 说明递归完毕, 但是没有找到
        if (left > right){
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal){ //向右递归
            return binarySearch2(arr,mid + 1,right,findVal);
        } else if (findVal < midVal){ //向左递归
            return binarySearch2(arr,left,mid-1,findVal);
        } else {
            ArrayList<Integer> resIndex =  new ArrayList<>();
            int temp = mid - 1;
            while (true){
                if (temp < 0 || arr[temp] != findVal){
                    break;
                }
                // 否则就temp放入到resIndex
                resIndex.add(temp);
                temp -= 1;
            }
            resIndex.add(mid);// 中间的索引
            temp = mid + 1;
            while (true){
                if (temp > arr.length || arr[temp] != findVal){
                    break;
                }
                // 否则就temp放入到resIndex
                resIndex.add(temp);
                temp += 1;
            }
            return resIndex;
        }
    }
}
