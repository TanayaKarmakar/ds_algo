package com.app.binarytree.classroom;

import com.app.binarytree.classroom.BinaryTree.Node;

public class BalancedBinaryTree {
	private static int checkIfBalancedEfficient(Node root) {
		if(root == null)
			return 0;
		int lh = checkIfBalancedEfficient(root.left);
		if(lh == -1)
			return -1;
		int rh = checkIfBalancedEfficient(root.right);
		if(rh == -1)
			return -1;
		if(Math.abs(lh - rh) > 1)
			return -1;
		return 1 + Integer.max(lh, rh);
	}
	
	
	private static int getHeight(Node root) {
		if (root == null)
			return 0;
		return 1 + Integer.max(getHeight(root.left), getHeight(root.right));
	}

	private static boolean checkIfBalanced(Node root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		
		int lHeight = getHeight(root.left);
		int rHeight = getHeight(root.right);

		return Math.abs(lHeight - rHeight) <= 1 
				&& checkIfBalanced(root.left) && checkIfBalanced(root.right);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(20);
		bt.root.right = new Node(60);
		bt.root.left.left = new Node(40);
		bt.root.left.right = new Node(50);
		
		System.out.println("Is Balanced - " + checkIfBalanced(bt.root));
		System.out.println("Is Balanced efficient - " + checkIfBalancedEfficient(bt.root));
		
		bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(50);
		bt.root.right = new Node(60);
		bt.root.right.left = new Node(70);
		bt.root.right.right = new Node(20);
		bt.root.right.left.right = new Node(8);
		
		System.out.println("Is Balanced - " + checkIfBalanced(bt.root));
		System.out.println("Is Balanced efficient - " + checkIfBalancedEfficient(bt.root));
		
		bt = new BinaryTree();
		bt.root = new Node(3);
		bt.root.left = new Node(4);
		bt.root.right = new Node(8);
		bt.root.left.left = new Node(5);
		bt.root.left.right = new Node(9);
		bt.root.right.right = new Node(7);
		bt.root.right.right.left = new Node(6);
		
		System.out.println("Is Balanced - " + checkIfBalanced(bt.root));
		System.out.println("Is Balanced efficient - " + checkIfBalancedEfficient(bt.root));

	}

}
