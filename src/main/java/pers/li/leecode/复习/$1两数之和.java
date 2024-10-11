package pers.li.leecode;

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

    public int[] twoSum2(int[] nums, int target) {
        int[] xxx = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                int result = nums[i] + nums[i1];
                if (result == target) {
                    return new int[]{i, i1};
                }
            }
        }
        return xxx;
    }

    /**
     * hash处理
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = target - nums[i];
            if (map.containsKey(cur)) {
                return new int[]{map.get(cur), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] ints = new $1hash两数之和().twoSum2(new int[]{1, 2, 3, 4}, 5);
        System.err.println(ints);
    }
}
