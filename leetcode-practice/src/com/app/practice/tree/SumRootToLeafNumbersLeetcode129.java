package com.app.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class SumRootToLeafNumbersLeetcode129 {
	private static int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		Queue<Integer> qNum = new LinkedList<>();
		Queue<TreeNode> qNode = new LinkedList<>();
		qNum.add(root.val);
		qNode.add(root);

		int sum = 0;
		while (!qNode.isEmpty()) {
			int num = qNum.poll();
			TreeNode node = qNode.poll();

			if (node.left == null && node.right == null) {
				sum += num;
				continue;
			}

			if (node.left != null) {
				int newNum = (num * 10) + node.left.val;
				qNode.add(node.left);
				qNum.add(newNum);
			}

			if (node.right != null) {
				int newNum = (num * 10) + node.right.val;
				qNode.add(node.right);
				qNum.add(newNum);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		
		int sum = sumNumbers(bt.root);
		
		System.out.println(sum);
		
		bt = new BinaryTree();
		bt.root = new TreeNode(4);
		bt.root.left = new TreeNode(9);
		bt.root.right = new TreeNode(0);
		bt.root.left.left = new TreeNode(5);
		bt.root.left.right = new TreeNode(1);
		
		sum = sumNumbers(bt.root);
		
		System.out.println(sum);
	}

}
