package com.app.tree;

import com.app.tree.BinaryTree.TreeNode;

public class ConstructABinaryTreeFromPreorderAndInorder {
	private static int preIndx = 0;

	private static int find(int el, int[] inorder, int start, int end) {
		for (int i = start; i <= end; i++) {
			if (inorder[i] == el)
				return i;
		}
		return -1;
	}

	private static TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
		if(start > end)
			return null;
		int inIndx = find(preorder[preIndx], inorder, start, end);
		TreeNode root = new TreeNode(preorder[preIndx]);
		preIndx++;
		root.left = buildTree(preorder, inorder, start, inIndx - 1);
		root.right = buildTree(preorder, inorder, inIndx + 1, end);
		return root;
	}

	private static TreeNode buildTree(int[] preorder, int[] inorder) {
		preIndx = 0;
		return buildTree(preorder, inorder, 0, preorder.length - 1);
	}
	
	private static void inorder(TreeNode root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.val + " ");
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		int[] pre = { 3, 9, 20, 15, 7 };
		int[] in = { 9, 3, 15, 20, 7 };
		TreeNode root = buildTree(pre, in);
		
		inorder(root);
		System.out.println();
		
	}

}
