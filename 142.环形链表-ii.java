/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private ListNode getIntersect(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        while(first != second) {
            if(second == null || second.next == null) {
                return null;
            }
            first = first.next;
            second = second.next.next;
        }
        return first;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode intersect = getIntersect(head);
        if(intersect == null) {
            return null;
        }
        ListNode first = head;
        while(first != intersect) {
            first = first.next;
            intersect = intersect.next;
        }
        return first;
    }
}
// @lc code=end

