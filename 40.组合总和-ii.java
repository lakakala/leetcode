/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();

        dfs(candidates, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int target, int begin, Deque<Integer> path, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(path));
        }

        for(int i = begin; i < candidates.length; i++){
            int temp = target - candidates[i];

            if(temp < 0){
                break;
            }

            if(i > begin && candidates[i] == candidates[i - 1]){
                continue;
            }
            path.addLast(candidates[i]);
            dfs(candidates, temp, i + 1, path, res);
            path.removeLast();
        }
    }
}
// @lc code=end

