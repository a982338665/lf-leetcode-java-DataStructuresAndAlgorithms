package pers.li.xian;

/**
 * create by lishengbo 2018/7/8
 *
 * 换硬币问题：一元硬币换成1分，两分，五分的硬币，一共50枚
 * 1.
 */
public class test1 {

    public static void main(String[] args) {
        huanyingbiO3();
        huanyingbiO2();
        huanyingbiOLast();
        huanyingbiON();
    }

    /**
     * 换硬币问题：一元硬币换成1分，两分，五分的硬币，一共50枚
     * 时间复杂度O(3)实现
     * 1.分析：
     *   分别设置为,x,y,z个硬币
     *   表达式：
     *   x+y+z=50
     *   x+2y+5z=100
     * 2.代码编写：三重循环--时间复杂度为：O(n^3)
     *   强行计算：循环次数：50*50*50
     */
    public static void huanyingbiO3(){
        int x,y,z;
        for (x=1;x<=50;x++){
            for (y=1;y<=50;y++) {
                for (z=1;z<=50;z++) {
                    if(x+y+z==50&&(x+2*y+5*z)==100){
                        System.out.println(x+"|"+y+"|"+z);
                    }
                }
            }
        }
    }

    /**
     * 两层循环计算：时间复杂度为O(n^2):
     * 分析：一旦确定1分，2分的个数，即可确定5分的个数
     * 计算：
     *   x+y+z=50
     *   x+2y+5z=100
     *   可以转换为：两个可变未知数，进行2次循环即可得出
     *   z=50-x-y
     *   x+2y+5(50-x-y)=100
     * 强行计算：循环次数：50*50
     */
    public static void huanyingbiO2(){
        int x,y,z;
        for (x=1;x<=50;x++){
            for (y=1;y<=50;y++) {
               z=50-x-y;
               if(x+2*y+5*(50-x-y)==100){
                   System.out.println("O(n^2)复杂地计算结果："+x+"|"+y+"|"+z);
               }
            }
        }
    }

    /**
     * 优化：
     * 由于5分的硬币不可能超过20枚；所以循环中5分 可以最多循环20次
     * 由于2分的硬币不可能超过50枚--
     */
    public static void huanyingbiOLast(){
        //分别为5,2,1
        int x,y,z;
        for (x=1;x<20;x++){
            for (y=1;y<50;y++) {
               z=50-x-y;
               if(5*x+2*y+z==100){
                   System.out.println("O(n^2)复杂地计算结果：---简化版"+x+"|"+y+"|"+z);
               }
            }
        }
    }


    /**
     * 单层循环问题解决：
     *   x+y+z=50
     *   x+2y+5z=100
     * 相减：
     *   y+4z=50
     *   外层循环设为z，z最大不超过13(因为13*4=52)
     *   循环次数=13，复杂度为O(n)
     *  编程如下：--
     */
    public static void huanyingbiON(){
        int x,y,z;
        for (z=1;z<13;z++){
             y=50-4*z;
             x=50-y-z;
            System.out.println("时间复杂度为O(1)-循环13次，为常数"+x+"|"+y+"|"+z);
        }
    }



}
