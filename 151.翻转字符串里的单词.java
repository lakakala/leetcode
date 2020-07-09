/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = trimSpace(s);
        reverse(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }

    private StringBuilder trimSpace(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left <= right && s.charAt(left) == ' ') {
            left ++;
        }
        while(left <= right && s.charAt(right) == ' ') {
            right --;
        }
        StringBuilder sb = new StringBuilder();
        while(left <= right) {
            if(s.charAt(left) != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(s.charAt(left));
            }
            left ++;
        }
        return sb;
    }

    private void reverse(StringBuilder s, int left, int right) {
        while(left < right) {
            char temp = s.charAt(left);
            s.setCharAt(left, s.charAt(right));
            s.setCharAt(right, temp);
            left++;
            right--;
        }
    }

    private void reverseEachWord(StringBuilder s) {
        int len = s.length();
        int begin = 0, end = 0;
        while(begin < len) {
            end = begin;
            while(end < len && s.charAt(end) != ' ') {
                end ++;
            }
            reverse(s, begin, end - 1);
            begin = end + 1;
        }
    }
}
// @lc code=end

