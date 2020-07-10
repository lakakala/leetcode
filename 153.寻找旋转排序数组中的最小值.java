/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int middle = (right + left) / 2;
            if(nums[middle + 1] < nums[middle]) {
                return nums[middle + 1];
            }
            if(nums[middle - 1] > nums[middle]) {
                return nums[middle];
            }
            if(nums[middle] > nums[0]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
// @lc code=end

