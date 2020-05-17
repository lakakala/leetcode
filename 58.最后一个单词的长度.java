/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' '){
            end --;
        }

        if(end < 0){
            return 0;
        }

        int begin = end;

        while(begin >= 0 && s.charAt(begin) != ' '){
            begin --;
        }
        return end - begin;
    }
}
// @lc code=end

