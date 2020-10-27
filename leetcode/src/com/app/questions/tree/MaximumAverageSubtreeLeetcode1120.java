package com.app.questions.tree;

import com.app.questions.practice.BinaryTree;
import com.app.questions.practice.BinaryTree.TreeNode;

class DataNode {
	int sum;
	int count;

	public DataNode(int sum, int count) {
		this.sum = sum;
		this.count = count;
	}
}

public class MaximumAverageSubtreeLeetcode1120 {
	private static double maxAvg = Double.MIN_VALUE;

	private static DataNode calcAvg(TreeNode root) {
		if (root == null) {
			return new DataNode(0, 0);
		}

		DataNode left = calcAvg(root.left);
		DataNode right = calcAvg(root.right);

		int total = root.data + left.sum + right.sum;
		int count = 1 + left.count + right.count;

		double currAvg = total / (double) count;
		maxAvg = Double.max(maxAvg, currAvg);

		DataNode newNode = new DataNode(total, count);
		return newNode;
	}

	private static double maximumAverageSubtree(TreeNode root) {
		maxAvg = 0;
		calcAvg(root);
		
		return maxAvg;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(5);
		bt.root.left = new TreeNode(6);
		bt.root.right = new TreeNode(1);
		
		double maxAvg = maximumAverageSubtree(bt.root);
		
		System.out.println(maxAvg);
	}

}
