package pers.li.bili;


import java.util.Arrays;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2024/10/22 19:14
 * @Description :
 * 给定一个数num，请把小于等于num的数放在数组的左边，大于num的数放在数组的右边。要求额外空间复杂度0(1)，时间复杂度0(N)
 * 只要求分开，不要求有序
 */
public class $15_大于小于num的数分开 {

    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 7, 4, 3, 5, 8};
        process(arr, 5);
        System.out.println(Arrays.toString(arr));
    }


    public static void process(int[] arr, int num) {
        int left = 0;
        int i = 0;
        while (i <= arr.length - 1) {
            int curr = arr[i];
//            当前的和左区间的不相等，并且 当前<=num,[i]和小于等于区的下一个数交换，<=区右扩，i++
            if (curr <= num) {
                swap(arr, i, left);
                left++;
            }
            i++;
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }
}
