package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot76
 * @date: 2020-11-02 21:46
 * <p>
 * 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
 * 输入：S = "ADOBECODEBANC", T = "ABC"
 * 输出："BANC"
 */
public class hot76 {
	//滑动窗口 双指针+哈希表
	public String minWindow(String s, String t) {
		int[] window = new int[128], need = new int[128];
		char[] ss = s.toCharArray(), tt = t.toCharArray();
		int count = 0, min = ss.length;
		String res = "";
		for (int i = 0; i < tt.length; i++) {
			need[tt[i]]++;
		}
		int i = 0, j = 0;
		while (j < ss.length) {
			char c = ss[j];
			window[c]++;
			if (window[c] <= need[c]) count++;
			while (count == tt.length) {
				if (j - i + 1 <= min) {
					res = s.substring(i, j + 1);
					min = j - i + 1;
				}
				window[ss[i]]--;
				if (window[ss[i]] < need[ss[i]]) count--;
				i++;
				if (i >= ss.length) break;
			}
			j++;
		}
		return res;
	}


}
