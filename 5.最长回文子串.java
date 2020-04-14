/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        String ans = "";

        boolean[][] p = new boolean[length][length];
        for(int len = 1 ; len <= length; len ++){
            for(int begin = 0; begin < length; begin ++){
                int end =begin + len - 1;
                if(end >= length){ continue; }
                p[begin][end] = (len == 1 || len ==2 || p[begin + 1][end - 1]) && (s.charAt(begin) == s.charAt(end));
                ans = (p[begin][end] && ans.length() < len)  ? s.substring(begin, end + 1) : ans;
            }
        }
        return ans;
    }
}
// @lc code=end

