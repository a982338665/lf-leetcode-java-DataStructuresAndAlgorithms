package pers.li.bili;

import java.util.Arrays;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2024/10/22 19:14
 * @Description : 时间复杂度O(n^2),额外空间复杂度O(1)。
 * 相邻位置比大小，大的向右移动，每迭代一次，都能找到当前最大值，即依次确定的位置为 N，N-1，N-2，依次类推。从大到小
 */
public class $3_冒泡排序 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 99, 0, 33, 5};
        process1(arr);
        System.err.println(Arrays.toString(arr));
    }

    public static void process1(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
//        1、比较N次
        for (int i = 0; i < arr.length; i++) {
//            2、第一次比较数组所有内容，两两交换，确定最后一个数字是最大的那个
//            3、第二次比较除去最后一个数字的，两两交换，确定倒数第二大数字
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (j != i) {
//            int temp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = temp;
//            ^运算，不同为1相同为0的计算方式，无进位相加
//            a: 10110
//            b: 00111
//            和：10001  满二不进1
//          int a = 甲
//          int b = 乙
//          a = a ^ b;   a=甲^乙 b=乙
//          b = a ^ b;   b=甲^乙^乙=甲^0=甲 a=甲^乙
//          a = a ^ b;   a=甲^乙^甲=乙^0=乙 b=甲
//          前提条件：i和j不能用同一块内存区域
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }

}
