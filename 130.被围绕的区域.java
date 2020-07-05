/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;

        for(int i = 0; i < row; i ++) {
            for(int j = 0; j < col; j ++) {
                boolean isEdge = i == 0 || i == row - 1 || j == 0 || j == col - 1;
                if(isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        for(int i = 0; i < row; i ++) {
            for(int j = 0; j < col; j ++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if(i < 0 
            || j < 0 
            || i >= board.length 
            || j >= board[0].length 
            || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
// @lc code=end

