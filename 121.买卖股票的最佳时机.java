/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int v[] = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            if(i == 0) {
                v[i] = 0;
            } else {
                v[i] = prices[i] - prices[i - 1];
            }
            
        }
        
        int dp[] = new int[prices.length];
        for(int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1] + v[i], v[i]);
        }
        int res = 0;
        for(int i = 0; i < prices.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
// @lc code=end

