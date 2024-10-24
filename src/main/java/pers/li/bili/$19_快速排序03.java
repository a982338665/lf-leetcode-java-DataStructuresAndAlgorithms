package pers.li.bili;


import java.util.Arrays;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2024/10/22 19:14、
 * @Description :首次 随机选一个值作为num，将数组分为左右两个部分，中间=num部分，左边的元素都小于num，右边的元素都大于num，然后递归处理左右两个部分
 * 其实就是划分值为随机值，各种情况相加最后得到的时间复杂度为O(nlogn)
 */
public class $19_快速排序03 {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
//            等概率随机选择一个位置，与最右边的位置做交换
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
//            返回划分值左边界和右边界
            int[] p = partitionV2(arr, L, R);
//             <区
            quickSort(arr, L, p[0] - 1);
//             >区
            quickSort(arr, p[1] + 1, R);
        }
    }

    private static int[] partitionV2(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
//                <区
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
//                >区
                swap(arr, --more, L);
            } else {
//                相等，L++
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int L, int R) {
        if (L != R) {
            arr[L] = arr[L] ^ arr[R];
            arr[R] = arr[L] ^ arr[R];
            arr[L] = arr[L] ^ arr[R];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 99, 0, 33, 5};
        quickSort(arr);
        System.err.println(Arrays.toString(arr));
    }
}
