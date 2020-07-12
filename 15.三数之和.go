/*
 * @lc app=leetcode.cn id=15 lang=golang
 *
 * [15] 三数之和
 */

// @lc code=start
func threeSum(nums []int) [][]int {
	var res = make([][]int, 0)
	n := len(nums)
	sort.Ints(nums)
	
	for i := 0; i < n - 2; i++ {
		if i > 0 && nums[i] == nums[i - 1] {
			continue;
		}
		left := i + 1
		right := n - 1
		
		for left < right {
			sum := nums[i] + nums[left] + nums[right]
			if sum == 0 {
				res = append(res, []int{nums[i], nums[left], nums[right]})
				for left < right && nums[left] == nums[left + 1] {
					left ++
				}
				for left < right && nums[right] == nums[right - 1] {
					right --
				}
				left ++
				right --
			} else if sum > 0{
				right --
			} else {
				left ++
			}
		}
	}
	return res
}
// @lc code=end

