/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int dp_left[] = new int[height.length];
        int dp_right[] = new int[height.length];

        dp_left[0] = height[0];
        for(int i = 1; i < height.length; i++){
            dp_left[i] = Math.max(dp_left[i - 1], height[i]);
        }

        dp_right[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i--){
            dp_right[i] = Math.max(dp_right[i + 1], height[i]);
        }

        int ans = 0;

        for(int i = 0; i < height.length; i++){
            ans += Math.min(dp_left[i], dp_right[i]) - height[i];
        }

        return ans;
    }
}
// @lc code=end

