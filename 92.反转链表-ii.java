/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) {
            return head;
        }
        ListNode curr = head;
        ListNode peer = null;
        while(m > 1) {
            peer = curr;
            curr = curr.next;
            m --;
            n --;
        }

        ListNode tail = curr;
        ListNode before_m = peer;

        while(n > 0) {
            ListNode temp = curr.next;
            curr.next = peer;
            peer = curr;
            curr = temp;
            n--;
        }
        if(before_m != null) {
            before_m.next = peer;
        } else {
            head = peer;
        }

        tail.next = curr;
        return head;
    }
}
// @lc code=end

