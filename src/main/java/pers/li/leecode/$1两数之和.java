package pers.li.leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2022/11/2 10:29
 * @Description :
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <p>
 * 思路：
 */
public class $1两数之和 {
    public int[] twoSum(int[] nums, int target) {
        int[] ss = new int[2];
        for (int x = 0; x < nums.length; x++) {
            for (int y = 0; y < nums.length; y++) {
                if (x != y && nums[x] + nums[y] == target) {
                    return new int[]{x, y};
                }
            }
        }
        return ss;
    }
    public int[] twoSum2(int[] nums, int target) {
        int[] ss = new int[2];
        for (int x = 0; x < nums.length; x++) {
            for (int y = x+1; y < nums.length; y++) {
                if (x != y && nums[x] + nums[y] == target) {
                    return new int[]{x, y};
                }
            }
        }
        return ss;
    }

    /**
     * hash处理
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int x = 0; x < nums.length; x++) {
            int i = target - nums[x];
            if(map.containsKey(i)){
                return new int[]{map.get(i),x};
            }
            map.put(nums[x], x);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] ints = new $1两数之和().twoSum(new int[]{1, 2, 3, 4}, 5);
        System.err.println(ints);
    }
}
