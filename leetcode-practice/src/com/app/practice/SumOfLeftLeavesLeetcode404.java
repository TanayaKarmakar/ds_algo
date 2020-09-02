package com.app.practice;

import java.util.Queue;
import java.util.LinkedList;

import com.app.practice.BinaryTree.TreeNode;

public class SumOfLeftLeavesLeetcode404 {
	private static boolean isLeaf(TreeNode root) {
		return root.left == null && root.right == null;
	}
	
	private static int sumOfLeftLeaves(TreeNode root) {
		if(root == null || (root.left == null && root.right == null))
			return 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		
		int sum = 0;
		while(q.size() > 1) {
			TreeNode node = q.poll();
			if(node == null) {
				q.add(null);
				continue;
			}
			if(node.left != null) {
				q.add(node.left);
				if(isLeaf(node.left)) {
					sum += node.left.val;
				}
			}
			
			if(node.right != null) {
				q.add(node.right);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);
		
		int sum = sumOfLeftLeaves(node);
		
		System.out.println(sum);

	}

}
