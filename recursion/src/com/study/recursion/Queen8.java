package com.study.recursion;

/**
 * @author RenAshbell
 * @create 2022-04-28-21:06
 */
public class Queen8 {
    // 先定义一个max表示共有多少个皇后
    int max = 8;
    // 定义数组array, 保存皇后放置位置的结果, 比如arr=  {0,4,7,5,2,6,1,3}
    int[] array = new int[max];
    static int COUNT = 0;
    static int JUDGE = 0;
    public static void main(String[] args) {
        // 测试
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("一共有%d种解法",COUNT);
        System.out.printf("一共判断了%d次",JUDGE);
    }

    // 编写一个方法, 放置第n个皇后
    // 特别注意：check 是 每一次递归时, 进入到check中都有一套for循环
    private void check(int n){
        if (n == max){ // n = 8, 其实8个皇后已然放好
            print();
            return;
        }
        // 依次放入皇后并判断是否冲突
        // 这里的i为列
        for (int i = 0; i < max; i++) {
            // 先把当前这个皇后 n , 放到该行的第1列
            array[n] = i;
            // 判断当放置第n个皇后到i列时, 是否冲突
            if (judge(n)){ // 不冲突
                // 接着放n+1个皇后, 即开始递归
                check(n+1);
            }
            // 如果冲突, 就继续执行 array[n] = i;即将第n个皇后, 放置在本行的 后移一个位置
        }
    }

    // 查看当我们放置第n个皇后时, 就去检测该皇后是否和前已经摆放的皇后冲突
    /**
     *
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n){
        JUDGE++;
        for (int i = 0; i < n; i++) {
            // 说明
            // 1.array[i] == array[n] 表示判断 第n个皇后是否和前面的n-1个皇后在同一列
            // 2.Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i皇后是否在同一斜线
            // n = 1 放置第2列1 n = 1 array[1] = 1
            // 或后面的判断可以理解为 Math.abs(1 - 0) ==  Math.abs(1 - 0) 这样两个皇后就在同一斜线上
            /*
            假设两个皇后在同一斜线
            则 arr = [0,1]   // 数组下标为第几个皇后, 同时也是第几行
            表示
            皇后0 = [0,0] // 放置在0,0   0行0列
            皇后1 = [1,1] // 放置在1,1   1行1列
            |0-1| == |0-1| 因此只要是斜线, 他们的下标相减的绝对值 和 放置的列数相减的绝对值 是相等的
             */
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    // 写一个方法, 可以将皇后摆放的位置输出
    private void print(){
        COUNT++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
