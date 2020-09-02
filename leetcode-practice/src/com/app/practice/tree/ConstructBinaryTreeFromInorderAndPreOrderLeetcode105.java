package com.app.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.app.practice.BinaryTree.TreeNode;

public class ConstructBinaryTreeFromInorderAndPreOrderLeetcode105 {
	private static int preIndx = 0;

	private static int findIndx(int el, int[] in) {
		int indx = -1;
		for (int i = 0; i < in.length; i++) {
			if (in[i] == el) {
				indx = i;
				break;
			}
		}
		return indx;
	}

	private static TreeNode construct(int[] pre, int[] in, int start, int end) {
		if (start > end)
			return null;
		int indx = findIndx(pre[preIndx], in);
		TreeNode root = new TreeNode(pre[preIndx]);
		preIndx++;
		root.left = construct(pre, in, start, indx - 1);
		root.right = construct(pre, in, indx + 1, end);
		return root;
	}

	private static TreeNode construct(int[] pre, int[] in) {
		preIndx = 0;
		return construct(pre, in, 0, pre.length - 1);
	}
	
	private static void levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			System.out.print(node.val + " ");
			if(node.left != null)
				q.add(node.left);
			if(node.right != null)
				q.add(node.right);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] pre = { 3, 9, 20, 15, 7 };
		int[] in = { 9, 3, 15, 20, 7 };
		
		TreeNode root = construct(pre, in);

		levelOrderTraversal(root);
	}

}
