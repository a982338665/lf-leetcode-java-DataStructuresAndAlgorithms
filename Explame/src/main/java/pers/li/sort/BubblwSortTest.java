package pers.li.sort;

/**
 * create by lishengbo 2018/11/12
 * 冒泡排序实例：
 * 排序思想：最大的元素会经由交换慢慢“浮”到数列的顶端,两个两个换
 * 外层循环 length-1    整个比较过程需要length-1次
 * 内层循环 length-i-1:数据交换     每一次的比较完成都会将最大的数据移到最末尾，
 * 之后每次的比较都不需要末尾参加
 * 时间复杂度为：O(n^2)
 */
public class BubblwSortTest {

    /**
     * 比较次数记录：冒泡排序肯定会比较次数为-->n*(n-1)/2
     * 如此例:8个长度的数字需要比较28次
     */
    static  int count=0;

    public static void main(String[] args) throws InterruptedException {
        int[] sorts=new int[]{1,5,9,2,5,7,3,2};
        //升序冒泡-->大值往后换
        aseSort(sorts);
        Thread.sleep(1000);
        System.out.println("_____________________________________________"+count);
        count=0;
        //降序冒泡-->小值往后换
        descSort(sorts);
        System.out.println("_____________________________________________"+count);
    }

    private static void descSort(int[] sorts) throws InterruptedException {
        int temp=0;
        int length = sorts.length;//8
        //第一个循环:循环前7个值
        for (int i = 0; i < length-1 ; i++) {
            System.err.println("");
            System.err.print("第"+(i+1)+"次循环--->");
            //第二个循环:
            //first==i==0  second==j==7 循环7次 j[0-6] 第1个值和剩余7个值比较，将小的往后排
            //first==i==1  second==j==6 循环6次 j[0-5] 第2个值和剩余6个值比较，将小的往后排
            //first==i==2  second==j==5 循环5次 j[0-4] 第3个值和剩余5个值比较，将小的往后排
            //...
            //first==i==6  second==j==1 循环1次 j[0-1] 第3个值和剩余5个值比较，将小的往后排
            for (int j = 0; j< length-i-1; j++) {
                Thread.sleep(500);
                System.out.println();
                System.out.print("第"+(i+1)+"次循环--->第"+j+"次比较---->");
                count++;
                if(sorts[j]<sorts[j+1]){
                    temp=sorts[j];
                    sorts[j]=sorts[j+1];
                    sorts[j+1]=temp;
                }
                for (int k = 0; k < sorts.length; k++) {
                    System.out.print(sorts[k]+" ");
                }
            }
        }
        for (int i = 0; i <sorts.length ; i++) {
            System.out.println("---------------"+sorts[i]);
        }
    }

    private static void aseSort(int[] sorts) throws InterruptedException {
        int temp=0;
        int length = sorts.length;//8
        //第一个循环:循环前7个值
        for (int i = 0; i < length-1 ; i++) {
            System.err.println("");
            System.err.print("第"+(i+1)+"次循环--->");
            //第二个循环:
            //first==i==0  second==j==7 循环7次 j[0-6] 第1个值和剩余7个值比较，将小的往后排
            //first==i==1  second==j==6 循环6次 j[0-5] 第2个值和剩余6个值比较，将小的往后排
            //first==i==2  second==j==5 循环5次 j[0-4] 第3个值和剩余5个值比较，将小的往后排
            //...
            //first==i==6  second==j==1 循环1次 j[0-1] 第3个值和剩余5个值比较，将小的往后排
            for (int j = 0; j< length-i-1; j++) {
                Thread.sleep(500);
                System.out.println();
                count++;
                System.out.print("第"+(i+1)+"次循环--->第"+j+"次比较---->");
                if(sorts[j]>sorts[j+1]){
                    temp=sorts[j];
                    sorts[j]=sorts[j+1];
                    sorts[j+1]=temp;
                }
                for (int k = 0; k < sorts.length; k++) {
                    System.out.print(sorts[k]+" ");
                }
            }
        }
        for (int i = 0; i <sorts.length ; i++) {
            System.out.println("---------------"+sorts[i]);
        }
    }
}
