package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot64
 * @date: 2020-11-02 17:29
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class hot64 {
	/**
	 * dp新开数组
	 */
//	public int minPathSum(int[][] grid) {
//		int m = grid.length, n = grid[0].length;
//		int[][] dp = new int[m][n];
//		dp[0][0] = grid[0][0];
//		//第一列只能从上面走下来
//		for (int i = 1; i < m; i++) {
//			dp[i][0] = dp[i - 1][0] + grid[i][0];
//		}
//		//第一行只能从左边走过来
//		for (int i = 1; i < n; i++) {
//			dp[0][i] = dp[0][i - 1] + grid[0][i];
//		}
//		for (int i = 1; i < m; i++) {
//			for (int j = 1; j < n; j++) {
//				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
//			}
//		}
//		return dp[m - 1][n - 1];
//	}

	//在原数组上修改
	public int minPathSum(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					continue;
				if (i == 0) {
					//第一行只能从左边走过来
					grid[i][j] += grid[i][j - 1];
				} else if (j == 0) {
					//第一列只能从上面走下来
					grid[i][j] += grid[i - 1][j];
				} else {
					//递推公式，取从上面走下来和从左边走过来的最小值+当前坐标的值
					grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
				}
			}
		}
		return grid[m - 1][n - 1];
	}

}
