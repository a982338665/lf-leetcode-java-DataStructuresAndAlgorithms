package pers.li.book_tjsf;

import java.util.ArrayList;
import java.util.List;

import static pers.li.book_tjsf.TestData.listArray;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2022/9/4 10:57
 * @Description :
 * [1,2,3,4]
 * 基线条件：取一个加一个，最后一个直接返回
 * 递归条件：加和
 */
public class $4_2递归计算数组和 {

    public static void main(String[] args) {
        int min = getIndex(listArray);
        System.err.println(min);

    }


    public static int getIndex(List<Integer> arr) {
        if (arr.size() == 0) {
            return 0;
        }
        int curr = arr.get(0);
        ArrayList<Integer> integers = new ArrayList<>(arr);
        integers.remove(0);
        return curr + getIndex(integers);
    }


}
