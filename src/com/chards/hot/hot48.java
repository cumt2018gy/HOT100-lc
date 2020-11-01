package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot48
 * @date: 2020-11-01 22:28
 * 48. 旋转图像
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 */
public class hot48 {

	public void rotate(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix.length; j++) {
				swap(matrix, i, j);
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			mirror(matrix, i);
		}
	}
  // 对于中轴线镜像
	private void mirror(int[][] matrix, int i) {
		for (int j = 0; j < matrix.length / 2; j++) {
			int temp=matrix[i][j];
			matrix[i][j]=matrix[i][matrix.length-j-1];
			matrix[i][matrix.length-j-1]=temp;
		}
	}
  // 交换
	private void swap(int[][] matrix, int i, int j) {
		if (i == j) return;
		int temp = matrix[i][j];
		matrix[i][j] = matrix[j][i];
		matrix[j][i] = temp;
	}
}
