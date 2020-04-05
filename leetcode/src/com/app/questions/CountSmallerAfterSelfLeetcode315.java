package com.app.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountSmallerAfterSelfLeetcode315 {
	private static List<Integer> countSmaller(int[] nums) {
		int n = nums.length;
		int[] count = new int[n];
		TreeNode root = null;

		for (int i = n - 1; i >= 0; i--) {
			count[i] = countSmaller(nums[i], root);
			root = insert(nums[i], root);
		}
		return Arrays.stream(count).boxed().collect(Collectors.toList());
	}

	private static int countSmaller(int number, TreeNode root) {
		if (root == null)
			return 0;
		else if (number == root.data)
			return root.smallerCount;
		else if (number < root.data)
			return countSmaller(number, root.left);
		else
			return 1 + root.smallerCount + countSmaller(number, root.right);
	}

	private static TreeNode insert(int number, TreeNode root) {
		if (root == null)
			return new TreeNode(number, 0);
		else if (number < root.data) {
			root.left = insert(number, root.left);
			root.smallerCount++;
		} else {
			root.right = insert(number, root.right);
		}
		return root;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 2, 6, 1 };
		List<Integer> count = countSmaller(nums);
		System.out.println(count);
	}

}

class TreeNode {
	int data;
	int smallerCount;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data, int smallerCount) {
		this.data = data;
		this.smallerCount = smallerCount;
		this.left = null;
		this.right = null;
	}
}
