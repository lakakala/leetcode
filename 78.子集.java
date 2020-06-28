/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i <= nums.length; i++){
            backtrace(nums, i, 0, new LinkedList<>(), res);
        }

        return res;
    }

    private void backtrace(int[] nums, int k, int begin, LinkedList<Integer> path, List<List<Integer>> res){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = begin; i < nums.length; i++){
            path.addLast(nums[i]);
            backtrace(nums, k, i + 1, path, res);
            path.removeLast();
        }
    }
}
// @lc code=end

