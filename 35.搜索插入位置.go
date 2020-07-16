/*
 * @lc app=leetcode.cn id=35 lang=golang
 *
 * [35] 搜索插入位置
 */

// @lc code=start
func searchInsert(nums []int, target int) int {
	n := len(nums)
	i := 0
	for i < n && nums[i] < target {
		i++
	}
	return i
}

// @lc code=end
