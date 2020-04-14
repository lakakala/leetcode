/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        int minLen = strs[0].length();
        for(int i = 1; i < strs.length; i ++){
            minLen = Math.min(minLen, strs[i].length());
        }
        int l = 0, r = minLen - 1;
        while(l <= r){
            int middle = (r + l) / 2;
            if(isPrefixMatch(strs, middle)){
                l = middle + 1;
            }else{
                r = middle - 1;
            }
        }
        return strs[0].substring(0, (r + l) / 2);

    }

    public boolean isPrefixMatch(String[] strs, int len){
        String prefix = strs[0].substring(0, len + 1);
        for(int i = 1; i < strs.length; i ++){
            if(!strs[i].startsWith(prefix)) return false;
        }
        return true;
    }
}
// @lc code=end

