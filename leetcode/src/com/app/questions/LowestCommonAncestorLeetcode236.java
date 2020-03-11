package com.app.questions;

import com.app.questions.BinaryTree.Node;

public class LowestCommonAncestorLeetcode236 {
	private static Node lowestCommonAncestor(Node root, Node p, Node q) {
		if(root == null)
			return null;
		if(root == p || root == q)
			return root;
		Node left = lowestCommonAncestor(root.left, p, q);
		Node right = lowestCommonAncestor(root.right, p, q);
		
		if(left != null && right != null)
			return root;
		else if(left == null)
			return right;
		else
			return left;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(3);
		bt.root.left = new Node(5);
		bt.root.right = new Node(1);
		bt.root.left.left = new Node(6);
		bt.root.left.right = new Node(2);
		bt.root.left.right.left = new Node(7);
		bt.root.left.right.right = new Node(4);
		bt.root.right.left = new Node(0);
		bt.root.right.right = new Node(8);
		
		System.out.println(lowestCommonAncestor(bt.root, bt.root.left, bt.root.right).data);

	}

}
