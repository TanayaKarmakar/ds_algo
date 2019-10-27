package com.app.tree.ideserve;

import com.app.tree.ideserve.BinaryTree.Node;

public class LowestCommonAncestor {
	private static Node findLCA(Node root, int a, int b) {
		if (root == null)
			return null;
		if (root.data == a || root.data == b)
			return root;
		Node left = findLCA(root.left, a, b);
		Node right = findLCA(root.right, a, b);

		if (left != null && right != null)
			return root;
		
		if(left == null)
			return right;
		else
			return left;

	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.left.right.left = new Node(6);
		bt.root.left.right.right = new Node(8);
		
		Node lca = findLCA(bt.root, 4, 8);
		System.out.println("LCA is " + lca.data);
	}

}
