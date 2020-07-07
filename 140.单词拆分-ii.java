/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 */

// @lc code=start
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, new HashSet<>(wordDict), 0, new HashMap<>());
    }

    private List<String> helper(String s, Set<String> dict, int start, Map<Integer, List<String>> cached) {
        if(cached.containsKey(start)) {
            return cached.get(start);
        }

        List<String> res = new ArrayList<>();
        if(start == s.length()) {
            res.add("");
        }
        for(int i = start + 1; i <= s.length(); i++) {
            String temp = s.substring(start, i);
            if(dict.contains(temp)) {
                List<String> list = helper(s, dict, i, cached);
                for(String str : list) {
                    res.add(temp + (str.equals("") ? "" : " ") + str);
                }
            }
        }
        cached.put(start, res);
        return res;
    }
}
// @lc code=end

