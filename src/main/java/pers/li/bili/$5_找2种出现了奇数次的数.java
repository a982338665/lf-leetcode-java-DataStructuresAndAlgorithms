package pers.li.bili;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2024/10/22 19:14
 * @Description :
 * 找出数组中，出现奇数次的，两个数
 * 假设数组中，出现奇数次的有两个数，例如 1,1,2,3,4,3,2,5,5,5
 * 设：eor=0，假设那两个数为a和b，继续 ^ 后可得 eor = a^b
 * 又因为是两个数所以a!=b,所以eor=a^b就一定不等于0
 * 所以eor的二进制表示中，一定有一位数不等于0，假设这是第8位，那么就使用
 * 变量eor2去亦或数组中每个元素的第8位是1的那些数，出现偶数次的依旧不做干扰，此时剩下的就是a或者b
 * 然后 eor ^ eor2 = a^b^a = b,就可以 知道这俩数是多少
 */
public class $5_找2种出现了奇数次的数 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3, 3, 3, 3, 5, 5, 5, 6, 6, 9, 9, 9, 9, 9};
        process1(arr);
    }

    public static void process1(int[] arr) {
        //eor = a^b eor!=0
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        //eor必然有一个位置上是1，因为a!=b,所以a^b后，二进制为1的数，必然a和b二进制位所在的该位置不相同
//        a：    1000101
//        b：    0010111
//        a^b:   1010010 (相同为0，不同为1)
        //此时就可以，提取出eor最右边的1，也就是说在此位上 a一定不等于b
//         eor:     1010111100
//      取反eor:     0101000011
//      取反eor+1：  0101000100
// eor & (取反eor+1) =  0000000100 (&运算，如果两个对应的位都是1，则结果位为1；否则为0)
//        ==================================================
//        提取最右侧的1
        int rightOne = eor & (~eor + 1);
//        ==================================================

        int onlyOne = 0;
        for (int i : arr) {
//            这个地方可以等于0或者1，因为
//            eor & (取反eor+1) =  0000000100，如果(i & rightOne) == 0,则证明取出来的该位置的为0，例如 *******000，
//            如果(i & rightOne) == 1,则证明取出来的该位置的为1，例如 *******100，由于 是奇数位，所以
//            如果(i & rightOne) == 0,则将该值^运算,假如他是a则，a^a^a = a,此时onlyOne的值为a
//            如果(i & rightOne) == 1,则将该值^运算,假如他是b则，b^b^b = b,此时onlyOne的值为b
//            因为此处任取一边即可，即可以=0或者=1
            if ((i & rightOne) == 0) {
                onlyOne ^= i;
            }
        }
        System.err.println(onlyOne + "    " + (eor ^ onlyOne));
    }


}
