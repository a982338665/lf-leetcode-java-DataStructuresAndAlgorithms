package pers.li.mk;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2023/6/6 14:59
 * @Description : 枚举 - 生理周期
 * 体力，情商，智商高峰分别，每间隔23天，28天，33天出现一次，计算什么时间这三天会落在同一时间
 * 三天分别为 p,e,i  给定日子为 d  输出时间间隔
 * 第一次为0 的时候最晚在经过21252 就会落在同一时间
 * （k-p）%23==0 && （k-e）%28==0 && （k-i）%33==0
 */
public class meiju_02shenglizhouqi {

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
