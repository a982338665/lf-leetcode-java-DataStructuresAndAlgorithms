package pers.li.bili;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2024/10/22 19:14
 * @Description : 无序数组中 ，相邻的数一定不相等， 时间复杂度：O(logN)，因为每次迭代将搜索范围减半。
 * 空间复杂度：O(1)，只使用了常数级的额外空间。
 * <p>
 * i<i-1 && i<i+1 或者 下标0,1，或者n-2，n-1 ,均为局部最小，可否使用二分法使用 时间复杂度为 O(logN)
 * 相邻的数不相等，所以一定0到N-1，一定存在局部最小
 * <p>
 * 输入检查：首先检查输入数组是否为空或长度为0，如果是则抛出异常。
 * 初始化左右指针：left 初始化为0，right 初始化为数组长度减1。
 * 二分查找：
 * 计算中间索引 mid。
 * 检查 mid 是否为局部最小值：
 * 如果 mid 是第一个元素且小于其右邻居，或者 mid 是最后一个元素且小于其左邻居，或者 mid 小于其左右邻居，则 mid 是局部最小值，返回 mid。
 * 如果 mid 的左邻居小于 mid，则局部最小值在左半部分，移动 right 到 mid - 1。
 * 否则，局部最小值在右半部分，移动 left 到 mid + 1。
 * 异常处理：如果循环结束仍未找到局部最小值，抛出异常。理论上，只要输入数组有效且相邻元素不相等，这种情况不会发生。
 */
public class $9_局部最小 {
    public static int findLocalMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array is empty or null");
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 检查 mid 是否为局部最小值
//              (mid == 0 || nums[mid] < nums[mid - 1])检查 mid 是否为数组的第一个元素或小于其左邻居：
//              (mid == nums.length - 1 || nums[mid] < nums[mid + 1])检查 mid 是否为数组的最后一个元素或小于其右邻居
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                return mid; // Return the index of the local minimum
            }
            //如果 mid 的左邻居小于 mid，则局部最小值在左半部分
//            1,3,2,3,4
            if (mid > 0 && nums[mid - 1] < nums[mid]) {
                right = mid - 1;
            } else {
                // 否则，局部最小值在右半部分
                left = mid + 1;
            }
        }
        // T这种情况理论上不会发生，因为输入数组有效且相邻元素不相等
        throw new IllegalStateException("未找到局部最小值");
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 8, 3, 5};
        int localMinIndex = findLocalMin(nums);
        System.out.println("Local minimum found at index: " + localMinIndex);
    }

}
