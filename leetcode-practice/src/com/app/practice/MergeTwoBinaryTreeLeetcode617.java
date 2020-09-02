package com.app.practice;

import java.util.Queue;
import java.util.LinkedList;

import com.app.practice.BinaryTree.TreeNode;

public class MergeTwoBinaryTreeLeetcode617 {
	private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null)
			return null;
		if(root1 == null || root2 == null) {
			if(root1 == null) {
				root1 = root2;
			}
			return root1;
		}
		root1.val = root1.val + root2.val;
		root1.left = mergeTrees(root1.left, root2.left);
		root1.right = mergeTrees(root1.right, root2.right);
		return root1;
	}
	
	private static void levelOrder(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			System.out.print(node.val + " ");
			if(node.left != null) {
				q.add(node.left);
			}
			if(node.right != null) {
				q.add(node.right);
			}
		}
	}

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(2);
		root1.left.left = new TreeNode(5);
		
		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(3);
		root2.left.right = new TreeNode(4);
		root2.right.right = new TreeNode(7);
		
		root1 = mergeTrees(root1, root2);
		
		levelOrder(root1);
	}

}
