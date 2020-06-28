/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode curr = temp;
        while(curr.next != null){
            ListNode first = curr.next;
            ListNode secondPre = curr;

            for(int i = 0; i < k - 1; i++){
                secondPre = secondPre.next;
                if(secondPre.next == null){
                    return temp.next;
                }
            }
            ListNode second = secondPre.next;
            ListNode secondNext = second.next;

            curr.next = second;
            second.next = first.next == second ? first : first.next;
            secondPre.next = first;
            first.next = secondNext;

            curr = first;
        }
        return temp.next;
    }
}
// @lc code=end

