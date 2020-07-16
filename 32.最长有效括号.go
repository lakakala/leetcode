/*
 * @lc app=leetcode.cn id=32 lang=golang
 *
 * [32] 最长有效括号
 */

// @lc code=start
func longestValidParentheses(s string) int {
	n := len(s)
	dp := make([]int, n)
	res := 0

	for i := 0; i < n; i++ {
		if s[i] == '(' {
			dp[i] = 0
		} else {
			if i-1 >= 0 && s[i-1] == '(' {
				dp[i] = 2
				if i-2 >= 0 {
					dp[i] = dp[i] + dp[i-2]
				}
			} else if i-1 >= 0 && i-dp[i-1]-1 >= 0 && s[i-dp[i-1]-1] == '(' {
				dp[i] = dp[i-1] + 2
				if i-dp[i-1]-2 > 0 {
					dp[i] = dp[i] + dp[i-dp[i-1]-2]
				}
			}
		}
		res = max(res, dp[i])
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

// @lc code=end
