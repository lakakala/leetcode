/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        Pair<Integer, Integer> pair;
        int p1 = 0, p2 = 0;
        int chunk1, chunk2;
        while(p1 < version1.length() || p2 < version2.length()) {
            pair = getNextChunk(version1, p1);
            chunk1 = pair.first;
            p1 = pair.second;
            pair = getNextChunk(version2, p2);
            chunk2 = pair.first;
            p2 = pair.second;
            if(chunk1 != chunk2) {
                return chunk1 > chunk2 ? 1 : -1;
            }
        }
        return 0;
    }

    private Pair<Integer, Integer> getNextChunk(String v, int p) {
        if(p >= v.length()) {
            return new Pair<>(0, p);
        }
        int chunk = 0, endP = p;
        while(endP < v.length() && v.charAt(endP) != '.') {
            endP ++;
        }
        chunk = Integer.parseInt(v.substring(p, endP));
        return new Pair<>(chunk, endP + 1);
    }
}

class Pair<T, R> {
    T first;
    R second;
    Pair(T first, R second) {
        this.first = first;
        this.second = second;
    }
}
// @lc code=end

