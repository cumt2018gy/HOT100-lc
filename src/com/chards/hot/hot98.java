package com.chards.hot;

/**
 * @author 远 chards_
 * @FileName:hot98
 * @date: 2020-11-04 21:51
 * <p>
 * 98. 验证二叉搜索树
 */
public class hot98 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	//中序遍历 每次判断大小
	//二叉搜索树中序遍历是升序 ***
	Integer pre = null;
	public boolean isValidBST(TreeNode root) {
		if (root == null) return true;
		if (!isValidBST(root.left)) return false;
		if (pre != null && root.val <= pre) return false;
		pre = root.val;
		if (!isValidBST(root.right)) return false;
		return true;
	}
}
