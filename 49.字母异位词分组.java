/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resMap = new HashMap<>();

        for(String s : strs){
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String key = String.valueOf(cs);
            if(!resMap.containsKey(key)){
                resMap.put(key, new ArrayList<>());
            }
            resMap.get(key).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for(String k : resMap.keySet()){
            res.add(resMap.get(k));
        }
        return res;
    }
}
// @lc code=end

