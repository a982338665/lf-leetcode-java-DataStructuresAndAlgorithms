package pers.li.zk;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2022/11/1 14:11
 * @Description :
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点
 * 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新
 * 如果可以一直跳到最后，就成功了
 * <p>
 * 方法：初始化最远位置为 0，然后遍历数组，如果当前位置能到达，并且当前位置+跳数>最远位置，就更新最远位置。最后比较最远位置和数组长度。
 * 复杂度：时间复杂度 O(n)，空间复杂度 O(1)
 */
public class $4StepGame {

    public static void main(String[] args) {
        int[] test = new int[]{5, 4, 6, 2, 3, 4, 5, 1};
        System.err.println(new $4StepGame().canJump2(test));
    }

    public boolean canJump(int[] nums) {
        int length = nums.length;
        int index = length - 1;
        int max = 0;
        for (int i = 0; i <=max; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= index) {
                return true;
            }
        }
        return false;
    }





























    public boolean canJump2(int[] nums) {
        int dex = nums.length-1;
        int max = 0;
        for (int i = 0; i <=max ; i++) {
            max = Math.max(i + nums[i], max);
            if(max>=dex){
                return true;
            }
        }
        return false;
    }


}
