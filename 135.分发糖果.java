/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int left2Right[] = new int[len];
        int right2Left[] = new int[len];
        Arrays.fill(left2Right, 1);
        Arrays.fill(right2Left, 1);

        for(int i = 1; i < len; i++) {
            if(ratings[i] > ratings[i - 1]) {
                left2Right[i] = left2Right[i - 1] + 1;
            }
        }
        for(int i = len - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                right2Left[i] = right2Left[i + 1] + 1;
            }
        }
        int sum = 0;
        for(int i = 0; i < len; i++) {
            sum += Math.max(left2Right[i], right2Left[i]);
        }
        return sum;
    }
}
// @lc code=end

