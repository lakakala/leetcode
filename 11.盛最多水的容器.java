/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while(l < r){
            maxArea = Math.max(maxArea, (r - l) * Math.min(height[l], height[r]));
            if(height[l] < height[r]){
                l ++;
            }else{
                r --;
            }
        }
        return maxArea;
    }
}
// @lc code=end

