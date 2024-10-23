package pers.li.bili;

import java.util.Arrays;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2024/10/22 19:14
 * @Description : 时间复杂度O(n^2),额外空间复杂度O(1)。
 * 找到最小值，换位置
 */
public class $2_选择排序 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 99, 0, 33, 5};
        process1(arr);
        System.err.println(Arrays.toString(arr));
    }

    public static void process1(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
//        1、在i到n-1中找最小值，然后把最小值放到i位置上去，下标0到N-1，其实就是第一个到最后一个
//        2、找到最小值的下标和当前处理的下标为i的数据交换位置
        for (int i = 0; i < arr.length; i++) {
//            3、在整个过程中，开辟的空间有i,j,minIndex，且minIndex，用完即释放，有限变量来维持此算法，所以额外空间复杂度是O(1)
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (j != i) {
//            int temp = arr[i];
//            arr[i] = arr[minIndex];
//            arr[minIndex] = temp;
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }

}
