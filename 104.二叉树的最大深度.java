/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    public int maxDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left_depth = helper(root.left);
        int right_depth = helper(root.right);
        return Math.max(left_depth, right_depth) + 1;
    }
}
// @lc code=end

