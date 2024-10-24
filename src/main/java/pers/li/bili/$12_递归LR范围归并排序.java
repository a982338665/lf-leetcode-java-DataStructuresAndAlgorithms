package pers.li.bili;


import java.util.Arrays;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2024/10/22 19:14
 * @Description :
 * 使用master公式计算时间复杂度：
 *  T(n) = 2T(n/2) + mergeV2的时间复杂度
 *  左侧：left->Mid 右侧：Mid->right
 *  最后copy到原数组：所以复杂度为 O(N)
 *  所以最后为
 *   T(n) = 2T(n/2) + O(N)
 *   时间复杂度为：O(NlogN)，额外空间复杂度为O(N)，用来merge，每次都是用完即释放，最多的空间就是长度为N的空间
 *   之前说的选择，冒泡，插入都是O(N^2)，为什么会比那个好？？？
 *   因为那三个大量浪费了比较行为才搞定了一个数，而归并排序，是把左右两侧的数排序好，然后合并，相比 而言是没有浪费比较行为的
 *   实际可以理解为：切分为有序的小块，利用辅助空间，比较每个小块每个位置的数据，进行合并，所以其实并没有浪费比较行为
 */
public class $12_递归LR范围归并排序 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 90, 5, 6, 7, 8, 9, 10, 99, 0, 33, 6, 7, 8, 9};
        process(arr, 0, arr.length - 1);
        System.err.println(Arrays.toString(arr));
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
//        二分中位数
        int mid = L + ((R - L) >> 1);
//        左侧有序
        process(arr, L, mid);
//        右侧有序
        process(arr, mid + 1, R);
//        marge左右两侧
        mergeV2(arr, L, mid, R);
    }

    private static void mergeV2(int[] arr, int left, int mid, int right) {
//        开辟辅助空间，存储左右两侧排序后的数据
        int[] help = new int[right - left + 1];
//        专门给help添值的下标
        int i = 0;
//        左侧开始位置
        int p1 = left;
//        右侧开始位置
        int p2 = mid + 1;
//        p1不越界的情况下，并且p2也不越界的情况下
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] <= arr[p2]) {
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
//            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
//        如果P1没越界，P2越界了，就将P1剩下的数据拷贝到help中
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
//        如果P2没越界，P1越界了，就将P2剩下的数据拷贝到help中
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
//        将临时辅助空间的数据复制到原数组中
        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j];
        }
    }
}
