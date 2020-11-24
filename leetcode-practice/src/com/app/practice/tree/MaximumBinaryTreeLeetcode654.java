package com.app.practice.tree;

import com.app.practice.BinaryTree.TreeNode;

public class MaximumBinaryTreeLeetcode654 {
	private static int findMaxIndex(int[] nums, int start, int end) {
		int indx = -1;
		int maxValue = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++) {
			if (nums[i] >= maxValue) {
				maxValue = nums[i];
				indx = i;
			}
		}
		return indx;
	}

	private static TreeNode constructTreeRec(int[] nums, int start, int end) {
		if (start > end)
			return null;
		int indx = findMaxIndex(nums, start, end);
		TreeNode root = new TreeNode(nums[indx]);
		root.left = constructTreeRec(nums, start, indx - 1);
		root.right = constructTreeRec(nums, indx + 1, end);
		return root;

	}

	private static TreeNode constructMaximumBinaryTree(int[] nums) {
		return constructTreeRec(nums, 0, nums.length - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
