package com.app.questions;

public class BinaryTree {
	public Node root;
	
	public static class Node {
		public int data;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
}
