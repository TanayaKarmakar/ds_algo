package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class SubtreeOfAnotherTreeLeetcode572 {
	private static boolean isEqual(TreeNode s, TreeNode t) {
		if(s == null && t == null)
			return true;
		if(s == null || t == null)
			return false;
		return (s.val == t.val) && isEqual(s.left, t.left) 
				&& isEqual(s.right, t.right);
	}
	
	private static boolean isSubtree(TreeNode s, TreeNode t) {
		if(s == null)
			return false;
		return isEqual(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	public static void main(String[] args) {
		BinaryTree s = new BinaryTree();
		s.root = new TreeNode(3);
		s.root.left = new TreeNode(4);
		s.root.right = new TreeNode(5);
		s.root.left.left = new TreeNode(1);
		s.root.left.right = new TreeNode(2);
		
		BinaryTree t = new BinaryTree();
		t.root = new TreeNode(4);
		t.root.left = new TreeNode(1);
		t.root.right = new TreeNode(2);
		
		boolean ans = isSubtree(s.root, t.root);
		
		System.out.println(ans);

	}

}
