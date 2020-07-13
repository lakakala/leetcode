/*
 * @lc app=leetcode.cn id=27 lang=golang
 *
 * [27] 移除元素
 */

// @lc code=start
func removeElement(nums []int, val int) int {
	first := -1
	for i := 0; i < len(nums); i++ {
		if nums[i] != val {
			first = first + 1
			nums[first] = nums[i]
		}
	}
	return first + 1
}

// @lc code=end
