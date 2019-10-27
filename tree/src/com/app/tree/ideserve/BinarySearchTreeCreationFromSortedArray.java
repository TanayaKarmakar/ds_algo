package com.app.tree.ideserve;

import java.util.LinkedList;
import java.util.Queue;

import com.app.tree.ideserve.BinaryTree.Node;

public class BinarySearchTreeCreationFromSortedArray {
	private static Node createBinaryTreeFromSortedArray(Node root, int[] arr, int start, int end) {
		if (arr.length == 0 || start > end)
			return null;

		int mid = (start + end) / 2;
		root = new Node(arr[mid]);
		root.left = createBinaryTreeFromSortedArray(root.left, arr, start, mid - 1);
		root.right = createBinaryTreeFromSortedArray(root.right, arr, mid + 1, end);
		return root;
	}

	private static void levelOrderTraversal(BinaryTree bt) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(bt.root);
		queue.add(null);

		while (!queue.isEmpty()) {
			Node currNode = queue.poll();
			if (currNode == null) {
				System.out.println();
				if(queue.peek() != null) {
					queue.add(null);
				}
			} else {
				System.out.print(currNode.data + "\t");
				if (currNode.left != null) {
					queue.add(currNode.left);
				}
				if (currNode.right != null) {
					queue.add(currNode.right);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		BinaryTree bt = new BinaryTree();
		bt.root = createBinaryTreeFromSortedArray(bt.root, arr, 0, arr.length - 1);
		levelOrderTraversal(bt);		
	}

}
