package com.app.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class MergeTwoBinaryTreeLeetcode617 {
	private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return null;
		if (t1 == null || t2 == null) {
			if (t1 == null)
				return t2;
			if (t2 == null)
				return t1;
		}
		t1.val = t1.val + t2.val;
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		return t1;
	}

	private static void levelOrder(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			System.out.print(node.val + " ");
			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		BinaryTree bt1 = new BinaryTree();
		bt1.root = new TreeNode(1);
		bt1.root.left = new TreeNode(3);
		bt1.root.right = new TreeNode(2);
		bt1.root.left.left = new TreeNode(5);

		BinaryTree bt2 = new BinaryTree();
		bt2.root = new TreeNode(2);
		bt2.root.left = new TreeNode(1);
		bt2.root.right = new TreeNode(3);
		bt2.root.left.right = new TreeNode(4);
		bt2.root.right.right = new TreeNode(7);

		bt1.root = mergeTrees(bt1.root, bt2.root);

		levelOrder(bt1.root);
	}

}
