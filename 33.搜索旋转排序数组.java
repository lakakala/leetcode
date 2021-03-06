/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) return target == nums[0] ? 0 : -1;
        int l = 0, r = nums.length - 1;

        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[l]){
                if(target >= nums[l] && target <= nums[mid]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            } else {
                if(target >= nums[mid] && target <= nums[r]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

