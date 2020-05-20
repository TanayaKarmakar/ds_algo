package com.app.questions.tree;

import com.app.questions.tree.BinaryTree.Node;

public class MinimumDepth {
	private static int minDepth(Node root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		if(root.left == null)
			return 1 + minDepth(root.right);
		if(root.right == null)
			return 1 + minDepth(root.left);
		
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(3);
		bt.root.left = new Node(9);
		bt.root.right = new Node(20);
		bt.root.right.left = new Node(15);
		bt.root.right.right = new Node(7);
		
		int depth = minDepth(bt.root);
		
		System.out.println("Depth - " + depth);
		
		bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		
		depth = minDepth(bt.root);
		
		System.out.println("Depth - " + depth);
	}

}
