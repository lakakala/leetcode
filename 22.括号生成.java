/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrace(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtrace(List<String> res, StringBuilder s, int left, int right, int max) {
        if(s.length() == 2 * max) {
            res.add(s.toString());
        }

        if(left < max) {
            s.append('(');
            backtrace(res, s, left + 1, right, max);
            s.deleteCharAt(s.length() - 1);
        }
        if(right < left) {
            s.append(')');
            backtrace(res, s, left, right + 1, max);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
// @lc code=end

