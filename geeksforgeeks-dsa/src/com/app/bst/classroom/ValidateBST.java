package com.app.bst.classroom;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class ValidateBST {
	private static int prev = Integer.MIN_VALUE;

	private static boolean isBSTInOrderTraversal(Node root) {
		if (root == null)
			return true;
		if (isBSTInOrderTraversal(root.left) == false)
			return false;
		if (root.data <= prev)
			return false;
		prev = root.data;
		return isBSTInOrderTraversal(root.right);
	}

	private static boolean isBST(Node root, int lowerBound, int upperBound) {
		if (root == null)
			return true;
		return (root.data > lowerBound && root.data < upperBound) && isBST(root.left, lowerBound, root.data)
				&& isBST(root.right, root.data, upperBound);
	}

	private static boolean isBST(Node root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(50);
		bt.root.left = new Node(35);
		bt.root.right = new Node(70);
		bt.root.left.left = new Node(15);
		bt.root.left.left.right = new Node(20);
		bt.root.left.left.right.right = new Node(21);
		bt.root.right.right = new Node(85);

		System.out.println(isBST(bt.root));
		System.out.println("Approach2 - " + isBSTInOrderTraversal(bt.root));

		bt = new BinaryTree();
		bt.root = new Node(5);
		bt.root.left = new Node(3);
		bt.root.right = new Node(8);
		bt.root.left.left = new Node(4);

		System.out.println(isBST(bt.root));
		System.out.println("Approach2 - " + isBSTInOrderTraversal(bt.root));

		bt = new BinaryTree();
		bt.root = new Node(20);
		bt.root.left = new Node(8);
		bt.root.right = new Node(30);
		bt.root.right.left = new Node(18);
		bt.root.right.right = new Node(35);

		System.out.println(isBST(bt.root));
		System.out.println("Approach2 - " + isBSTInOrderTraversal(bt.root));
	}

}
