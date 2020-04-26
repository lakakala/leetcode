/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode pre = temp;
        while(head != null && head.next != null){
            ListNode first = head;
            ListNode second = head.next;

            first.next = second.next;
            second.next = first;
            pre.next = second;
            head = first.next;
            pre = first;
        }
        return temp.next;
    }
}
// @lc code=end

