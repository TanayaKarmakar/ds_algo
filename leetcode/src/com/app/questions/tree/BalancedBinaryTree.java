package com.app.questions.tree;

import com.app.questions.tree.BinaryTree.Node;

public class BalancedBinaryTree {
	private static int getHeight(Node root) {
		if (root == null)
			return 0;
		return 1 + Integer.max(getHeight(root.left), getHeight(root.right));
	}

	private static boolean isBalanced(Node root) {
		if (root == null)
			return true;
		int lh = getHeight(root.left);
		int rh = getHeight(root.right);
		return Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(3);
		bt.root.left = new Node(9);
		bt.root.right = new Node(20);
		bt.root.right.left = new Node(15);
		bt.root.right.right = new Node(7);
		
		System.out.println("Is Balanced - " + isBalanced(bt.root));
		
		bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(2);
		bt.root.left.left = new Node(3);
		bt.root.left.right = new Node(3);
		bt.root.left.left.left = new Node(4);
		bt.root.left.left.right = new Node(4);
		
		System.out.println("Is Balanced - " + isBalanced(bt.root));
		
	}

}
