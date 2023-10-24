package pers.li.book_tjsf;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2022/9/4 10:57
 * @Description :
 * 一块土地，知道长x，宽y，寻找全部分成小方块的最大边长
 * 分析：
 * 80-80 不用分
 * 160 - 80 分一次
 * 340 - 80 ：
 * 80 - 80 分成4块
 * 20*80 接着分 分四块，因此最小的分块边长为20
 * 分而治之思想：D&C
 */
public class $4_3递归分土地 {

    public static void main(String[] args) {
        int min = getIndex(1680, 640);
        System.err.println(min);

    }


    public static int getIndex(int x, int y) {
        if (x > y) {
            int i = x % y;
            if (i==0) {
                return y;
            }
            return getIndex(i, y);

        } else if (x == y) {
            return x;
        } else {
            int i = y % x;
            if (i==0) {
                return x;
            }
            return getIndex(i, x);
        }
    }


}
