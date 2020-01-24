package com.app.binarytree.classroom;

import java.util.LinkedList;
import java.util.Queue;

import com.app.binarytree.classroom.BinaryTree.Node;

public class ConstructFromInorderPreorder {
	private static int preIndx = 0;
	
	private static int search(int[] in, int data) {
		for (int i = 0; i < in.length; i++) {
			if (in[i] == data)
				return i;
		}
		return -1;
	}

	private static Node construct(int[] pre, int[] in, int start, int end) {
		if (start > end)
			return null;
		int indx = search(in, pre[preIndx++]);
		if (indx == -1)
			return null;

		Node root = new Node(in[indx]);
		root.left = construct(pre, in, start, indx - 1);
		root.right = construct(pre, in, indx + 1, end);
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

	private static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		int[] in = { 5, 10, 30, 20, 40 };
		int[] pre = { 10, 5, 20, 30, 40 };

		BinaryTree bt = new BinaryTree();
		bt.root = construct(pre, in, 0, in.length - 1);

		levelOrderTraversal(bt.root);
		
		inorder(bt.root);
		
		System.out.println();
		
		in = new int[] {40, 20, 60, 50, 70, 10, 80, 100, 30};
		pre = new int[] {10, 20, 40, 50, 60, 70, 30, 80, 100};
		
		
		preIndx = 0;
		bt = new BinaryTree();
		bt.root = construct(pre, in, 0, in.length - 1);
		
		levelOrderTraversal(bt.root);
		
		inorder(bt.root);
		
		System.out.println();

	}

}
