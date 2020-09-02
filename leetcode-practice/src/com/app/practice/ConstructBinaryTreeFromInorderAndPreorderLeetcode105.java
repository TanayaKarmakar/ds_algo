package com.app.practice;

import com.app.practice.BinaryTree.TreeNode;

public class ConstructBinaryTreeFromInorderAndPreorderLeetcode105 {
	private static int preIndx = 0;
	
	private static int findElement(int el, int []in) {
		int indx = 0;
		for(int i = 0; i < in.length; i++) {
			if(in[i] == el) {
				indx = i;
				break;
			}
		}
		return indx;
	}
	
	private static TreeNode construct(int[] pre, int[] in, int start, int end) {
		if(start > end)
			return null;
		int indx = findElement(pre[preIndx], in);
		TreeNode root = new TreeNode(pre[preIndx++]);
		root.left = construct(pre, in, start, indx - 1);
		root.right = construct(pre, in, indx + 1, end);
		return root;
	}
	
	private static TreeNode construct(int[] pre, int[] in) {
		return construct(pre, in, 0, pre.length - 1);
	}
	
	private static void preOrder(TreeNode root) {
		if(root != null) {
			System.out.print(root.val + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public static void main(String[] args) {
		int[] pre = { 3, 9, 20, 15, 7 };
		int[] in = { 9, 3, 15, 20, 7 };
		
		TreeNode root = construct(pre, in);

		preOrder(root);
		
		System.out.println();
	}

}
