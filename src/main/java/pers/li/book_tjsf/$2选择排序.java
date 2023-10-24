package pers.li.book_tjsf;

import java.util.ArrayList;
import java.util.List;

import static pers.li.book_tjsf.TestData.listArray;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2022/9/4 10:57
 * @Description :
 * 从一个集合中选出最小的，然后移除该值
 * 重复以上步骤，直至排序完成
 * 分析基线条件：当数组长度为0，结束计算
 * 分析计算条件：给定一个数组，找出最小值 getMin(array)
 * 找出外部循环的基线条件：遍历每一个元素，每次取出最小值并且移除该元素
 * N^2
 * n+(n-1)+(n-2)+...+2+1 = (n(n+1))/2 约等于 n^2
 */
public class $2选择排序 {

    public static void main(String[] args) {
        List<Integer> min = getIndex(listArray);
        System.err.println(min);

    }


    /**
     * 获取数组中最小值的下标
     *
     * @param array
     * @return
     */
    public static int getMin(List<Integer> array) {
//        假设第一个数组元素为最小值
        int min = 0;
        int minVal = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) < minVal) {
                min = i;
                minVal = array.get(i);
            }
        }
        return min;
    }

    public static List<Integer> getIndex(List<Integer> array) {
        List<Integer> newArr = new ArrayList();
        for (int i = array.size() - 1; i >= 0; i--) {
            //取出当前数组最小值下标
            int min = getMin(array);
            //将最小值放在新数组
            newArr.add(array.get(min));
            //删除该数据,java中使用此种方式循环时，不能直接删除该数组元素
//            fori倒叙删除或者迭代器可以,此处随机删除，因此也不行需要重新声明
            List<Integer> cpArr = new ArrayList(array);
            //新建数组后移除旧值
            cpArr.remove(min);
            //重置数组为最新数组
            array = cpArr;
        }
        return newArr;
    }


}
