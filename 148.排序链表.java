/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode middle = middleNode(head);
        ListNode rightHead = middle.next;
        middle.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return mergeList(left, right);
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode mergeList(ListNode left, ListNode right) {
        ListNode temp = new ListNode(0);
        ListNode curr = temp;
        while(left != null && right != null) {
            if(left.val > right.val) {
                curr.next = right;
                right = right.next;
            } else {
                curr.next = left;
                left = left.next;
            }
            curr = curr.next;
        }
        curr.next = left == null ? right : left;
        return temp.next;
    }
}
// @lc code=end

