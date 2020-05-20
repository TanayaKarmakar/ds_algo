package com.app.questions.tree;

import com.app.questions.tree.BinaryTree.Node;

public class DeepestLeavesSumLeetcode1302 {
	private static int sum = 0;
	private static int maxDepth = 0;

	private static void traverseDepthAndDoSum(Node root, int currentLevel) {
		if (root == null)
			return;
		boolean isLeaf = (root.left == null && root.right == null);
		if (isLeaf) {
			if (maxDepth < currentLevel) {
				sum = root.data;
				maxDepth = currentLevel;
			} else if(maxDepth == currentLevel) {
				sum += root.data;
			} else {
				return;
			}
		}
		traverseDepthAndDoSum(root.left, currentLevel + 1);
		traverseDepthAndDoSum(root.right, currentLevel + 1);
	}

	private static int deepestSumLeaves(Node root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return root.data;
		traverseDepthAndDoSum(root, 0);
		return sum;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.left.left.left = new Node(7);
		bt.root.right.right = new Node(6);
		bt.root.right.right.right = new Node(8);
		
		System.out.println(deepestSumLeaves(bt.root));

	}

}
