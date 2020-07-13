/*
 * @lc app=leetcode.cn id=26 lang=golang
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
func removeDuplicates(nums []int) int {
	first := 0
	for i := 1; i < len(nums); i++ {
		if nums[first] != nums[i] {
			first = first + 1
			nums[first] = nums[i]
		}
	}
	return first + 1
}

// @lc code=end
