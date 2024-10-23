package pers.li.bili;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2024/10/22 19:14
 * @Description : 时间复杂度O(logN）
 * 每次 砍一半 8 4 2 1，找区间中某个数，如果存在，返回下标，不存在，返回-1。
 * 如果8个数，需要砍的最多的次数为 4 2 1，共3次。2^3 = 8，所以时间复杂度为O(logN)。
 */
public class $8_二分法找有序数组中大于等于某个数最左侧的位置 {

    /**
     * 使用二分法在有序数组中查找大于等于某个数的最左侧位置
     *
     * @param nums   有序数组
     * @param target 要查找的数字
     * @return 大于等于目标值的最左侧位置，如果不存在则返回 -1
     */
    public static int findLeftmostGreaterOrEqual(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("输入数组为空或null");
        }

        int left = 0;
        int right = nums.length - 1;
        int result = -1; // 用于记录大于等于目标值的最左侧位置

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 检查中间值是否大于等于目标值
            if (nums[mid] >= target) {
                result = mid; // 更新结果为当前中间位置
                right = mid - 1; // 继续在左半部分查找更左侧的位置
            } else {
                left = mid + 1; // 目标值在右半部分
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 4, 5, 6, 7, 9, 10, 11};
        int target = 4;
        int index = findLeftmostGreaterOrEqual(nums, target);
        if (index != -1) {
            System.out.println("大于等于目标值 " + target + " 的最左侧位置为: " + index);
        } else {
            System.out.println("没有大于等于目标值 " + target + " 的元素");
        }
    }

}
