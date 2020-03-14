package com.app.bst.classroom;

import com.app.bst.classroom.AugmentedBST.AugmentedBinaryTree.Node;

public class AugmentedBST {
	static class AugmentedBinaryTree {
		Node root;

		static class Node {
			int data;
			Node left;
			Node right;
			int lCount;

			public Node(int data) {
				this.data = data;
				this.left = null;
				this.right = null;
			}
		}
	}

	private static Node insert(Node root, int data) {
		if (root == null)
			return new Node(data);
		if (data < root.data) {
			root.lCount++;
			root.left = insert(root.left, data);
		} else {
			root.right = insert(root.right, data);
		}
		return root;
	}

	private static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.println("(" + root.data + "," + root.lCount + ")");
			inorder(root.right);
		}
	}

	private static int findKThSmallestElement(Node root, int k) {
		if(root == null)
			return -1;
		if ((root.lCount + 1) == k)
			return root.data;
		else if ((root.lCount + 1) > k)
			return findKThSmallestElement(root.left, k);
		else {
			return findKThSmallestElement(root.right, (k - root.lCount - 1));
		}
	}

	public static void main(String[] args) {
		int[] keys = { 50, 70, 35, 15, 75, 85, 20, 21 };
		AugmentedBinaryTree abt = new AugmentedBinaryTree();
		for (int i = 0; i < keys.length; i++) {
			abt.root = insert(abt.root, keys[i]);
		}

		inorder(abt.root);
		
		int kThSmallestElement = findKThSmallestElement(abt.root, 5);
		System.out.println("KThSmallestElement - " + kThSmallestElement);
		
		kThSmallestElement = findKThSmallestElement(abt.root, 3);
		System.out.println("kThSmallestElement - " + kThSmallestElement);
	}
}
