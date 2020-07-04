/*
 * @lc app=leetcode.cn id=132 lang=java
 *
 * [132] 分割回文串 II
 */

// @lc code=start
class Solution {
    public int minCut(String s) {
        if(s == null || s.length() < 2) {
            return 0;
        }
        int len = s.length();
        boolean check_dp[][] = new boolean[len][len];

        for(int l = 1; l <= len; l++) {
            for(int j = 0; j < len - l + 1; j++) {
                if(l == 1) {
                    check_dp[j][j] = true;
                } else if(l == 2) {
                    check_dp[j][j + 1] = s.charAt(j) == s.charAt(j + 1);
                } else {
                    check_dp[j][j + l - 1] = check_dp[j + 1][j + l - 2] 
                                                && s.charAt(j) == s.charAt(j + l - 1);
                }
            }
        }

        int dp[] = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i] = i;
        }

        for(int i = 1; i < len; i++) {
            if(check_dp[0][i]) {
                dp[i] = 0;
                continue;
            } 
            for(int j = 0; j < i; j++) {
                if(check_dp[j + 1][i]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
                
            }
        }

        return dp[len - 1];
    }
}
// @lc code=end

