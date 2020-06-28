/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();

        backtrace(n, k, 1, new LinkedList<>(), result);

        return result;
    }

    private void backtrace(int n, int k, int begin, LinkedList<Integer> curr, List<List<Integer>> result){
        if(curr.size() == k){
            result.add(new LinkedList<>(curr));
            return;
        }

        for(int i = begin; i < n + 1; i++){
            curr.add(i);
            backtrace(n, k, i + 1, curr, result);
            curr.removeLast();
        }
    }
}
// @lc code=end

