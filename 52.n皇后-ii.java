/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
    public int totalNQueens(int n) {
        int mains[] = new int[2 * n - 1];
        int seconds[] = new int[4 * n - 1];
        int rows[] = new int[n];
        return this.backtrace(n, 0, mains, seconds, rows, queens, res, 0);
    }

    /*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {

    private boolean canNotAttack(int n, int row, int col, int mains[], int seconds[], int rows[]){
        int res = rows[col] + mains[row + col] + seconds[row - col + 2*n];
        return res == 0 ? true : false;
    }

    private void placeQueen(int n, int row, int col, int mains[], int seconds[], int rows[]){
        mains[row + col] = 1;
        seconds[row - col + 2*n] = 1;
        rows[col] = 1;
    }

    private void removeQueen(int n, int row, int col, int mains[], int seconds[], int rows[]){
        mains[row + col] = 0;
        seconds[row - col + 2*n] = 0;
        rows[col] = 0;
    }

    private void backtrace(int n, int row, int mains[], int seconds[], int rows[], int queens[], List<List<String>> res){
        for(int i = 0; i < n; i++){
            if(canNotAttack(n, row, i, mains, seconds, rows)){
                this.placeQueen(n, row, i, mains, seconds, rows, queens);
                if(row + 1 == n){
                    this.addSolution(n, queens, res);
                }else {
                    this.backtrace(n, row + 1, mains, seconds, rows, queens, res);
                }
                this.removeQueen(n, row, i, mains, seconds, rows, queens);
            }
        }
    }
}
// @lc code=end

