/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int maxPos = 0;
        int end = 0;
        int steps = 0;
        int len = nums.length;

        for(int i = 0; i < len - 1; i ++){
            maxPos = Math.max(maxPos, i + nums[i]);

            if(i == end){
                steps ++;
                end = maxPos;
            }
        }
        return steps;
    }
}
// @lc code=end

