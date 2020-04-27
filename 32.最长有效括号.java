/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        int dp[] = new int[s.length()];
        int result = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '('){
                dp[i] = 0;
            } else {
                if(s.charAt(i - 1) == '('){
                    dp[i] = ((i - 2) >= 0 ? dp[i - 2] : 0) + 2;
                } else {
                    if(i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                        dp[i] = dp[i - 1] + 2 + (((i - dp[i - 1] - 2 )>= 0) ? dp[i - dp[i - 1] - 2] : 0);
                    } else {
                        dp[i] = 0;
                    }
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
// @lc code=end

