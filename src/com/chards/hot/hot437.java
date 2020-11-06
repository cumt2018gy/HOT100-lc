package com.chards.hot;

import java.awt.datatransfer.FlavorListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 远 chards_
 * @FileName:hot437
 * @date: 2020-11-06 21:26
 * <p>
 * 437. 路径总和 III
 */
public class hot437 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}


	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		recursive(root, sum, new ArrayList<>(), res);
		return res;
	}

	private void recursive(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {
		if (root == null) return;
		list.add(new Integer(root.val));
		if (root.left == null && root.right == null) {
			if (sum == root.val) result.add(new ArrayList<>(list));
			list.remove(list.size() - 1);
			return;
		}
		recursive(root.left, sum - root.val, list, result);
		recursive(root.right, sum - root.val, list, result);
		list.remove(list.size() - 1);
	}


	public static void main(String[] args) {
		hot437 hot437=new hot437();
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(4);
		root.right=new TreeNode(8);
		root.right.left=new TreeNode(13);
		root.right.right=new TreeNode(4);
		root.right.right.left=new TreeNode(5);
		root.right.right.right=new TreeNode(1);
		root.left.left=new TreeNode(11);
		root.left.left.right=new TreeNode(2);
		root.left.left.left=new TreeNode(7);

		hot437.pathSum(root,22);
	}
}
