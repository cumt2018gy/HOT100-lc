package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot114
 * @date: 2020-11-04 23:13
 * 114. 二叉树展开为链表
 */
public class hot114 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void flatten(TreeNode root) {
		while (root != null) {
			if (root.left != null) {
				TreeNode pre = root.left;
				while (pre.right != null) pre = pre.right;
				pre.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;
		}
	}
}
