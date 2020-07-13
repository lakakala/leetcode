/*
 * @lc app=leetcode.cn id=28 lang=golang
 *
 * [28] 实现 strStr()
 */

// @lc code=start
func strStr(haystack string, needle string) int {
	if len(needle) > len(haystack) {
		return -1
	}

	if len(needle) == 0 {
		return 0
	}
	n := len(haystack)

	for i := 0; i < n-len(needle)+1; i++ {
		if haystack[i] == needle[0] {
			if check(haystack, needle, i) {
				return i
			}
		}
	}
	return -1
}

func check(haystack string, needle string, i int) bool {
	for j := 0; j < len(needle); j++ {
		if haystack[i+j] != needle[j] {
			return false
		}
	}
	return true
}

// @lc code=end
