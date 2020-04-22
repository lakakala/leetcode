/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> rs = new ArrayList<>();
        if(words.length == 0){
            return rs;
        }
        int one_word = words[0].length();
        int allLen = one_word * words.length;
        Map<String, Integer> map = new HashMap<>();
        for(String w : words){
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        int i = 0;
        while(i + allLen <= s.length()){
            Map<String, Integer> temp = new HashMap<>();
            for(int j = 0; j < words.length; j++){
                String w = s.substring(i + j * one_word, i + (j + 1) * one_word);
                temp.put(w, temp.getOrDefault(w, 0) + 1);
            }
            if(temp.equals(map)){
                rs.add(i);
            }
            i++;
        }
        return rs;
    }
}
// @lc code=end

