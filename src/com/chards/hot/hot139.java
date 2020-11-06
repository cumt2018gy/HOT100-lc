package com.chards.hot;

import java.util.List;

/**
 * @author 远 chards_
 * @FileName:hot139
 * @date: 2020-11-06 23:36
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 */
public class hot139 {

//	public boolean wordBreak(String s, List<String> wordDict) {
//		boolean[] f = new boolean[s.length() + 1];
//		f[0] = true;
//		for (int i = 1; i <= s.length(); i++) {
//			for (int j = 0; j < i; j++) {
//				if (f[j] && wordDict.contains(s.substring(j, i))) {
//					f[i] = true;
//					break;
//				}
//			}
//		}
//		return f[s.length()];
//	}

	public boolean wordBreak(String s, List<String> dict) {
		int len = s.length();
		boolean[] dp = new boolean[len + 1];
		dp[0] = true;
		for (int i = 1; i <= len; i++) {
			for (int j = 0; j < dict.size(); j++) {
				String str = dict.get(j);
				int length = str.length();
				if (length <= i && dp[i - length] && str.equals(s.substring(i - length, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[len];
	}

}
