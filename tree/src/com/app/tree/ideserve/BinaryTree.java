package com.app.tree.ideserve;

public class BinaryTree {
	Node root;
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
}
