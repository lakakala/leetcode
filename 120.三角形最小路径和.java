/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return 0;
        }
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int dp[][] = new int[row][col];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < row; i++) {
            for(int j = 0; j <= i; j ++) {
                if(j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if(j == i){
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < col; i++) {
            res = Math.min(dp[row - 1][i], res);
        }
        return res;
    }
}
// @lc code=end

