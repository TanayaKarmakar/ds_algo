package com.app.tree;

import com.app.tree.BinaryTree.TreeNode;

public class SymmetricTree {
	private static boolean isSymmetric(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		return root1.val == root2.val && ((isSymmetric(root1.left, root2.left) 
				&& isSymmetric(root1.right, root2.right)) 
				|| (isSymmetric(root1.left, root2.right) 
						&& isSymmetric(root1.right, root2.left)));
	}
	
	private static boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		TreeNode left = root.left;
		TreeNode right = root.right;
		return isSymmetric(left, right);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(314);
		bt.root.left = new TreeNode(6);
		bt.root.right = new TreeNode(6);
		bt.root.left.right = new TreeNode(2);
		bt.root.right.left = new TreeNode(2);
		bt.root.left.right.right = new TreeNode(3);
		bt.root.right.left.left = new TreeNode(3);
		
		boolean ans = isSymmetric(bt.root);
		
		System.out.println(ans);

	}

}
