package pers.li.bili;


import java.util.Arrays;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2024/10/22 19:14、
 * @Description :每次以最后一个值作为num，将数组分为左右两个部分，中间=num部分，左边的元素都小于num，右边的元素都大于num，然后递归处理左右两个部分
 * * 时间复杂度：O(N^2)最差的例子：1，2，3，4，5，6，7，8，9,以最后一个值划分的时候总是左部分，并且每次的递归都只能解决一个数字，所以等差数列的情况，时间复杂度是O(N^2)
 * 其实就是划分值打的太偏了
 * 当划分值打到中间的时候：根据master公式：T(N)=2T(N/2)+O(N)=O(NlogN),所以样本情况很好的情况下时间复杂度为O(NlogN)，当打的最偏的时候，时间复杂度为O(N^2)
 */
public class $18_快速排序02 {

    static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
//        定义基准值
        int key = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
//            循环找：从右向左找到第一个小于P的位置j
            while (i < j && arr[j] >= key) {
                j--;
            }
//            循环找：从左向右找到第一个大于P的位置i
            while (i < j && arr[i] <= key) {
                i++;
            }
            System.err.println("i:"+i+" j:"+j);
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, left, i);
        quickSort(arr, left, i - 1);
        quickSort(arr, i+ 1, right);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 33, 5};
        quickSort(arr, 0, arr.length - 1);
        System.err.println(Arrays.toString(arr));
    }
}
