/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if(s1Len + s2Len != s3.length()) {
            return false;
        }
        boolean dp[][] = new boolean[s1Len + 1][s2Len + 1];
       
        for(int i = 0; i <= s1Len; i++) {
            for(int j = 0; j <= s2Len; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if(i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if(j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1])  
                    || (s1.charAt(i - 1) == s3.charAt(i + j - 1) &&  dp[i - 1][j]);
                }
            }
        }
        return dp[s1Len][s2Len];
    }
}
// @lc code=end

