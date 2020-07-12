/*
 * @lc app=leetcode.cn id=16 lang=golang
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
func threeSumClosest(nums []int, target int) int {
	if nums == nil || len(nums) < 3 {
		return -1
	}
	sort.Ints(nums)
	res := nums[0] + nums[1] + nums[2]
	n := len(nums)
	for i := 0; i < n; i++ {
		left, right := i + 1, n - 1
		for left < right {
			sum := nums[i] + nums[left] + nums[right]
			if sum == target {
				return sum
			} else if sum > target {
				right --
			} else {
				left ++
			}
			if abs(target - res) > abs(target- sum) {
				res = sum
			}
		}
	}
	return res
}

func abs(x int) int {
	if x < 0 {
		x = -x
	}
	return x
}

func min(x , y int) int {
	if x > y {
		return y
	} else {
		return x
	}
}
// @lc code=end

