/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[left] == nums[mid]){
                left++;
            }
            
            if(nums[left] < nums[mid]){
                if(nums[mid] > target && target >= nums[left]){
                    right = mid - 1;
                } else {
                    left = left + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = right - 1;
                }
            }
            return false;
        }
    }
}
// @lc code=end

