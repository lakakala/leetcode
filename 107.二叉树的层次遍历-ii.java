/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root == null) {
            return res;
        }

        List<Integer> level_list = new ArrayList<>();
        Queue<TreeNode> node_queue = new LinkedList<>();
        node_queue.add(root);
        node_queue.add(null);

        while(node_queue.size() > 0) {
            TreeNode node = node_queue.poll();
            if(node != null) {
                level_list.add(node.val);
                if(node.left != null) {
                    node_queue.add(node.left);
                }
                if(node.right != null) {
                    node_queue.add(node.right);
                }
            } else {
                res.addFirst(level_list);
                if(node_queue.size() > 0) {
                    level_list = new LinkedList<>();
                    node_queue.add(null);
                }
            }
        }
        return res;
    }
}
// @lc code=end

