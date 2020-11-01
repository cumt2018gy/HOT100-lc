package com.chards.hot;

import java.util.Stack;

/**
 * @author 远 chards_
 * @FileName:hot32
 * @date: 2020-11-01 15:43
 * 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class hot32 {

	//如果遇到左括号我们就把他的下标压栈，如果遇到右括号说明和栈顶元素匹配，
	// 那么栈顶元素比如m出栈，用当前元素的下标减去新的栈顶元素的值，为什么减去新的栈顶元素值，
	// 这是因为新的栈顶元素还没匹配成功，之前的栈顶元素m到现在元素的下标之间构成了有效的括号
	public int longestValidParentheses(String s) {
		int max = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.empty()) {
					stack.push(i);
				} else {
					max = Math.max(max, i - stack.peek());
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		hot32 hot32=new hot32();
		hot32.longestValidParentheses(")()())");
	}
}
