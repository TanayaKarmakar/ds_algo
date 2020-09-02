package com.app.practice;

import java.util.Queue;
import java.util.LinkedList;

import com.app.practice.BinaryTree.TreeNode;

public class MinimumDepthOfBinaryTreeLeetcode111 {
	private static int minDepth(TreeNode root) {
		if(root == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<>();
		int depth = 1;
		q.add(root);
		q.add(null);
		
		while(q.size() > 1) {
			TreeNode node = q.poll();
			if(node == null) {
				q.add(null);
				depth++;
				continue;
			}
			if(node.left == null && node.right == null)
				return depth;
			if(node.left != null) {
				q.add(node.left);
			}
			if(node.right != null) {
				q.add(node.right);
			}
		}
		return depth;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		int minDepth = minDepth(root);
		
		System.out.println(minDepth);

	}

}
