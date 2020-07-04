/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> nums_set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            nums_set.add(nums[i]);
        }

        int max = 0;

        for(int n:nums_set) {
            if(!nums_set.contains(n - 1)) {
                int current_num = n;
                int current_max = 1;
                while(nums_set.contains(current_num + 1)) {
                    current_num++;
                    current_max++;
                }
                max = Math.max(max, current_max);
            }
        }
        return max;
    }
}
// @lc code=end

