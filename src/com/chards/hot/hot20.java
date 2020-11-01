package com.chards.hot;

import java.util.Stack;

/**
 * @author 远 chards_
 * @FileName:hot20
 * @date: 2020-11-01 13:22
 * 20. 有效的括号
 * "()[]{}"
 * 输出: true
 */
public class hot20 {

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack();
		for (char c : s.toCharArray()) {
			if (c == '(') stack.push(')');
			else if (c == '{') stack.push('}');
			else if (c == '[') stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c) return false;
		}
		return stack.isEmpty();
	}
}
