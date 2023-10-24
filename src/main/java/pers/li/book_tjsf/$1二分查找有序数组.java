package pers.li.book_tjsf;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2022/9/4 10:57
 * @Description : 比较猜的数字和找的数字是否一致
 * log2^N
 */
public class $1二分查找有序数组 {

    public static void main(String[] args) {
        int index = getIndex(TestData.sortArray, 3);
        System.err.println(index);
    }

    public static int getIndex(Integer[] array, int ele) {
        int min = 0;
        int max = array.length;
//        循环条件
        while (min <= max) {
            int mid = (min + max) / 2;
            int guess = array[mid];
//            基线条件
            if (guess == ele) {
                return mid;
            } else if (guess > ele) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return -1;
    }


}
