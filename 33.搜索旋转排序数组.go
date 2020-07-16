/*
 * @lc app=leetcode.cn id=33 lang=golang
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
func search(nums []int, target int) int {
	left, right := 0, len(nums)-1
	for left <= right {
		mid := (left + right) / 2
		if nums[mid] == target {
			return mid
		} else if target < nums[0] {
			if nums[mid] < nums[0] && nums[mid] > target {
				right = mid - 1
			} else {
				left = left + 1
			}
		} else {
			if nums[mid] >= nums[0] && nums[mid] < target {
				left = mid + 1
			} else {
				right = mid - 1
			}
		}
	}
	return -1
}

// @lc code=end
