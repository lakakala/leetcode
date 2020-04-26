/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i ++){
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                res = Math.abs(target - res) > Math.abs(target - sum) ? sum : res;

                if(sum < target){
                    l ++;
                }else if(sum > target){
                    r --;
                }else{
                    return res;
                }
            }
        }
        return res;
    }
}
// @lc code=end

