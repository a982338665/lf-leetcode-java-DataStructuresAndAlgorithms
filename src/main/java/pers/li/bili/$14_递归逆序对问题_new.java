package pers.li.bili;


/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2024/10/22 19:14
 * 逆序对问题是指在一个数组中，找到所有满足 i < j 且 nums[i] > nums[j] 的数对 (i, j)。
 * 解决这个问题的一个高效方法是使用归并排序的思想，因为归并排序在合并过程中可以顺便统计逆序对的数量。
 * @Description : 逆序对问题 在一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对，请打印所有逆序对。或者找到 逆序对个数
 * 32450
 * 求右边的数有多少个比左边的数小
 * 3:2个
 * 2:1个
 * 4:1个
 * 5:1个 总计 5个
 */
public class $14_递归逆序对问题_new {

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 0, 1, 1, 0};
        System.out.println(reversePairs(arr));
    }

    private static int reversePairs(int[] arr) {
        if (arr == null || arr.length == 1) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int count = 0;
        while (p1 <= mid && p2 <= r) {
//                不越界
            if (arr[p1] > arr[p2]) {
                count += r - p2 + 1;
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        System.arraycopy(help, 0, arr, l, help.length);
        return count;
    }
}
