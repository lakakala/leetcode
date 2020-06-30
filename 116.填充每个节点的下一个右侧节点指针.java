/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }

        Queue<Node> node_queue = new LinkedList<>();

        node_queue.add(root);
        node_queue.add(null);

        while(!node_queue.isEmpty()) {
            Node node = node_queue.poll();
            if(node != null) {
                node.next = node_queue.peek();
                if(node.left != null) {
                    node_queue.add(node.left);
                }
                if(node.right != null) {
                    node_queue.add(node.right);
                }
            } else {
                if(node_queue.size() > 0) {
                    node_queue.add(null);
                }
            }
        }
        return root;
    }
}
// @lc code=end

