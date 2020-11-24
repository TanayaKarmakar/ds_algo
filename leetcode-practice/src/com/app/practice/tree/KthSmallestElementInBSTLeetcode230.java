package com.app.practice.tree;

import java.util.Stack;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class KthSmallestElementInBSTLeetcode230 {
	private static int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}

			node = stack.pop();
			k--;
			if (k == 0)
				return node.val;
			node = node.right;
		}
		return -1;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(1);
		bt.root.right = new TreeNode(4);
		bt.root.left.right = new TreeNode(2);
		
		int ans = kthSmallest(bt.root, 1);
		
		System.out.println(ans);
	}

}
