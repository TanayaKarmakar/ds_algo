package com.app.bst.classroom;

import java.util.LinkedList;
import java.util.Queue;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class Insertion {
	private static Node insertionIterative(Node root, int x) {
		Node current = root;
		Node parent = null;
		Node temp = new Node(x);

		while (current != null) {
			parent = current;
			if (current.data < x)
				current = current.right;
			else if (current.data > x)
				current = current.left;
			else
				return root;
		}

		if (parent == null)
			return temp;
		else if (parent.data < x) {
			parent.right = temp;
		} else {
			parent.left = temp;
		}

		return root;
	}

	private static Node insert(Node root, int x) {
		if (root == null) {
			return new Node(x);
		} else if (root.data < x) {
			root.right = insert(root.right, x);
		} else {
			root.left = insert(root.left, x);
		}
		return root;
	}

	private static void levelOrderTraversal(Node root) {
		Queue<Node> nodeQ = new LinkedList<>();
		nodeQ.add(root);

		while (!nodeQ.isEmpty()) {
			Node node = nodeQ.poll();
			System.out.print(node.data + " ");

			if (node.left != null) {
				nodeQ.add(node.left);
			}

			if (node.right != null) {
				nodeQ.add(node.right);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 10, 15, 5, 18, 12 };
		BinaryTree bt = new BinaryTree();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			bt.root = insert(bt.root, arr[i]);
		}

		levelOrderTraversal(bt.root);

		BinaryTree bt1 = new BinaryTree();

		for (int i = 0; i < n; i++) {
			bt1.root = insertionIterative(bt1.root, arr[i]);
		}

		levelOrderTraversal(bt1.root);
	}

}
