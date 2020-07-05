/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }

    private int maxGain(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left_gain = Math.max(0, maxGain(node.left));
        int right_gain = Math.max(0, maxGain(node.right));

        max = Math.max(max, node.val + left_gain + right_gain);
        return Math.max(left_gain, right_gain) + node.val;
    }
}
// @lc code=end

