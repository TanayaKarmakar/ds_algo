package com.app.questions.practice;

import com.app.questions.practice.BinaryTree.TreeNode;

public class ConvertSortedArrayToBSTLeetcode108 {
	private static TreeNode convertTree(int[] nums, int start, int end) {
		if (start > end)
			return null;
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = convertTree(nums, start, mid - 1);
		root.right = convertTree(nums, mid + 1, end);
		return root;
	}
	
	private static void preorder(TreeNode root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void main(String[] args) {
		//int[] nums = { -10, -3, 0, 5, 9 };
		int[] nums = {-10};
		TreeNode node = convertTree(nums, 0, nums.length - 1);
		
		preorder(node);
	}

}
