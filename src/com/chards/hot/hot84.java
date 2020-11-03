package com.chards.hot;

import java.util.Stack;

/**
 * @author 远 chards_
 * @FileName:hot84
 * @date: 2020-11-03 22:04
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class hot84 {
	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		int maxarea = 0;
		for (int i = 0; i < heights.length; i++) {
			while (stack.peek() != -1 && heights[i] <= heights[stack.peek()])
				maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
			stack.push(i);
		}
		while (stack.peek() != -1) {
			maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - 1 - stack.peek()));
		}
		return maxarea;
	}

	public static void main(String[] args) {
		hot84 hot84=new hot84();
		hot84.largestRectangleArea(new int[]{2,1,5,6,2,3});
	}

}
