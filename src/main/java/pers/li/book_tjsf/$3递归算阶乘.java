package pers.li.book_tjsf;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2022/9/4 10:57
 * @Description : 计算N的阶乘
 * 基线条件
 * 递归条件:
 * 4*3*2*1
 * 4*（3*（2*1））
 */
public class $3递归算阶乘 {

    public static void main(String[] args) {
        int min = getIndex(4);
        System.err.println(min);

    }


    /**
     * 可根据压栈出栈进行分析获取值
     *
     * @param x
     * @return
     */
    public static int getIndex(int x) {
        if (x == 1) {
            return 1;
        }
        return x * getIndex(x - 1);
    }


}
