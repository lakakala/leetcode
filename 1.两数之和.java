/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> ix = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(ix.containsKey(target - nums[i])){
                return new int[]{ix.get(target - nums[i]), i};
            }
            ix.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
// @lc code=end

