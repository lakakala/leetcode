/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, - 1};
        int l = 0, r = nums.length - 1;
        int s = -1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(target == nums[mid]){
                s = mid;
                break;
            }
            if(nums[mid] > target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        if(s == -1) return new int[]{-1, - 1};
        int begin = s, end = s;
        while(begin >= 0 && nums[begin] == target){
            begin --;
        }

        while(end < nums.length && nums[end] == target){
            end ++;
        }

        return new int[]{begin + 1, end - 1};
    }
}
// @lc code=end

