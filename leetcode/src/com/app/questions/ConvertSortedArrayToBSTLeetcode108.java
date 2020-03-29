package com.app.questions;

import com.app.questions.BinaryTree.Node;

public class ConvertSortedArrayToBSTLeetcode108 {
	private static Node sortedArrayToBST(int[] nums, int start, int end) {
		if (end < start)
			return null;
		int mid = start + (end - start) / 2;
		Node root = new Node(nums[mid]);
		root.left = sortedArrayToBST(nums, start, mid - 1);
		root.right = sortedArrayToBST(nums, mid + 1, end);
		return root;
	}

	private static Node sortedArrayToBST(int[] nums) {
		Node root = sortedArrayToBST(nums, 0, nums.length - 1);
		return root;
	}
	
	private static void preOrder(Node root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public static void main(String[] args) {
		int[] nums = { -10, -3, 0, 5, 9 };
		Node root = sortedArrayToBST(nums);
		preOrder(root);
	}

}
