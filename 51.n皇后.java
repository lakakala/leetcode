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

    private void placeQueen(int n, int row, int col, int mains[], int seconds[], int rows[], int queens[]){
        queens[row] = col;
        mains[row + col] = 1;
        seconds[row - col + 2*n] = 1;
        rows[col] = 1;
    }

    private void removeQueen(int n, int row, int col, int mains[], int seconds[], int rows[], int queens[]){
        queens[row] = 0;
        mains[row + col] = 0;
        seconds[row - col + 2*n] = 0;
        rows[col] = 0;
    }

    private void addSolution(int n, int queens[], List<List<String>> res){
        List<String> solution = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringBuilder builder = new StringBuilder();
            for(int j = 0; j < n; j++){
                builder.append(queens[i] == j ? 'Q' : '.');
            }
            solution.add(builder.toString());
        }
        res.add(solution);
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

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int mains[] = new int[2 * n - 1];
        int seconds[] = new int[4 * n - 1];
        int rows[] = new int[n];
        int queens[] = new int[n];
        this.backtrace(n, 0, mains, seconds, rows, queens, res);
        return res;
    }
}
// @lc code=end

