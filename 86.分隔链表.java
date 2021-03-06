/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
    public ListNode partition(ListNode head, int x) {
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;

        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while(head != null){
            if(head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }

            head = head.next;
        }
        after.next = null;
        before.next = after_head.next;
        return before_head.next;
    }
}
// @lc code=end

