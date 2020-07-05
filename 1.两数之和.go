/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 */

// @lc code=start
func twoSum(nums []int, target int) []int {
	num_map := make(map[int]int)
	for i, v := range nums {
		find := target - v;
		if findIndex, ok := num_map[find]; ok {
			return []int {i, findIndex}
		}
		num_map[v] = i;
	}
	return []int{};
}
// @lc code=end

