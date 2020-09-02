package com.app.practice.tree;

import java.util.Stack;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class KthSmallestElementInABSTLeetcode230 {
	private static int kThSmallest(TreeNode root, int k) {
		TreeNode curr = root;
		Stack<TreeNode> stack = new Stack<>();

		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}

			curr = stack.pop();
			k--;
			if (k == 0)
				return curr.val;
			curr = curr.right;
		}

		return -1;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(1);
		bt.root.right = new TreeNode(4);
		bt.root.left.right = new TreeNode(2);
		
		int kThSmallest = kThSmallest(bt.root, 1);
		
		System.out.println(kThSmallest);
		
		bt = new BinaryTree();
		bt.root = new TreeNode(5);
		bt.root.left = new TreeNode(3);
		bt.root.right = new TreeNode(6);
		bt.root.left.left = new TreeNode(2);
		bt.root.left.right = new TreeNode(4);
		bt.root.left.left.left = new TreeNode(1);
		
		kThSmallest = kThSmallest(bt.root, 3);
		
		System.out.println(kThSmallest);
	}

}
