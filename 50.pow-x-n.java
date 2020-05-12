/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        return n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, n);
    }

    private double quickMul(double x, int n){
        if(n == 0){
            return 1.0;
        }

        double temp = quickMul(x, n/2);

        return n % 2 == 0 ? temp * temp : temp * temp * x;
    }
}
// @lc code=end

