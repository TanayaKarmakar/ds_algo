package com.app.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

class NodeItem {
	TreeNode node;
	int numTillNow;

	public NodeItem(TreeNode node, int numTillNow) {
		this.node = node;
		this.numTillNow = numTillNow;
	}
}

public class SumRootToLeafNumbersLeetcode129 {
	private static int sumNumbers(TreeNode root) {
		if(root == null)
			return 0;
		Queue<NodeItem> q = new LinkedList<>();
		q.add(new NodeItem(root, root.val));
		int sum = 0;

		while (!q.isEmpty()) {
			NodeItem item = q.poll();

			TreeNode node = item.node;
			int numTillNow = item.numTillNow;
			if (node.left == null && node.right == null) {
				sum += numTillNow;
				continue;
			}

			if (node.left != null) {
				int newNum = numTillNow * 10 + node.left.val;
				q.add(new NodeItem(node.left, newNum));
			}

			if (node.right != null) {
				int newNum = numTillNow * 10 + node.right.val;
				q.add(new NodeItem(node.right, newNum));
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		
		int ans = sumNumbers(bt.root);
		
		System.out.println(ans);

	}

}
