package pers.li.bili;

import java.util.Arrays;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2024/10/22 19:14
 * @Description : 时间复杂度O(n^2),额外空间复杂度O(1)。插入排序相对比选择，冒泡好些
 * 将新数据插入已经排好序的列中，插入排序的 时间复杂度与数据情况有关，例如
 * 7654321
 * 6754321 处理6的数据，向前<7跟7交换。换1次。
 * 5674321 处理5的数据，向前<7跟7交换，继续向前判断，<6.跟 6交换，换2次。
 * 4567321 处理4的数据，向前<7跟7交换，继续向前判断，<6.跟 6交换，继续向前判断，<5.跟 5交换，换3次。
 * ... 此时为等差数列，时间复杂度为O(n^2)
 * 如果是1234567
 * 只需要判断一次，此时时间复杂度为O(n)
 */
public class $6_插入排序 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 99, 0, 33, 5};
        process1(arr);
        System.err.println(Arrays.toString(arr));
    }

    public static void process1(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
//        遍历第二个到最后一个
        for (int i = 1; i < arr.length; i++) {
//            与前一个元素比较，如果前一个元素大于当前元素，则交换位置
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
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
