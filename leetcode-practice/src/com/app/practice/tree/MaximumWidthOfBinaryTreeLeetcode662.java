package com.app.practice.tree;

import java.util.HashMap;
import java.util.Map;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class MaximumWidthOfBinaryTreeLeetcode662 {
	private static Map<Integer, Integer> map;
	private static int maxWidth = 0;

	private static void getWidth(TreeNode root, int level, int position) {
		if (root == null)
			return;
		map.computeIfAbsent(level, x -> position);
		maxWidth = Integer.max(maxWidth, position - map.get(level) + 1);
		getWidth(root.left, level + 1, 2 * position);
		getWidth(root.right, level + 1, 2 * position + 1);
	}

	private static int widthOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		map = new HashMap<>();
		maxWidth = 0;
		getWidth(root, 0, 0);
		return maxWidth;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(3);
		bt.root.right = new TreeNode(2);
		bt.root.left.left = new TreeNode(5);
		bt.root.left.right = new TreeNode(3);
		bt.root.right.right = new TreeNode(9);
		
		int maxWidth = widthOfBinaryTree(bt.root);
		
		System.out.println(maxWidth);

	}

}
