package pers.li.bili;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2024/10/22 19:14
 * @Description : 时间复杂度O(logN）
 * 每次 砍一半 8 4 2 1，找区间中某个数，如果存在，返回下标，不存在，返回-1。
 * 如果8个数，需要砍的最多的次数为 4 2 1，共3次。2^3 = 8，所以时间复杂度为O(logN)。
 */
public class $7_二分法找有序数组中的某个数字 {

    /**
     * 使用二分法在有序数组中查找某个数字
     *
     * @param nums   有序数组
     * @param target 要查找的数字
     * @return 数字在数组中的索引，如果不存在则返回 -1
     */
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("输入数组为空或null");
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 检查中间值是否等于目标值
            if (nums[mid] == target) {
                return mid; // 找到目标值，返回其索引
            }
            // 如果中间值小于目标值，说明目标值在右半部分
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 如果中间值大于目标值，说明目标值在左半部分
                right = mid - 1;
            }
        }

        // 如果循环结束仍未找到目标值，返回 -1
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        int index = binarySearch(nums, target);
        if (index != -1) {
            System.out.println("目标值 " + target + " 在数组中的索引为: " + index);
        } else {
            System.out.println("目标值 " + target + " 不在数组中");
        }
    }
}
