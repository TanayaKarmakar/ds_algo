package com.app.practice.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class DeleteNodesAndReturnForestLeetcode1110 {
	private static TreeNode removeNodes(TreeNode root, Set<Integer> set, List<TreeNode> res) {
		if (root == null)
			return null;
		root.left = removeNodes(root.left, set, res);
		root.right = removeNodes(root.right, set, res);

		if (set.contains(root.val)) {
			if (root.left != null)
				res.add(root.left);
			if (root.right != null)
				res.add(root.right);
			return null;
		}
		return root;
	}

	private static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		Set<Integer> set = new HashSet<>();

		for (int num : to_delete) {
			set.add(num);
		}

		List<TreeNode> res = new ArrayList<>();
		removeNodes(root, set, res);

		if (!set.contains(root.val))
			res.add(root);
		return res;
	}
	
	private static void displayForest(List<TreeNode> res) {
		
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

		List<TreeNode> res = delNodes(bt.root, new int[] { 3, 5 });
		
		displayForest(res);

	}

}
