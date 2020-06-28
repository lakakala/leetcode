/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();
        int dp[] = new int[len];
        dp[0] = 1;

        for(int i = 1; i < len; i++) {
            if(s.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            }

            int num = 10 * (s.charAt(i - 1) - '0') + (s.charAt(i) - '0');
            if(num <= 26 && num >= 10) {
                dp[i] += (i - 2 >= 0 ? dp[i - 2] : 1);
            }
        }

        return dp[len - 1];
    }
}
// @lc code=end

