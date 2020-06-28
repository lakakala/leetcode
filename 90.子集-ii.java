/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for(int len = 0; len <= nums.length; len ++) {
            backtrace(nums, 0, len, new LinkedList<>(), res);
        }

        return res;
    }

    private void backtrace(int[] nums, int begin, int k, LinkedList<Integer> path, List<List<Integer>> res) {
        if(path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = begin; i < nums.length; i++) {
            if(i > begin && nums[i] == nums[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            backtrace(nums, i + 1, k, path, res);
            path.removeLast();
        }
     }
}
// @lc code=end

