package com.chards.hot;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 远 chards_
 * @FileName:hot94
 * @date: 2020-11-04 21:31
 */
public class hot94 {

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
	//递归实现
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		inorder(root, res);
		return res;
	}

	private void inorder(TreeNode root, List<Integer> res) {
		if (root == null) return;
		inorder(root.left, res);
		res.add(root.val);
		inorder(root.right, res);
	}


   //迭代实现
	public List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(stack.size()>0 || root!=null) {
			//不断往左子树方向走，每走一次就将当前节点保存到栈中
			//这是模拟递归的调用
			if(root!=null) {
				stack.add(root);
				root = root.left;
				//当前节点为空，说明左边走到头了，从栈中弹出节点并保存
				//然后转向右边节点，继续上面整个过程
			} else {
				TreeNode tmp = stack.pop();
				res.add(tmp.val);
				root = tmp.right;
			}
		}
		return res;
	}



}
