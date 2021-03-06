package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class PathSumIIILeetcode437 {
	private static int pathSum2(TreeNode root, int sum) {
		if (root == null)
			return 0;
		int res = 0;
		if (root.val == sum)
			res++;
		res += pathSum2(root.left, sum - root.val);
		res += pathSum2(root.right, sum - root.val);
		return res;
	}

	private static int pathSum(TreeNode root, int sum) {
		if (root == null)
			return 0;
		return pathSum(root.left, sum) + pathSum(root.right, sum) + pathSum2(root, sum);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(10);
		bt.root.left = new TreeNode(5);
		bt.root.right = new TreeNode(-3);
		bt.root.left.left = new TreeNode(3);
		bt.root.left.right = new TreeNode(2);
		bt.root.left.left.left = new TreeNode(3);
		bt.root.left.left.right = new TreeNode(-2);
		bt.root.left.right.right = new TreeNode(1);
		bt.root.right.right = new TreeNode(11);

		int count = pathSum(bt.root, 8);

		System.out.println(count);

	}

}
