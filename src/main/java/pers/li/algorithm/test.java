package pers.li.algorithm;

import javax.sound.midi.SoundbankResource;

/**
 * create by lishengbo 2018/7/5
 */
public class test {

    public static void main(String[] args) {

        System.out.println(getJieCheng(4));
        System.out.println(getJieCheng_DIGUI(4));
        getXResult();
    }

    /**
     * 求阶乘 9！--循环
     * @return
     */
    public static int getJieCheng(int x){
        int num=1;
        for (int i = 1; i <= x; i++) {
            num*=i;
        }
        return num;
    }

    /**
     * 递归求阶乘
     * @param x
     * @return
     */
    public static  int getJieCheng_DIGUI(int x){
        if(x==1){
            return 1;
        }
        return x*getJieCheng_DIGUI(x-1);
    }


    /**
     * 大数字运算，利用数组--进位和留位
     *  732 * 16
     * @return
     */
    public static int[] getXResult( ){
        int [] ints=new int[6];
        //732--作为高位放入数组最后三位
        ints[ints.length-1]=2;
        ints[ints.length-2]=3;
        ints[ints.length-3]=7;

        int num=16;
        //计算每一位结果
        for (int i = 0; i < ints.length; i++) {
            ints[i]*=num;
        }
        //进位和留位--从后向前
        for (int i = ints.length-1; i >0 ; i--) {
            //进
            ints[i-1]+=ints[i]/10;
            //留
            ints[i]=ints[i]%10;
        }
//        System.out.println(ints);
        for (int i = 0; i <ints.length ; i++) {
            System.out.print(ints[i]);
        }

        
        
        


        return null;
    }

}
