package pers.li.bili;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2024/10/22 19:14
 * @Description : 以下示例：为证明当 时间复杂度一致时，比的不是常数项。，而是常数项所运行的时间，因为你不清楚它里面是使用的位运算还是算数运算，而位运算要快于算数运算
 */
public class $1_testFN {

    public static void main(String[] args) {

    }

    public static void process1() {
        int a = 1;
        int x = 1000;
        for (int i = 0; i < x; i++) {
            a = 2 + 5;
            a = 4 * 7;
        }
    }

    public static void process2() {
        int a = 1;
        int x = 10000;
        for (int i = 0; i < x; i++) {
            a = 3 | 6;
            a = 3 & 4;
        }
    }
}
