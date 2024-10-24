package pers.li.bili;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2024/10/22 19:14
 * @Description :
 * 递归结构图如下
 * [3,2,5,6,7,4]
 *  0,1,2,3,4,5
 *  P(arr,0,5):
 *      P(0,2)
 *          P(0,1)
 *              P(0,0)
 *              P(1,1)
 *          P(2,2)
 *      P(3,5)
 *          P(3,4)
 *              P(3,3)
 *              P(4,4)
 *          P(5,5)
 * 由上可知，递归结束条件为L=R
 * 使用master公式估算时间复杂度：
 * · T(n) = 2T(n/2)+O(1)
 *   第一个2指的调用了两次：
 *         int leftMax = max(arr, L, mid);
 *         int rightMax = max(arr, mid + 1, R);
 *    n/2指的是里面的数量分别为n/2
 *         max(arr, L, mid);
 *         max(arr, mid + 1, R);
 *    第三个O(1)指的是：
 *         int mid = L + ((R - L) >> 1);
 *         return Math.max(leftMax, rightMax);
 *  如果将LR之间的区域划分为均等三份分别求最大值，则时间复杂度公式为：
 *  T(n) = 3T(n/3)+O(1) ，3表示3次 n/3表示数据规模，也符合master公式
 *  如果将LR直接的区域分为两份，左边1/3，右边2/3，则时间复杂度为：
 *  T(n) = T(n/3)+T(2n/3)+O(1)，此时就不符合master公式
 */
public class $11_递归LR范围取最大值 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(max(arr, 0, arr.length - 1));
    }

    public static int max(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
//        二分中位数
        int mid = L + ((R - L) >> 1);
//        左最大
        int leftMax = max(arr, L, mid);
//        右最大
        int rightMax = max(arr, mid + 1, R);
//        求最大
        return Math.max(leftMax, rightMax);
    }
}
