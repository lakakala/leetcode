/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean hasOne = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1) {
                hasOne = true;
                break;
            }
        }
        if(!hasOne){
            return 1;
        }

        for(int i = 0; i < nums.length; i ++){
            if(nums[i] <= 0 || nums[i] > nums.length){
                nums[i] = 1;
            }
        }

        for(int i = 0; i < nums.length; i++){
            int n = Math.abs(nums[i]);
            if(n == nums.length){
                nums[0] = -Math.abs(nums[0]);
            }else {
                nums[n] = -Math.abs(nums[n]);
            }
        }

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > 0){
                return i;
            }
        }

        if(nums[0] > 0){
            return nums.length;
        }
        return nums.length + 1;
    }
}
// @lc code=end

