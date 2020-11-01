package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot5
 * @date: 2020-10-29 14:17
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class hot5 {

	/**
	 * 暴力 O(N^3)
	 *
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2) return s;
		int maxLen = 1;    //与左边界的偏移量
		int left = 0;
		char[] sc = s.toCharArray();
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				if (j - i + 1 > maxLen && validPalindromic(sc, i, j)) {
					maxLen = j - i + 1;
					left = i;
				}
			}
		}
		return s.substring(left, left + maxLen);
	}

	private boolean validPalindromic(char[] charArry, int left, int right) {
		while (left < right) {
			if (charArry[left] != charArry[right]) return false;
			left++;
			right--;
		}
		return true;
	}

	/**
	 * 动态规划 O(N^2)
	 *
	 * @param s
	 * @return
	 */
	public String longestPalindrome1(String s) {
		int len = s.length();
		if (len < 2) return s;
		int maxLen = 1;    //与左边界的偏移量
		int left = 0;
		char[] sc = s.toCharArray();
		boolean[][] dp = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			dp[i][i] = true;
		}
		for (int j = 1; j < len; j++) {
			for (int i = 0; i < j; i++) {
				if (sc[i] != sc[j]) dp[i][j] = false;
				else {
					if (j - i < 3) dp[i][j] = true;
					else dp[i][j] = dp[i + 1][j - 1];
				}
				if (dp[i][j] && j - i + 1 > maxLen) {
					maxLen = j - i + 1;
					left = i;
				}
			}
		}
		return s.substring(left, left + maxLen);
	}


}
