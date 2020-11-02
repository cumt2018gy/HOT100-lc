package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot72
 * @date: 2020-11-02 20:18
 * 72. 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 */
public class hot72 {
   //动态规划.....
	public static int minDistance(String word1, String word2) {
		int length1 = word1.length();
		int length2 = word2.length();
		if (length1 * length2 == 0)
			return length1 + length2;//如果有一个为空，直接返回另一个的长度即可
		int dp[][] = new int[length1 + 1][length2 + 1];
		for (int i = 0; i <= length1; i++) {
			dp[i][0] = i;//边界条件，相当于word1的删除操作
		}
		for (int i = 0; i <= length2; i++) {
			dp[0][i] = i;//边界条件，相当于word1的添加操作
		}
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= length2; j++) {//下面是上面分析的递推公式
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
				}
			}
		}
		return dp[length1][length2];
	}

}
