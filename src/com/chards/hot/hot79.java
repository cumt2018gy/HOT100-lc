package com.chards.hot;

import java.util.Arrays;

/**
 * @author 远 chards_
 * @FileName:hot79
 * @date: 2020-11-03 09:54
 * <p>
 * 79. 单词搜索
 */
public class hot79 {

	private boolean[][] used;
	private char[][] board;
	private int row, col;
	private char[] ws;
	private int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

	public boolean exist(char[][] board, String word) {
		this.row = board.length;
		this.col = board[0].length;
		this.used = new boolean[row][col];
		for (boolean[] u : used) {   //将棋盘上面所有的都标记为未访问
			Arrays.fill(u, false);
		}
		this.board = board;
		this.ws = word.toCharArray();
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if (board[i][j] == ws[0]) {  //判断这个单词首字母是否找到
					used[i][j] = true;      //找到的话 设置为 true
					if (dfs(i, j, 1)) {  //开始递归接下来的字母
						return true;
					} else {
						used[i][j] = false;
					}
				}
			}
		}
		return false;
	}

	private boolean dfs(int i, int j, int depth) {   //   i, j 从首字母起始点开始递归
		if (depth == ws.length) {   //递归终止条件 当递归层数 == 单词长度的时候
			return true;
		}

		for (int[] d : direction) {  //方向  上下左右
			int newX = i + d[0];
			int newY = j + d[1];
			// 剪枝
			if (!inArea(newX, newY)) {
				continue;
			}
			// 剪枝
			if (used[newX][newY]) {
				continue;
			}
			// 剪枝   (周围点若不相同，则剪枝)
			if (board[newX][newY] != ws[depth]) {
				continue;

			}
			//在其周围找到该点
			used[newX][newY] = true;

			//递归下一层
			if (dfs(newX, newY, depth + 1)) {
				return true;
			} else {
				used[newX][newY] = false;  //消除当前层影响
			}
		}
		return false;
	}

	private boolean inArea(int x, int y) {  //剪枝
		return x >= 0 && x < this.row && y >= 0 && y < this.col;
	}

}
