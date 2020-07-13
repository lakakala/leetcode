/*
 * @lc app=leetcode.cn id=30 lang=golang
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start
func findSubstring(s string, words []string) []int {
	res := make([]int, 0)
	slen, wordLen := len(s), len(words)

	if slen == 0 || wordLen == 0 {
		return res
	}

	singleLen := len(words[0])

	m := map[string]int{}
	for i := 0; i < wordLen; i++ {
		m[words[i]]++
	}

	for i := 0; i < slen-singleLen*wordLen+1; i++ {
		tempMap := map[string]int{}
		for l := 0; l < wordLen; l++ {
			subS := s[i+l*singleLen : i+(l+1)*singleLen]
			if _, ok := m[subS]; !ok {
				break
			}
			tempMap[subS]++
			if tempMap[subS] > m[subS] {
				break
			}
		}
		if checkMap(m, tempMap) {
			res = append(res, i)
		}
	}
	return res
}

func checkMap(x, y map[string]int) bool {
	for k, v := range x {
		if yV, ok := y[k]; ok {
			if v != yV {
				return false
			}
		} else {
			return false
		}
	}
	return true
}

// @lc code=end
