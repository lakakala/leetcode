/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode first = temp;
        ListNode second = temp;

        for(int i = 0; i < n; i ++){
            first = first.next;
        }
        while(first.next != null){
            first = first.next;
            second = second.next; 
        }
        second.next = second.next.next;

        return temp.next;
    }
}
// @lc code=end

