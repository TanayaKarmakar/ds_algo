package com.app.augustchallenge;

import com.app.augustchallenge.BinaryTree.TreeNode;

public class ClosestBinarySearchValue {
	private static double minDiff = Double.MAX_VALUE;
	private static TreeNode node;
	
	private static void closestValueRec(TreeNode root, double target) {
		if(root == null)
			return;
		double diff = Math.abs(root.val - target);
		if(diff < minDiff) {
			minDiff = diff;
			node = root;
		}
		if((double)root.val > target)
			closestValueRec(root.left, target);
		else
			closestValueRec(root.right, target);
	}
	
	private static int closestValue(TreeNode root, double target) {
		if(root == null)
			return 0;
		node = null;
		minDiff = Double.MAX_VALUE;
		closestValueRec(root, target);
		return node.val;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(4);
		bt.root.left = new TreeNode(2);
		bt.root.left.left = new TreeNode(1);
		bt.root.left.right = new TreeNode(3);
		bt.root.right = new TreeNode(5);
		
		System.out.println(closestValue(bt.root, 3.714286));

	}

}
