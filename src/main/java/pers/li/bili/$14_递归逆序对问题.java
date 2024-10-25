package pers.li.bili;


/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2024/10/22 19:14
 * 逆序对问题是指在一个数组中，找到所有满足 i < j 且 nums[i] > nums[j] 的数对 (i, j)。
 * 解决这个问题的一个高效方法是使用归并排序的思想，因为归并排序在合并过程中可以顺便统计逆序对的数量。
 * @Description : 逆序对问题 在一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对，请打印所有逆序对。或者找到 逆序对个数
 * 32450
 * 求右边的数有多少个比左边的数小
 * 3:2个
 * 2:1个
 * 4:1个
 * 5:1个 总计 5个
 */
public class $14_递归逆序对问题 {
    private int[] temp;

    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        count += merge(nums, left, mid, right);
        return count;
    }

    private int merge(int[] nums, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left, j = mid + 1;
        int count = 0;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                nums[k++] = temp[i++];
            } else {
                nums[k++] = temp[j++];
                count += (mid - i + 1); // 统计逆序对
            }
        }

        while (i <= mid) {
            nums[k++] = temp[i++];
        }

        while (j <= right) {
            nums[k++] = temp[j++];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 5, 0, 1, 1, 0};
        $14_递归逆序对问题 solution = new $14_递归逆序对问题();
        int count = solution.reversePairs(nums);
        System.out.println("逆序对总数: " + count);
    }
}
