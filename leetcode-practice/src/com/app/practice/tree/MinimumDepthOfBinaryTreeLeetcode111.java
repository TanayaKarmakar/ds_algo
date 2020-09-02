package com.app.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class MinimumDepthOfBinaryTreeLeetcode111 {
	private static int minDepth(TreeNode root) {
		if(root == null)
			return 0;
		int count = 1;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			
			if(curr == null) {
				if(q.peek() != null) {
					q.add(null);
				}
				count++;
				continue;
			}
			
			boolean isLeaf = (curr.left == null && curr.right == null);
			if(isLeaf)
				return count;
			if(curr.left != null)
				q.add(curr.left);
			if(curr.right != null)
				q.add(curr.right);
		}
		return count;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(9);
		bt.root.right = new TreeNode(20);
		bt.root.right.left = new TreeNode(15);
		bt.root.right.right = new TreeNode(7);
		
		int count = minDepth(bt.root);
		
		System.out.println(count);
	}

}
