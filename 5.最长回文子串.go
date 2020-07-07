/*
 * @lc app=leetcode.cn id=5 lang=golang
 *
 * [5] 最长回文子串
 */

// @lc code=start
func longestPalindrome(s string) string {
	var res = ""
	var length = len(s)
	var dp = make([][]bool, length)
	for i := 0; i < length; i++ {
		dp[i] = make([]bool, length)
	}
	for l := 1; l <= length; l++ {
		for i := 0; i < length - l + 1; i ++ {
			if l == 1 {
				dp[i][i] = true
			} else if l == 2 {
				dp[i][i + 1] = s[i] == s[i + 1]
			} else if s[i] == s[i + l - 1]{
				dp[i][i + l - 1] = dp[i + 1][i + l - 2]
			}
			if dp[i][i + l - 1] {
				res = s[i:i + l]
			}
		}
	}
	return res
}
// @lc code=end

