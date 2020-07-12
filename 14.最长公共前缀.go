/*
 * @lc app=leetcode.cn id=14 lang=golang
 *
 * [14] 最长公共前缀
 */

// @lc code=start
func longestCommonPrefix(strs []string) string {
	if strs == nil || len(strs) == 0 {
		return ""
	}

	var length = len(strs[0])
	for i := 0; i < length; i++ {
		var c = strs[0][i]
		for j := 1; j < len(strs); j++ {
			if len(strs[j]) < i + 1 || c != strs[j][i] {
				return strs[0][:i]
			}
		}
	}
	return strs[0]
}
// @lc code=end

