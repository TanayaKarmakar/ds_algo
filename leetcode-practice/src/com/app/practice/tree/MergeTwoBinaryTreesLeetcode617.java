package com.app.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;


public class MergeTwoBinaryTreesLeetcode617 {
	private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null)
			return null;
		if(root1 == null || root2 == null) {
			if(root1 == null)
				return root2;
			if(root2 == null)
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
			if(node.left != null)
				q.add(node.left);
			if(node.right != null)
				q.add(node.right);
		}	
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
