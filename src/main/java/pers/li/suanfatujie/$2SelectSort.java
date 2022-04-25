package pers.li.suanfatujie;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2022/4/25 22:33
 * @Description : 选择排序：每次比较都取出最小值放在另一个数组  ON^2 ，两个for循环比较
 */
public class $2SelectSort {

    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(4);
        integers.add(2);
        integers.add(4);
        integers.add(5);
        integers.add(7);
        integers.add(8);
        integers.add(100);
        ArrayList<Integer> strings = binarySearch(integers);
        System.err.println(strings.toString());
    }

    public static ArrayList<Integer> binarySearch(ArrayList<Integer> all) {
        //存放排好序的集合
        ArrayList<Integer> strings = new ArrayList<Integer>();
        //遍历无序集合,找到最小值
        for (int i = all.size() - 1; i >= 0; i--) {
            //假设第一个为最小值
            int smallIndex = 0;
            int small = all.get(0);
            for (int j = all.size() - 1; j >= 0; j--) {
                if (all.get(j) < small) {
                    small = all.get(j);
                    smallIndex = j;
                }
            }
            //拿到最小值及下标,放在新数组，并且在老数组中去掉最小值
            strings.add(small);
            all.remove(smallIndex);
        }
        return strings;
    }
}
