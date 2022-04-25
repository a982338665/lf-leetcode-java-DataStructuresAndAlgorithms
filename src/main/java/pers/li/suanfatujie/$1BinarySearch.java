package pers.li.suanfatujie;

import java.util.Arrays;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2022/4/25 22:33
 * @Description : 二分算法：要求必须是顺序排列的数组
 * 每次都从中间开始找，直到找到为止  logN 即 2的几次幂等于N
 */
public class $1BinarySearch {

    public static void main(String[] args) {

        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6, 8, 9, 100};
        int x = 2;
        String[] strings = binarySearch(integers, 1);
        System.err.println(Arrays.toString(strings));
    }

    public static String[] binarySearch(Integer[] all, int x) {
        String[] strings = new String[2];
        int num = 0;
        //二分法查找
//        最小值下标
        int min = 0;
//        最大值下标
        int max = all.length - 1;
        while (min <= max) { //比较到最后一个为止
            num++;
            //猜的值下标
            int guessi = (min + max) / 2;
            //猜的值
            int guess = all[guessi];
            if (guess == x) {
                strings[0] = guessi + "";
                break;
            } else if (guess > x) {
                max = guessi - 1;
            } else if (guess < x) {
                min = guessi + 1;
            }
        }
        strings[1] = num + "";
        return strings;
    }
}
