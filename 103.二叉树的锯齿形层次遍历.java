/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        
        Queue<TreeNode> node_queue = new LinkedList<>();

        LinkedList<Integer> level_list = new LinkedList<>();

        boolean is_left_order = true;

        node_queue.add(root);
        node_queue.add(null);

        while(node_queue.size() > 0) {
            TreeNode node = node_queue.poll();
            if(node != null) {
                if(is_left_order) {
                    level_list.addLast(node.val);
                } else {
                    level_list.addFirst(node.val);
                }
                if(node.left != null) {
                    node_queue.add(node.left);
                }
                if(node.right != null) {
                    node_queue.add(node.right);
                }
            } else {
                is_left_order = !is_left_order;
                res.add(level_list);
                level_list = new LinkedList<>();
                if(node_queue.size() > 0) {
                    node_queue.add(null);
                }
            }
        }
        return res;
    }
}
// @lc code=end

