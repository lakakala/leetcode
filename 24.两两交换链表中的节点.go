/*
 * @lc app=leetcode.cn id=24 lang=golang
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func swapPairs(head *ListNode) *ListNode {
	var temp = new(ListNode)
	temp.Next = head
	pre := temp
	curr := temp.Next
	for curr != nil && curr.Next != nil {
		first, second := curr, curr.Next

		first.Next = second.Next
		pre.Next = second
		second.Next = first
		pre = first
		curr = first.Next
	}
	return temp.Next
}

// @lc code=end
