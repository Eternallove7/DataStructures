package com.study.search;

import java.util.Arrays;

/**
 * @author RenAshbell
 * @create 2022-05-10-9:56
 */
public class FibonacciSearch {
    public static int MAXSIZE = 20;
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1234};
        System.out.println("index=" + fibSearch(arr,1234));

    }

    // 因为后面需要使用斐波那契数列, 因此要先获取一个斐波那契数列
    //  非递归方法得到一个斐波那契数列
    public static int[] fib(){
        int[] f = new int[MAXSIZE];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < MAXSIZE; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }
    // 编写斐波那契查找算法

    /**
     *
     * @param a 数组
     * @param key 需要查找的关键码(值)
     * @return 返回对应的下标, 如果没有-1
     */
    public static int fibSearch(int[] a,int key){
        int low = 0;
        int high = a.length - 1;
        int k = 0;// 表示斐波那契分割数值的下标
        int mid = 0;// 存放mid值
        int[] f = fib();// 获取到斐波那契数列
        // 获取到斐波那契
        while (high > f[k] - 1){
            k++;
        }
        // 因为f[k]值可能大于a的长度, 因此我们需要使用Arrays类, 构造一个新的数组, 并指向temp[]
        // 不足的部分使用0填充
        int[] temp = Arrays.copyOf(a,f[k]);
        // 实际上需求使用a数组最后的数组填充temp
        // 举例
        // temp = {1,8,10,89,1000,1234,0,0} => {1,8,10,89,1000,1234,1234,1234}
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }

        // 使用while来循环处理, 找到我们的数key
        while (low <= high){
            mid = low + f[k-1]-1;
            if (key < temp[mid]){//  我们应该继续向数组的前面查找(左边)
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {// 我们应该继续向数组的后面查找(右边)
                low = mid + 1;
                k-=2;
            } else {
                if (mid <= high){
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
