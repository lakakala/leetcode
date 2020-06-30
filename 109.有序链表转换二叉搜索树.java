/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode midNode = findMidNode(head);
       
        TreeNode root = new TreeNode(midNode.val);
        if(midNode == head) {
            return root;
        }
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(midNode.next);
        return root;
    }

    private ListNode findMidNode(ListNode head) {
        ListNode beforeMid = null;
        ListNode mid = head;
        ListNode last = head;
        while(last != null && last.next != null) {
            beforeMid = mid;
            mid = mid.next;
            last = last.next.next;
        }
        if(beforeMid != null) {
            beforeMid.next = null;
        }
        return mid;
    }
}
// @lc code=end

