/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(0);
        ListNode p1 = l1, p2 = l2, current = header;
        int carry = 0;
        while( !(p1 == null && p2 == null)){
            int x = p1 == null ? 0 : p1.val;
            int y = p2 == null ? 0 : p2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
        }
        if(carry == 1){
            current.next = new ListNode(1);
        }
        return header.next;
    }
}
// @lc code=end

