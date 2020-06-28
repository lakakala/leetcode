/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        int left[] = new int[heights.length];
        int right[] = new int[heights.length];

        Stack<Integer> mono_stack = new Stack<Integer>();

        for(int i = 0; i < heights.length; i++){
            if(!mono_stack.isEmpty() && (heights[mono_stack.peek()] >= heights[i])){
                mono_stack.pop();
            }

            left[i] = mono_stack.isEmpty() ? -1 : mono_stack.peek();
            mono_stack.push(i);
        }

        mono_stack.clear();
        for(int i = heights.length - 1; i >= 0; i--) {
            if(!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]){
                mono_stack.pop();
            }

            right[i] = mono_stack.isEmpty() ? heights.length : mono_stack.peek();
            mono_stack.push(i);
        }

        int ans = 0;
        for(int i = 0; i < heights.length; i++){
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
// @lc code=end

