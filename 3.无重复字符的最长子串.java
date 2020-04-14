/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> ix = new HashMap<>();
        int ans = 0;
        for(int i = 0, j = 0; j < s.length(); j ++){
            if(ix.containsKey(s.charAt(j))){
                i = Math.max(ix.get(s.charAt(j)) + 1, i);
            }
            ans = Math.max(j - i + 1, ans);
            ix.put(s.charAt(j), j);
        }
        return ans;
    }
}
// @lc code=end

