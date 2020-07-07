/*
 * @lc app=leetcode.cn id=7 lang=golang
 *
 * [7] 整数反转
 */

// @lc code=start
func reverse(x int) int {
	var int_max = 2147483647
	var int_min = -2147483648
	var num = 0
	for x != 0 {
		var pop = x % 10
		x = x / 10
		if num > int_max / 10 || (num == int_max / 10 && x > int_max % 10) {
			return 0
		}
		if num < int_min / 10 || (num == int_min / 10 && x < int_min % 10) {
			return 0
		}
		num = num * 10 + pop
	}
	return num
}
// @lc code=end

