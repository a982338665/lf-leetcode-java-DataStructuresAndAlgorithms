package pers.li.book_tjsf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static pers.li.book_tjsf.TestData.listArray;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2022/9/4 10:57
 * @Description : 快速排序 nlogN
 * 定义基准值，分左右两边
 * 左右两边继续重复以上动作完成排序
 * 最好的情况下：
 * 对于无序数组，基准值选在中间，每次使用二分法分成左右两边数组其时间复杂度都为 栈高度logn,但是每层调用都是N因此为nlogn
 * 对于有序数组，基准值若选为第一个，则栈高度为N，而每层调用时间为N，因此为N^2，所以最坏的情况下时间复杂度为n^2
 *
 * C*O(n)大O表示法中的常量有时候作用很大，比如快速排序比合并排序的速度更快的原因即是如此
 */
public class $4_4快速排序 {

    public static void main(String[] args) {
        List<Integer> min = getIndex(listArray);
        System.err.println(min);

    }


    public static List<Integer> getIndex(List<Integer> arr) {
//        递归的基准条件
        if (arr.size() == 0) {
            return new ArrayList<>();
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
//        选择基准值
        Integer zhun = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            Integer curr = arr.get(i);
            if (curr > zhun) {
                right.add(curr);
            } else {
                left.add(curr);
            }
        }
        List<Integer> index = getIndex(left);
        List<Integer> index1 = getIndex(right);
        index.add(zhun);
        return Stream.of(index, index1)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }


}
