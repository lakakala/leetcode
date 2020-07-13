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
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while(head != null) {
            ListNode tail = pre;
            for(int i = 0; i < k; i++) {
                if(tail.next == null) {
                    return hair.next;
                }
                tail = tail.next;
            }
            ListNode nex = tail.next;

            Pair p = reverse(head, tail);
            head = p.first;
            tail = p.second;

            pre.next = head;
            tail.next = nex;
            head = nex;
            pre = tail;
        }
        return hair.next;
    }

    private Pair reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while(prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new Pair(tail, head);
    }
}

class Pair {
    ListNode first;
    ListNode second;
    Pair(ListNode first, ListNode second) {
        this.first = first;
        this.second = second;
    }
}
// @lc code=end

