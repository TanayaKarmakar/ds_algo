package com.app.binarytree.classroom;

public class BinaryTree {
	Node root;
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
}
