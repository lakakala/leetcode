/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if( x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int revertedNumber = 0;
        while(x > revertedNumber){
            revertedNumber = revertedNumber * 10 + x % 10;
            x = x / 10;
        }
        return revertedNumber == x || x == revertedNumber / 10;
    }
}
// @lc code=end

