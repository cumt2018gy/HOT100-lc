package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot62
 * @date: 2020-11-02 17:26
 * 62. 不同路径
 */
public class hot62 {
	public static int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		//第一列都是1
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		//第一行都是1
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}
		//这里是递推公式
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
		return dp[m - 1][n - 1];
	}
}
