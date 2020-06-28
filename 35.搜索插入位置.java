/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int p = -1;
        while(l <= r){
            int mid = (l + r)/2;
            if(target == nums[mid]){
                p = mid;
                break;
            }else if(target > nums[mid]){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return p == -1 ? l : p;
    }
}
// @lc code=end

