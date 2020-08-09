package com.app.julychallenge;

import java.util.HashMap;
import java.util.Map;

import com.app.questions.practice.BinaryTree;
import com.app.questions.practice.BinaryTree.TreeNode;

public class MaximumWidthOfBinaryTree {
	private static Map<Integer, Integer> leftmostPos;
	private static int maxWidth;
	
	private static void getWidth(TreeNode root, int level, int position) {
		if(root == null)
			return;
		leftmostPos.computeIfAbsent(level, x -> position);
		maxWidth = Integer.max(maxWidth, position - leftmostPos.get(level) + 1);
		getWidth(root.left, level + 1, 2 * position);
		getWidth(root.right, level + 1, 2 * position + 1);
	}
	
	private static int widthOfBinaryTree(TreeNode root) {
		leftmostPos = new HashMap<>();
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
		
		bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(3);
		bt.root.left.left = new TreeNode(5);
		bt.root.left.right = new TreeNode(3);
		
		maxWidth = widthOfBinaryTree(bt.root);
		
		System.out.println(maxWidth);
	}

}
