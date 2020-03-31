package com.app.questions;

import com.app.questions.BinaryTree.Node;

public class PathSumEfficientLeetcode112 {
	private static boolean isLeaf(Node root) {
		return root.left == null && root.right == null;
	}
	
	private static boolean isPathSum(Node root, int currentSum ,int sum) {
		if(root == null)
			return false;
		if(isLeaf(root)) {
			if(currentSum + root.data == sum)
				return true;
			else
				return false;
		}
		boolean lPathSum = isPathSum(root.left, currentSum + root.data, sum);
		boolean rPathSum = isPathSum(root.right, currentSum + root.data, sum);
		
		return lPathSum || rPathSum;
	}
	
	private static boolean hasPathSum(Node root, int sum) {
		return isPathSum(root, 0, sum);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(5);
		bt.root.left = new Node(4);
		bt.root.right = new Node(8);
		bt.root.left.left = new Node(11);
		bt.root.left.left.left = new Node(7);
		bt.root.left.left.right = new Node(2);
		bt.root.right.left = new Node(13);
		bt.root.right.right = new Node(4);
		bt.root.right.right.right = new Node(1);
		
		System.out.println(hasPathSum(bt.root, 22));

	}

}
