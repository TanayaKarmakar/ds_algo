package com.app.practice;

import com.app.practice.BinaryTree.TreeNode;

public class FlipEquivalentTreeLeetcode951 {
	private static boolean flipEquiv(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		if(root1.val != root2.val)
			return false;
		boolean option1 = flipEquiv(root1.left, root2.left);
		boolean option2 = flipEquiv(root1.right, root2.right);
		boolean option3 = flipEquiv(root1.left, root2.right);
		boolean option4 = flipEquiv(root1.right, root2.left);
		
		return ((option1 && option2) || (option3 && option4));
	}

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
		root1.left.right.left = new TreeNode(7);
		root1.left.right.right = new TreeNode(8);
		root1.right.left = new TreeNode(6);
		
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(3);
		root2.right = new TreeNode(2);
		root2.left.right = new TreeNode(6);
		root2.right.left = new TreeNode(4);
		root2.right.right = new TreeNode(5);
		root2.right.right.left = new TreeNode(8);
		root2.right.right.right = new TreeNode(7);
		
		System.out.println(flipEquiv(root1, root2));

	}

}
