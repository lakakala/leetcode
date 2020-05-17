/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        int res[][] = new int[intervals.length][2];
        int inx = -1;
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        for(int interval[] : intervals){
            if(inx == -1 || interval[0] > res[inx][1]){
                res[++inx] = interval;
            }else {
                res[inx][1] = Math.max(res[inx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, inx + 1);
    }
}
// @lc code=end

