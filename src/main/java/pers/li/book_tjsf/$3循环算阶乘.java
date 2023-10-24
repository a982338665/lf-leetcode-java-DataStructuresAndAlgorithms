package pers.li.book_tjsf;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2022/9/4 10:57
 * @Description : 计算N的阶乘
 */
public class $3循环算阶乘 {

    public static void main(String[] args) {
        int min = getIndex(4);
        System.err.println(min);

    }


    public static int getIndex(int x) {
        int finalX = 1;
        for (int i = 1; i <= x; i++) {
            finalX = finalX * i;
        }
        return finalX;
    }


}
