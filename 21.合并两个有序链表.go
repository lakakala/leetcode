/*
 * @lc app=leetcode.cn id=21 lang=golang
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	var head = new(ListNode)
	var curr = head
	for l1 != nil && l2 != nil {
		var temp *ListNode
		if l1.Val < l2.Val {
			temp = l1
			l1 = l1.Next
		} else {
			temp = l2
			l2 = l2.Next
		}
		curr.Next = temp
		curr = temp
	}
	if l1 == nil {
		curr.Next = l2
	} else {
		curr.Next = l1
	}

	return head.Next
}

// @lc code=end
