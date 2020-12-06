package com.app.tree;

public class BinaryTree {
	public TreeNode root;
	
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

}
