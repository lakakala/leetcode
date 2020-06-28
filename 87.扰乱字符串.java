/*
 * @lc app=leetcode.cn id=87 lang=java
 *
 * [87] 扰乱字符串
 */

// @lc code=start
class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        int len = s1.length();
        boolean dp[][][] = new boolean[len][len][len + 1];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for(int l = 2; l <= len; l++){
            for(int i = 0; i <= len - l; i++){
                for(int j = 0; j <= len - l; j++){
                    for(int k = 1; k < l; k++){
                        if(dp[i][j][k] && dp[i + k][j + k][l - k]){
                            dp[i][j][l] = true;
                            break;
                        }
                        if(dp[i][j + l - k][k] && dp[i + k][j][l - k]){
                            dp[i][j][l] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][len];
    }
}
// @lc code=end

