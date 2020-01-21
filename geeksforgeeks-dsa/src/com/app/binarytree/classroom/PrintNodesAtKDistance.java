package com.app.binarytree.classroom;

import com.app.binarytree.classroom.BinaryTree.Node;

public class PrintNodesAtKDistance {
	private static void printNode(Node root, int dist, int k) {
		if(root == null)
			return;
		if(dist == k) {
			System.out.print(root.data + " ");
			return;
		}
		printNode(root.left, dist + 1, k);
		printNode(root.right, dist + 1, k);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(20);
		bt.root.right = new Node(60);
		bt.root.left.left = new Node(40);
		bt.root.left.right = new Node(50);
		
		printNode(bt.root, 0, 2);

	}

}
