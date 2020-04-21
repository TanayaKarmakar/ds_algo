package com.app.questions.practice;

import com.app.questions.practice.BinaryTree.TreeNode;

public class MaximumBinaryTreeLeetcode654 {
	private static int findMax(int[] nums, int start, int end) {
		int indx = -1;
		int maxNum = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++) {
			if (nums[i] > maxNum) {
				maxNum = nums[i];
				indx = i;
			}
		}
		return indx;
	}

	private static TreeNode construct(int[] nums, int start, int end) {
		if (start > end)
			return null;
		int maxIndx = findMax(nums, start, end);
		TreeNode root = new TreeNode(nums[maxIndx]);
		root.left = construct(nums, start, maxIndx - 1);
		root.right = construct(nums, maxIndx + 1, end);
		return root;
	}

	private static TreeNode constructMaximumBinaryTree(int[] nums) {
		return construct(nums, 0, nums.length - 1);
	}
	
	private static void preorder(TreeNode root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 6, 0, 5 };
		
		TreeNode root = constructMaximumBinaryTree(nums);
		
		preorder(root);

	}

}
