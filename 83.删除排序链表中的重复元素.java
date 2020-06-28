/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        head = temp;
        while(temp.next != null) {
            ListNode l = temp.next;
            ListNode r = temp.next;
            while(r.next != null && l.val == r.next.val) {
                r = r.next;
            }

            temp.next = r;
            temp = temp.next;
        }

        return head.next;
    }
}
// @lc code=end

