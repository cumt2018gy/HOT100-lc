package com.chards.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 远 chards_
 * @FileName:hot22
 * @date: 2020-11-01 13:31
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class hot22 {
	/**
	 * 剪枝
	 *
	 * @param n
	 * @return
	 */
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		dfs("", list, n, n);
		return list;
	}

	private void dfs(String subString, List<String> list, int left, int right) {
		if (left == 0 && right == 0) {
			list.add(subString);
			return;
		}
		if (left > 0) dfs(subString + "(", list, left - 1, right);
		if (right > left) dfs(subString + ")", list, left, right - 1);
	}
}
