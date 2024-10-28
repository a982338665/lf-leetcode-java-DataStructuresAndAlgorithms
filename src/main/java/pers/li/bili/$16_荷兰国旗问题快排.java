package pers.li.bili;


import java.util.Arrays;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2024/10/22 19:14、
 * @Description :给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间，
 * 大于num的数放在数组的 右边。要求额外空间复杂度0(1)，时间复杂度O(N)
 */
public class $16_荷兰国旗问题快排 {

    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 7, 4, 3, 5, 8};
        process(arr, 5);
        System.out.println(Arrays.toString(arr));
    }


    public static void process(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        int i = 0;
        while (i <= right) {
            int curr = arr[i];
            if (curr < num) {
                swap(arr, i, left);
                left++;
                i++;
            }
            if (curr == num) {
                i++;
            }
            if (curr > num) {
                swap(arr, i, right);
                right--;
            }
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }
}
