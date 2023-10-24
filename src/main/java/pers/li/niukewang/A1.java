package pers.li.niukewang;

import java.util.Scanner;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2021/2/26 15:38
 * @Description :
 */
public class A1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        String[] strings = str.split("\\s+");//从空白字符处分割字符串，“+”表示匹配1到无穷，“*”表示匹配0到无穷。
        int length = strings[strings.length - 1].length();//最后一个字符串的长度
        System.out.println(length);
    }
}
