package com.app.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.app.practice.BinaryTree.TreeNode;

public class ConvertSortedArrayIntoBinarySearchTreeLeetcode108 {

	private static TreeNode makeBST(int[] nums, int start, int end) {
		if(start > end)
			return null;
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = makeBST(nums, start, mid - 1);
		root.right = makeBST(nums, mid + 1, end);
		return root;
	}
	
	private static TreeNode sortedArrayToBST(int[] nums) {
		return makeBST(nums, 0, nums.length - 1);
	}
	
	private static void levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			
			System.out.print(curr.val + " ");
			
			if(curr.left != null)
				q.add(curr.left);
			if(curr.right != null)
				q.add(curr.right);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {-10, -3, 0, 5, 9};
		TreeNode root = sortedArrayToBST(nums);
		
		levelOrderTraversal(root);
	}

}
