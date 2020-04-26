/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stask = new Stack<>();
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                char e = stask.empty() ? '#' : stask.pop();
                if(e != map.get(c)){
                    return false;
                }
            }else{
                stask.push(c);
            }
        }
        
        return stask.empty();
    }
}
// @lc code=end

