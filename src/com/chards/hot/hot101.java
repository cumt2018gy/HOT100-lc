package com.chards.hot;

import com.sun.scenario.effect.impl.state.AccessHelper;

/**
 * @author 远 chards_
 * @FileName:hot101
 * @date: 2020-11-04 22:02
 * 101. 对称二叉树
 */
public class hot101 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return check(root.left, root.right);
	}

	private boolean check(TreeNode left, TreeNode right) {
		if (left == null && right == null) return true;
		if (left == null || right == null) return false;
		return left.val == right.val && check(left.left, right.right) && check(right.left, left.right);
	}
}
