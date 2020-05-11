/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums == null || nums.length == 0){
            return res;
        }

        List<Integer> newNums = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            newNums.add(nums[i]);
        }

        backtrace(newNums, res, 0);

        return res;
    }

    private void backtrace(List<Integer> nums, List<List<Integer>> res, int first){
        if(first == nums.size()){
            res.add(new ArrayList<>(nums));
        }

        for(int i = first; i < nums.size(); i++){
            Collections.swap(nums, first, i);
            backtrace(nums, res, first + 1);
            Collections.swap(nums, first, i);
        }
    }
}
// @lc code=end

