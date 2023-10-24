package pers.li.niukewang;

import java.util.Scanner;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2021/2/26 15:38
 * @Description :
 */
public class A2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();
        String str2 = scanner.nextLine().toLowerCase();
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (str2.charAt(0) == chars[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
