package pers.li.bili;

import java.util.Arrays;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2024/10/22 19:14
 * @Description : 可以对比 数算法是否正确，使用常规写法得到的数据和自己实现的算法得到的结果数据，进行每一个的比对
 * ，指定随机数组，随机对比次数，来比较
 */
public class $10_对数器 {

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 99, 0, 33, 5};
//        process1(arr);
//        System.err.println(Arrays.toString(arr));
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean success = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            process1(arr1);
            Arrays.sort(arr2);
            System.err.println(i + "========" + Arrays.toString(arr1));
            System.err.println(i + "========" + Arrays.toString(arr2));
            if (!isEqual(arr1, arr2)) {
                success = false;
                break;
            }
        }
        System.err.println(success ? "Nice!" : "Fucking fucked!");


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

    public static int[] generateRandomArray(int maxSize, int maxValue) {
//        数组长度随机，1~maxSize
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private static void swap(int[] arr, int i, int j) {
        if (j != i) {
//          前提条件：i和j不能用同一块内存区域
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }

}
