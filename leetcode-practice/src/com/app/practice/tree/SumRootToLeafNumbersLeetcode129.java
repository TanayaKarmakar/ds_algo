package com.app.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

class SumNode {
	TreeNode tNode;
	int digitTillNow;

	public SumNode(TreeNode tNode, int digitTillNow) {
		this.tNode = tNode;
		this.digitTillNow = digitTillNow;
	}
}

public class SumRootToLeafNumbersLeetcode129 {

	private static int sumNumbers(TreeNode root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return root.val;
		Queue<SumNode> q = new LinkedList<>();
		SumNode sNode = new SumNode(root, root.val);

		q.add(sNode);

		int sum = 0;
		while (!q.isEmpty()) {
			SumNode node = q.poll();
			TreeNode tNode = node.tNode;
			int digit = node.digitTillNow;

			if (tNode.left == null && tNode.right == null) {
				sum += digit;
				continue;
			}

			if (tNode.left != null) {
				int newDigit = digit * 10 + tNode.left.val;
				q.add(new SumNode(tNode.left, newDigit));
			}

			if (tNode.right != null) {
				int newDigit = digit * 10 + tNode.right.val;
				q.add(new SumNode(tNode.right, newDigit));
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(4);
		bt.root.left = new TreeNode(9);
		bt.root.right = new TreeNode(0);
		bt.root.left.left = new TreeNode(5);
		bt.root.left.right = new TreeNode(1);
		
		int ans = sumNumbers(bt.root);
		
		System.out.println(ans);

	}

}
