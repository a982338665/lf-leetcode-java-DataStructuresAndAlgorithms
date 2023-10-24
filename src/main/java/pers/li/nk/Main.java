package pers.li.nk;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int a = in.nextInt();
//       a= 1*x+2*y
        int h = 0;
        for (int x = 0; x <= a; x++) {
            int y = (a - x) % 2;
            if (y == 0) {
                h++;
            }
        }
        System.err.println(h);
    }
}
