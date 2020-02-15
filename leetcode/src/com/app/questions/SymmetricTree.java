package com.app.questions;

import java.util.Queue;
import java.util.LinkedList;

import com.app.questions.BinaryTree.Node;

public class SymmetricTree {
	// leetcode recursive
	private static boolean isSymmetric1(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		return root1.data == root2.data 
				&& isSymmetric1(root1.left, root2.right) 
				&& isSymmetric1(root1.right, root2.left);
	}

	private static boolean isEqual(Node root1, Node root2) {
		if (root1 == null || root2 == null)
			if (root1 == null && root2 == null)
				return true;
			else
				return false;
		return root1.data == root2.data 
				&& isEqual(root1.left, root2.left) 
				&& isEqual(root1.right, root2.right);
	}

	private static boolean isSymmetric(Node root) {
		if (root == null)
			return true;
		if (root.left == null || root.right == null) {
			if (root.left == null && root.right == null)
				return true;
			else
				return false;
		}
		Node left = root.left;
		Node right = root.right;

		// exchanging the left and right for the right child
		Queue<Node> qR = new LinkedList<>();
		qR.add(right);
		while (!qR.isEmpty()) {
			Node node = qR.poll();

			Node tmp = node.left;
			node.left = node.right;
			node.right = tmp;

			if (node.left != null)
				qR.add(node.left);
			if (node.right != null)
				qR.add(node.right);
		}

		return isEqual(left, right);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(2);
		bt.root.left.left = new Node(3);
		bt.root.left.right = new Node(4);
		bt.root.right.left = new Node(4);
		bt.root.right.right = new Node(3);

		System.out.println(isSymmetric(bt.root));

		bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(2);
		bt.root.left.right = new Node(3);
		bt.root.right.right = new Node(3);

		System.out.println(isSymmetric(bt.root));
		
		System.out.println("Leetcode approach");
		
		bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(2);
		bt.root.left.left = new Node(3);
		bt.root.left.right = new Node(4);
		bt.root.right.left = new Node(4);
		bt.root.right.right = new Node(3);
		
		System.out.println(isSymmetric1(bt.root.left, bt.root.right));
		
		bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(2);
		bt.root.left.right = new Node(3);
		bt.root.right.right = new Node(3);
		
		System.out.println(isSymmetric1(bt.root.left, bt.root.right));

	}

}
