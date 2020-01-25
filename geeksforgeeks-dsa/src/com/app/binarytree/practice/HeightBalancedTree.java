package com.app.binarytree.practice;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class HeightBalancedTree {
	private static int getHeight(Node root) {
		if (root == null)
			return 0;
		return 1 + Integer.max(getHeight(root.left), getHeight(root.right));
	}

	private static boolean isHeightBalanced(Node root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		int lHeight = getHeight(root.left);
		int rHeight = getHeight(root.right);
		return Math.abs(lHeight - rHeight) <= 1 
				&& isHeightBalanced(root.left) && isHeightBalanced(root.right);

	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.left.right = new Node(3);
		
		System.out.println("Is Height Balanced - " + isHeightBalanced(bt.root));
		
		bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		System.out.println("Is Height Balanced - " + isHeightBalanced(bt.root));
		
	}

}
