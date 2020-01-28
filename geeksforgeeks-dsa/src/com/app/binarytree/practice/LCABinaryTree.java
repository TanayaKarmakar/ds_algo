package com.app.binarytree.practice;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class LCABinaryTree {
	private static Node lca(Node root, int n1, int n2) {
		if (root == null)
			return null;
		if (root.data == n1 || root.data == n2)
			return root;
		Node left = lca(root.left, n1, n2);
		Node right = lca(root.right, n1, n2);
		if (left != null && right != null)
			return root;
		if (left == null && right == null)
			return null;
		return left != null ? left : right;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(3);
		bt.root.left = new Node(6);
		bt.root.right = new Node(8);
		bt.root.left.left = new Node(2);
		bt.root.left.right = new Node(11);
		bt.root.left.right.left = new Node(9);
		bt.root.left.right.right = new Node(5);
		bt.root.right.right = new Node(13);
		bt.root.right.right.left = new Node(7);

		System.out.println("lca(2,5) - " + lca(bt.root, 2, 5).data);
		System.out.println("lca(11,7) - " + lca(bt.root, 11, 7).data);
		System.out.println("lca(8,7) - " + lca(bt.root, 8, 7).data);
	}

}
