package com.app.tree;

import java.util.ArrayList;
import java.util.List;

import com.app.tree.BinaryTree.TreeNode;

public class LeavesOfABinaryTree {
	private static void preorder(TreeNode root, List<Integer> result) {
		if (root != null) {
			boolean isLeaf = (root.left == null && root.right == null);
			if (isLeaf) {
				result.add(root.val);
			}
			preorder(root.left, result);
			preorder(root.right, result);
		}
	}

	private static List<Integer> computeLeaves(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		preorder(root, result);
		return result;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(9);
		bt.root.left = new TreeNode(5);
		bt.root.right = new TreeNode(11);
		bt.root.left.left = new TreeNode(3);
		bt.root.left.right = new TreeNode(7);
		bt.root.left.left.right = new TreeNode(4);
		bt.root.left.right.left = new TreeNode(6);
		bt.root.right.left = new TreeNode(10);
		
		List<Integer> result = computeLeaves(bt.root);
		
		System.out.println(result);

	}

}
