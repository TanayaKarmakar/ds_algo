package com.app.questions.practice;

import com.app.questions.practice.BinaryTree.TreeNode;

public class ConstructBinaryTreeFromInorderPreorderLeetcode105 {
	private static int preIndx = 0;
	
	private static int findElement(int[] in, int el, int start, int end) {
		for(int i = start; i <= end; i++) {
			if(in[i] == el)
				return i;
		}
		return -1;
	}
	
	private static TreeNode buildTreeRec(int[] pre, int[] in, int start, int end) {
		if(start > end)
			return null;
		TreeNode node = new TreeNode(pre[preIndx]);
		int inIndx = findElement(in, pre[preIndx], start, end);
		preIndx++;
		node.left = buildTreeRec(pre, in, start, inIndx - 1);
		node.right = buildTreeRec(pre, in, inIndx + 1, end);
		return node;
	}
	
	private static TreeNode buildTree(int[] pre, int[] in) {
		preIndx = 0;
		return buildTreeRec(pre, in, 0, pre.length - 1);
	}
	
	private static void preorder(TreeNode root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		int[] in = { 3, 9, 20, 15, 7 };
		int[] pre = { 9, 3, 15, 20, 7 };

		TreeNode root = buildTree(pre, in);
		preorder(root);
	}

}
