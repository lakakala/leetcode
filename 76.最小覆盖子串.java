/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> ori = new HashMap<>();
        Map<Character, Integer> cnt = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            ori.put(t.charAt(i), ori.getOrDefault(t.charAt(i), 0) + 1);
        }

        int len = s.length();
        int minLen = len + 1;
        int li = -1, ri = -1;
        int l = 0, r = -1;
        while(r < len - 1){
            r ++;
            if(r < len && ori.containsKey(s.charAt(r))){
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while(check(ori, cnt) && l <= r){
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    li = l;
                    ri = r + 1;
                }

                if(ori.containsKey(s.charAt(l))){
                    cnt.put(s.charAt(l), cnt.get(s.charAt(l)) - 1);
                }
                l ++;
            }
        }
        return li == -1 ? "" : s.substring(li, ri);
    }

    private boolean check(Map<Character, Integer> ori, Map<Character, Integer> cnt){
        for(Character key : ori.keySet()){
            int target = ori.getOrDefault(key, 0);
            int curr = cnt.getOrDefault(key, 0);
            if(curr < target){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

