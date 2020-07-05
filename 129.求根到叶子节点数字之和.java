/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根到叶子节点数字之和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int sum) {
        if(node == null) {
            return 0;
        }
        int temp = sum * 10 + node.val;
        if(node.left == null && node.right == null) {
            return temp;
        }
        return helper(node.left, temp) + helper(node.right, temp);
    }
}
// @lc code=end

