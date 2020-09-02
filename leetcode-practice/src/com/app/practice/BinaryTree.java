package com.app.practice;

public class BinaryTree {
	public TreeNode root;
	
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int data) {
			this.val = data;
			this.left = null;
			this.right = null;
		}
		
		public String toString() {
			return String.valueOf(val);
		}
	}
}
