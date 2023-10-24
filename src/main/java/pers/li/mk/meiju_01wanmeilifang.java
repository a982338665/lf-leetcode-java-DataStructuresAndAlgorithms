package pers.li.mk;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2023/6/6 14:59
 * @Description : 枚举 - 完美立方
 * a^3 = b^3+c^3+d^3
 * 输出按从小到大输出
 * 输出数字N内的完美立方式
 */
public class meiju_01wanmeilifang {

    /**
     * a 的枚举范围：【2，n】
     * b [2,a-1]
     * c [b,a-1]
     * d [c,a-1]
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 24;
/**
 * 6  3  4  5
 * 12  6  8  10
 * 18  2  12  16
 * 18  9  12  15
 * 19  3  10  18
 * 20  7  14  17
 * 24  12  16  20
 */
        for (int a = 2; a <= n; a++) {
            for (int b = 2; b < a; ++b) {
                for (int c = b; c < a; c++) {
                    for (int d = c; d < a; d++) {
                        if (a * a * a == b * b * b + c * c * c + d * d * d) {
                            System.err.printf("%s  %s  %s  %s  \n", a, b, c, d);
                        }
                    }
                }
            }
        }
    }
}
