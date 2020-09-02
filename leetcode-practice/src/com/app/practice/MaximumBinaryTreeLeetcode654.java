package com.app.practice;

import java.util.Queue;
import java.util.LinkedList;

import com.app.practice.BinaryTree.TreeNode;

public class MaximumBinaryTreeLeetcode654 {
	private static int findMax(int[] nums, int start, int end) {
		int indx = -1;
		int maxEl = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++) {
			if (nums[i] > maxEl) {
				maxEl = nums[i];
				indx = i;
			}
		}
		return indx;
	}

	private static TreeNode construct(int[] nums, int start, int end) {
		if(start > end)
			return null;
		int indx = findMax(nums, start, end);
		TreeNode root = new TreeNode(nums[indx]);
		root.left = construct(nums, start, indx - 1);
		root.right = construct(nums, indx + 1, end);
		return root;
	}

	private static TreeNode constructMaximumBinaryTree(int[] nums) {
		return construct(nums, 0, nums.length - 1);
	}

	private static void levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			System.out.print(node.val + " ");
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 6, 0, 5 };

		TreeNode root = constructMaximumBinaryTree(nums);

		levelOrderTraversal(root);

	}

}
