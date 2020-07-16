/*
 * @lc app=leetcode.cn id=34 lang=golang
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
func searchRange(nums []int, target int) []int {
	n := len(nums)
	for i := 0; i < n; i++ {
		if nums[i] == target {
			j := i
			for j < n && nums[j] == target {
				j++
			}
			return []int{i, j - 1}
		}
	}
	return []int{-1, -1}
}

// @lc code=end
