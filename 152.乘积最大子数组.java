/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int mx = maxF;
            int mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(mn * nums[i], nums[i]));
            minF = Math.min(mn * nums[i], Math.min(mx * nums[i], nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }
}
// @lc code=end

