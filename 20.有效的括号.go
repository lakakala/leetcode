/*
 * @lc app=leetcode.cn id=20 lang=golang
 *
 * [20] 有效的括号
 */

// @lc code=start
func isValid(s string) bool {
	var m = map[byte]byte{
		')': '(',
		']': '[',
		'}': '{',
	}
	var stack = make([]byte, 0)
	for i := 0; i < len(s); i++ {
		c := s[i]
		if rev, ok := m[c]; ok {
			if len(stack) == 0 {
				return false
			}
			sc := stack[len(stack)-1]
			if sc != rev {
				return false
			}
			stack = stack[:len(stack)-1]
		} else {
			stack = append(stack, c)
		}
	}
	return len(stack) == 0
}

// @lc code=end
