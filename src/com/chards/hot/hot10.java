package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot10
 * @date: 2020-10-30 22:27
 * <p>
 * 10. 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 */
public class hot10 {


	public boolean isMatch(String s, String p) {
		int m = s.length();
		int n = p.length();

		boolean[][] f = new boolean[m + 1][n + 1];
		f[0][0] = true;
		for (int i = 0; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (p.charAt(j - 1) == '*') {
					f[i][j] = f[i][j - 2];
					if (matches(s, p, i, j - 1)) {
						f[i][j] = f[i][j] || f[i - 1][j];
					}
				} else {
					if (matches(s, p, i, j)) {
						f[i][j] = f[i - 1][j - 1];
					}
				}
			}
		}
		return f[m][n];
	}

	public boolean matches(String s, String p, int i, int j) {
		if (i == 0) {
			return false;
		}
		if (p.charAt(j - 1) == '.') {
			return true;
		}
		return s.charAt(i - 1) == p.charAt(j - 1);
	}

	public static void main(String[] args) {
		hot10 hot10 = new hot10();
		hot10.isMatch("aa", "a*");
	}
}
