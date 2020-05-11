/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int target, int begin, Deque<Integer> path, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = begin; i < candidates.length; i++){
            if(target - candidates[i] < 0){
                break;
            }

            path.addLast(candidates[i]);
            dfs(candidates, target - candidates[i], i, path, result);
            path.removeLast();
        }
    }
}
// @lc code=end

