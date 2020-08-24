package pers.li.java;

/**
 * create by lishengbo 2018/7/9
 * 冒泡排序：两两比较，将较大的放在后面或前面
 * 双重for循环，时间复杂度为O(n^2)
 */
public class maopao {

    public static void main(String[] args) {

        int[] a={4,1,8,9,5,3,4};
        sortShengXU(a);
        System.out.println();
        sortJiangXu(a);
    }

    private static void sortShengXU(int[] a) {
        int len=a.length;

        //外层循环：循环所有元素
        for (int i = 0; i < len; i++) {
            //内层循环决定前后交换次数
            for(int j=0;j<len-i-1;j++){//注意第二重循环的条件
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        for (int i = 0; i <len ; i++) {
            System.out.print(" "+a[i]);
        }
    }
    //降序排列：
    private static void sortJiangXu(int[] a) {
        int len=a.length;

        //外层循环：循环所有元素
        for (int i = 0; i < len; i++) {
            //内层循环决定前后交换次数
            for(int j=0;j<len-i-1;j++){//注意第二重循环的条件
                if(a[j]<a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        for (int i = 0; i <len ; i++) {
            System.out.print(" "+a[i]);
        }
    }
}
