package com.app.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class SumOfLeftLeavesLeetcode404 {
	private static boolean isLeaf(TreeNode root) {
		return root.left == null && root.right == null;
	}
	
	private static int sumOfLeftLeave(TreeNode root) {
		if(root == null || (root.left == null && root.right == null))
			return 0;
		int sum = 0;
		Queue<TreeNode> q = new LinkedList<>();
		
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			if(node.left != null) {
				if(isLeaf(node.left)) {
					sum += node.left.val;
				}
				q.add(node.left);
			}
			if(node.right != null) {
				q.add(node.right);
			}
		}
		
		return sum;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(9);
		bt.root.right = new TreeNode(20);
		bt.root.right.left = new TreeNode(15);
		bt.root.right.right = new TreeNode(7);
		
		int sum = sumOfLeftLeave(bt.root);
		
		System.out.println(sum);

	}

}
