package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class ClosestBinarySearchTreeValueLeetcode270 {
	private static double minDiff = Double.MAX_VALUE;
	private static int element;
	
	private static void closestValueRec(TreeNode root, double target) {
		if(root == null)
			return;
		double diff = Math.abs((double)root.val - target);
		if(diff < minDiff) {
			minDiff = diff;
			element = root.val;
		}
		
		if((double)root.val > target)
			closestValueRec(root.left, target);
		else
			closestValueRec(root.right, target);
		
	}
	
	private static int closestValue(TreeNode root, double target) {
		if(root == null)
			return 0;
		minDiff = Double.MAX_VALUE;
		element = 0;
		closestValueRec(root, target);
		return element;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(4);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(5);
		bt.root.left.left = new TreeNode(1);
		bt.root.left.right = new TreeNode(3);
		
		int ans = closestValue(bt.root, 3.714286);
		
		System.out.println(ans);
	}

}
