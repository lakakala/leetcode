/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p1 = nums.length - 1;
        int curr = 0;
        while(curr <= p1){
            if(nums[curr] == 0){
                int temp = nums[curr];
                nums[curr++] = nums[p0];
                nums[p0++] = temp;
            }else if(nums[curr] == 2){
                int temp = nums[curr];
                nums[curr] = nums[p1];
                nums[p1--] = temp;
            }else {
                curr ++;
            }
        }
    }
}
// @lc code=end

