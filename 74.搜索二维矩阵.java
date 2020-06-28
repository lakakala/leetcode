/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        if(r == 0){
            return false;
        }
        int c = matrix[0].length;
        
        int len = r * c;

        int left = 0, right = len - 1;

        while(left <= right){
            int middle = (left + right)/2;
            int middleElem = matrix[middle/c][middle%c];
            if(target == middleElem){
                return true;
            }else if(target > middleElem){
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }
}
// @lc code=end

