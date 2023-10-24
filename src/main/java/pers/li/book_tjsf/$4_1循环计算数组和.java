package pers.li.book_tjsf;

import java.util.List;

import static pers.li.book_tjsf.TestData.listArray;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2022/9/4 10:57
 * @Description :
 */
public class $4_1循环计算数组和 {

    public static void main(String[] args) {
        int min = getIndex(listArray);
        System.err.println(min);

    }


    public static int getIndex(List<Integer> arr) {
        final int[] finalX = {0};
        arr.forEach(e -> {
                    finalX[0] = finalX[0] + e;
                }
        );
        return finalX[0];
    }


}
