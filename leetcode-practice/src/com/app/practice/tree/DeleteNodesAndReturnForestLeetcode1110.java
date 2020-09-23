package com.app.practice.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class DeleteNodesAndReturnForestLeetcode1110 {
	private static TreeNode delNodesRec(TreeNode root, Set<Integer> delNodesSet, List<TreeNode> result) {
		if (root == null)
			return null;
		root.left = delNodesRec(root.left, delNodesSet, result);
		root.right = delNodesRec(root.right, delNodesSet, result);

		if (delNodesSet.contains(root.val)) {
			if (root.left != null)
				result.add(root.left);
			if (root.right != null)
				result.add(root.right);
			return null;
		}
		return root;
	}

	private static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		Set<Integer> delNodesSet = new HashSet<>();

		for (int el : to_delete) {
			delNodesSet.add(el);
		}

		List<TreeNode> result = new ArrayList<>();
		root = delNodesRec(root, delNodesSet, result);
		if (root!= null && !delNodesSet.contains(root.val)) {
			result.add(root);
		}

		return result;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.left = new TreeNode(4);
		bt.root.left.right = new TreeNode(5);
		bt.root.right.left = new TreeNode(6);
		bt.root.right.right = new TreeNode(7);

		List<TreeNode> result = delNodes(bt.root, new int[] { 3, 5 });

	}

}
