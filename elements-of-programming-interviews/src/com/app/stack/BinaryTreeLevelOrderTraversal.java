package com.app.stack;

import java.util.LinkedList;
import java.util.Queue;

import com.app.tree.BinaryTree;
import com.app.tree.BinaryTree.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	private static void levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				System.out.print(node.val + " ");
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			System.out.print("###");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(314);
		bt.root.left = new TreeNode(6);
		bt.root.right = new TreeNode(6);
		bt.root.left.left = new TreeNode(271);
		bt.root.left.right = new TreeNode(561);
		bt.root.right.left = new TreeNode(2);
		bt.root.right.right = new TreeNode(271);
		bt.root.left.left.left = new TreeNode(28);
		bt.root.left.left.right = new TreeNode(0);
		bt.root.left.right.right = new TreeNode(3);
		bt.root.right.left.right = new TreeNode(1);
		bt.root.right.right.right = new TreeNode(28);
		bt.root.left.right.right.left = new TreeNode(17);
		bt.root.right.left.right.left = new TreeNode(401);
		bt.root.right.left.right.right = new TreeNode(257);
		bt.root.right.left.right.left.right = new TreeNode(641);
		
		levelOrderTraversal(bt.root);

	}

}
