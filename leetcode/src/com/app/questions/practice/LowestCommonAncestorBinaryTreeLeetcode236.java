package com.app.questions.practice;

import com.app.questions.practice.BinaryTree.TreeNode;

public class LowestCommonAncestorBinaryTreeLeetcode236 {
	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null)
			return null;
		if(root.data == p.data || root.data == q.data)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if(left != null && right != null)
			return root;
		else if(left == null)
			return right;
		else
			return left;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(5);
		bt.root.right = new TreeNode(1);
		bt.root.left.left = new TreeNode(6);
		bt.root.left.right = new TreeNode(2);
		bt.root.left.right.left = new TreeNode(7);
		bt.root.left.right.right = new TreeNode(4);
		bt.root.right.left = new TreeNode(0);
		bt.root.right.right = new TreeNode(8);
		
		TreeNode p = new TreeNode(5);
		TreeNode q = new TreeNode(1);
		
		TreeNode ans = lowestCommonAncestor(bt.root, p, q);
		System.out.println(ans.data);

	}

}
