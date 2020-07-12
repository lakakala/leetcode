/*
 * @lc app=leetcode.cn id=11 lang=golang
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
func maxArea(height []int) int {
	var length = len(height)
	var left = 0
	var right = length - 1;
	var res = 0
	for left < right {
		res = max(res, (right - left) * min(height[left], height[right]))
		if(height[left] > height[right]) {
			right --
		} else {
			left ++
		}
	}
	return res
}

func max(x, y int) int {
	if x > y {
		return x
	} else {
		return y
	}
}

func min(x, y int) int {
	if x > y {
		return y
	} else {
		return x
	}
}
// @lc code=end

