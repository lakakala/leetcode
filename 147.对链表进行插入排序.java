/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode pre = head;

        while(pre.next != null) {
            int val = pre.next.val;

            ListNode pi = temp;
            while(pi != pre) {
                if(pi.next.val > val) {
                    ListNode nex = pre.next.next;
                    ListNode piNext = pi.next;
                    pi.next = pre.next;
                    pi.next.next = piNext;
                    pre.next = nex;
                    break;
                }
                pi = pi.next;
            }
            if(pi == pre) {
                pre = pre.next;
            }
        }
        return temp.next;
    }
}
// @lc code=end

