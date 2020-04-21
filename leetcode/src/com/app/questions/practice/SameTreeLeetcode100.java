package com.app.questions.practice;

import com.app.questions.practice.BinaryTree.TreeNode;

public class SameTreeLeetcode100 {
	private static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null)
			return true;
		if(p == null || q == null)
			return false;
		return (p.data == q.data) && isSameTree(p.left, q.left)
				&& isSameTree(p.right, q.right);
	}

	public static void main(String[] args) {
		BinaryTree bt1 = new BinaryTree();
		bt1.root = new TreeNode(1);
		bt1.root.left = new TreeNode(2);
		bt1.root.right = new TreeNode(3);
		
		BinaryTree bt2 = new BinaryTree();
		bt2.root = new TreeNode(1);
		bt2.root.left = new TreeNode(2);
		bt2.root.right = new TreeNode(3);
		
		System.out.println(isSameTree(bt1.root, bt2.root));

	}

}
