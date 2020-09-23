package com.app.practice.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class BoundaryTraversalOfBinaryTreeLeetcode545 {
	private static List<Integer> boundaryOfBinaryTree(TreeNode root) {
		if(root == null)
			return new ArrayList<>();
		List<Integer> result = new ArrayList<>();

		result.add(root.val);
		leftBoundary(root.left, result);
		leaves(root.left, result);
		leaves(root.right, result);
		rightBoundary(root.right, result);

		return result;
	}

	private static void leaves(TreeNode root, List<Integer> result) {
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();

		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();

			if (node.left == null && node.right == null)
				result.add(node.val);

			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}
	}

	private static void leftBoundary(TreeNode root, List<Integer> result) {
		if(root == null || (root.left == null && root.right == null))
			return;
		Queue<TreeNode> q = new LinkedList<>();

		q.add(root);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();

			if (node.left == null && node.right == null)
				continue;
			result.add(node.val);

			if (node.left != null)
				q.add(node.left);
			else if (node.right != null)
				q.add(node.right);
		}
	}

	private static void rightBoundary(TreeNode root, List<Integer> result) {
		if(root == null)
			return;
		Queue<TreeNode> q = new LinkedList<>();

		q.add(root);

		List<Integer> temp = new ArrayList<>();

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node.left == null && node.right == null)
				continue;
			temp.add(node.val);

			if (node.right != null)
				q.add(node.right);
			else if (node.left != null)
				q.add(node.left);
		}

		Collections.reverse(temp);
		result.addAll(temp);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.left = new TreeNode(4);
		bt.root.left.right = new TreeNode(5);
		bt.root.left.right.left = new TreeNode(7);
		bt.root.left.right.right = new TreeNode(8);
		bt.root.right.left = new TreeNode(6);
		bt.root.right.left.left = new TreeNode(9);
		bt.root.right.left.right = new TreeNode(10);

		List<Integer> result = boundaryOfBinaryTree(bt.root);

		System.out.println(result);
	}

}
