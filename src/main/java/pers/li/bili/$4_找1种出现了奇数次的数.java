package pers.li.bili;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2024/10/22 19:14
 * @Description : 要求时间复杂度 O（N），空间复杂度O（1）
 * 找到数组中出现奇数次的一个数
 * 思路：
 * 申明 eor = 0,将数组中的每一个元素与EOR进行^运算，最后剩下的就是奇数次的那个数
 * 原因：出现偶数次，则意味着相互与运算 = 0（因为与运算中，不同为1，相同为0），
 * 例如 2,2,3,3,3,1,1
 * 所以 2,2=0 1,1=0 3^3^3=3
 * 所以所有偶数与运算后结果为1，所以最终结果就是奇数次的那个数
 */
public class $4_找1种出现了奇数次的数 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3, 3, 3, 3, 5, 5, 5, 6, 6};
        int i = process1(arr);
        System.err.println(i);
    }

    public static int process1(int[] arr) {
        int eor = 0;
//        for (int i : arr) {
//            eor ^= i;
//        }
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        return eor;
    }


}
