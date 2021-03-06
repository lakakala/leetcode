/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode old_tail = head;
        int len = 1;
        while(old_tail.next != null){
            old_tail = old_tail.next;
            len ++;
        }

        old_tail.next = head;

        ListNode new_tail = head;
        for(int i = 0; i < len - k % len - 1; i++){
            new_tail = new_tail.next;
        }

        ListNode new_head = new_tail.next;
        new_tail.next = null;
        return new_head;
    }
}
// @lc code=end

