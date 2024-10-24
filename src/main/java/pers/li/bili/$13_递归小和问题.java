package pers.li.bili;


/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2024/10/22 19:14
 * @Description : 在一个数组中，每一个数左边比当前数小的数累加起来，
 * 叫做这个数组的小和。求一个数组的小和。
 * 例子:[1,3,4,2,5]1左边比1小的数，没有;
 * 3左边比3小的数，1;
 * 4左边比4小的数，1、3;
 * 2左边比2小的数，1;
 * 5左边比5小的数，1、3、4、2;
 * 所以小和为1+1+3+1+1+3+4+2=16
 * -------------------------------
 * 换思路：
 * [1,3,4,2,5]
 * 第一个：求右边有几个数比1大：1*4
 * 第二个：求右边有几个数比3大：3*2
 * 第三个：求右边有几个数比4大：4*1
 * 第四个：求右边有几个数比2大：2*1
 * 加和 = 16
 */
public class $13_递归小和问题 {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        System.out.println(smallSum(arr));
    }

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return processV2(arr, 0, arr.length - 1);
    }

    /**
     * 既要排好序也要求小和
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int processV2(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
//        返回左侧排序求小和数量 + 右侧排序求小和数量 + 左右合并merge求小和数量
        return processV2(arr, l, mid) + processV2(arr, mid + 1, r) + mergeV3(arr, l, mid, r);
    }

    private static int mergeV3(int[] arr, int l, int mid, int r) {
//        [1,3,4,2,5]  l=0 mid=2 r=5
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
//        都没有下标越界的时候
        while (p1 <= mid && p2 <= r) {
//            只有左组比右组小，才算小和，
            if (arr[p1] < arr[p2]) {
//                计算方式为 个数* 当前数（即小的这个数）
                res += (r - p2 + 1) * arr[p1];
                help[i++] = arr[p1++];
            } else {
//                如果大于或者等于，先移动右边的数，不满足条件不计算
                help[i++] = arr[p2++];
            }
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
        return res;
    }

}
