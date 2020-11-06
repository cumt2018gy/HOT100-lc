package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot124
 * @date: 2020-11-06 22:50
 * 124. 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 */
public class hot124 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

	}

	private int maxValue = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		maxPathSumHelper(root);
		return maxValue;
	}


	public int maxPathSumHelper(TreeNode root) {
		if (root == null)
			return 0;
		//左子节点的值
		int left = maxPathSumHelper(root.left);
		//右子节点的值
		int right = maxPathSumHelper(root.right);
		//第4种情况
		int cur = root.val + Math.max(0, left) + Math.max(0, right);
		//第1,2,3三种情况,返回当前值加上左右子节点的最大值即可，如果左右子节点都
		//小于0，还不如不选
		int res = root.val + Math.max(0, Math.max(left, right));
		//记录最大value值
		maxValue = Math.max(maxValue, Math.max(cur, res));
		//第1,2,3种情况还可以再计算，所以返回的是res
		return res;
	}
}