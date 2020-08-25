package com.app.augustchallenge;

import java.util.LinkedList;
import java.util.Queue;

import com.app.augustchallenge.BinaryTree.TreeNode;

public class SumOfLeftLeaves {
	private static int sumOfLeftLeaves(TreeNode root) {
		if(root == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		int sum = 0;
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			
			if(node.left != null) {
				boolean isLeaf = (node.left.left == null && node.left.right == null);
				if(isLeaf) {
					sum += node.left.val;
				}
				q.add(node.left);
			}
			
			if(node.right != null)
				q.add(node.right);
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
		
		int sum = sumOfLeftLeaves(bt.root);
		
		System.out.println(sum);
	}

}
