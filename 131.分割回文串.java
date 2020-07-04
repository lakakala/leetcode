/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return res;
        }
        backtrace(s, 0, new LinkedList<>(), res);
        return res;
    }

    private void backtrace(String s, int start, Deque<String> path, List<List<String>> res) {
        if(start == s.length()) {
            res.add(new ArrayList<>(path));
        }

        for(int i = start; i < s.length(); i++) {
            if(!check(s, start, i)) {
                continue;
            }
            path.addLast(s.substring(start, i + 1));
            backtrace(s, i + 1, path, res);
            path.removeLast();
        }
    }

    private boolean check(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

