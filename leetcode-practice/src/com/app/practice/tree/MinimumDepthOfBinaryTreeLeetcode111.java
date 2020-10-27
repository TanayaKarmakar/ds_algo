package com.app.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class MinimumDepthOfBinaryTreeLeetcode111 {
	private static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int depth = 1;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.left == null && node.right == null)
					return depth;
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			depth++;
		}

		return depth;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(9);
		bt.root.right = new TreeNode(20);
		bt.root.right.left = new TreeNode(15);
		bt.root.right.right = new TreeNode(7);
		
		int ans = minDepth(bt.root);
		
		System.out.println(ans);

	}

}
