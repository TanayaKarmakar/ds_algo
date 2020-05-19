package com.app.questions.tree;

import com.app.questions.tree.BinaryTree.Node;

public class DepthOfBinaryTree {
	private static int maxDepth(Node node) {
		if(node == null)
			return 0;
		int lRes = maxDepth(node.left);
		int rRes = maxDepth(node.right);
		
		return 1 + Integer.max(lRes, rRes);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(3);
		bt.root.left = new Node(9);
		bt.root.right = new Node(20);
		bt.root.right.left = new Node(15);
		bt.root.right.right = new Node(7);
		
		int depth = maxDepth(bt.root);
		
		System.out.println("Depth - " + depth);

	}

}
