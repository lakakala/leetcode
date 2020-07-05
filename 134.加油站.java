/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_tank = 0;
        int current_tank = 0;
        int begin_station = 0;

        for(int i = 0; i < gas.length; i++) {
            total_tank += gas[i] - cost[i];
            current_tank += gas[i] - cost[i];
            if(current_tank < 0) {
                current_tank = 0;
                begin_station = i + 1;
            }
        }
        return total_tank >= 0 ? begin_station : -1;
    }
}
// @lc code=end

