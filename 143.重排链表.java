/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        second = reverse(second);
        ListNode curr = head;
        while(second != null) {
            ListNode temp = curr.next;
            curr.next = second;
            second = second.next;
            curr.next.next = temp;
            curr = curr.next.next;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode first = null;
        ListNode second = head;
        while(second != null) {
            ListNode temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }
        return first;
    }
}
// @lc code=end

