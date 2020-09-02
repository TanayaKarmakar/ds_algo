package com.app.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class InvertBinaryTreeLeetcode226 {
	private static TreeNode invertTree1(TreeNode root) {
		if(root == null)
			return null;
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		root.left = invertTree1(root.left);
		root.right = invertTree1(root.right);
		return root;
	}
	
	private static TreeNode invertTree(TreeNode root) {
		if(root == null)
			return null;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
					
			TreeNode tmp = curr.left;
			curr.left = curr.right;
			curr.right = tmp;
			
			if(curr.left != null)
				q.add(curr.left);
			if(curr.right != null)
				q.add(curr.right);
		}
		
		return root;
	}
	
	private static void levelOrder(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			
			System.out.print(curr.val + " ");
			
			if(curr.left != null)
				q.add(curr.left);
			if(curr.right != null)
				q.add(curr.right);
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(4);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(7);
		bt.root.left.left = new TreeNode(1);
		bt.root.left.right = new TreeNode(3);
		bt.root.right.left = new TreeNode(6);
		bt.root.right.right = new TreeNode(9);
		
		bt.root = invertTree(bt.root);
		
		levelOrder(bt.root);
		
		bt = new BinaryTree();
		bt.root = new TreeNode(4);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(7);
		bt.root.left.left = new TreeNode(1);
		bt.root.left.right = new TreeNode(3);
		bt.root.right.left = new TreeNode(6);
		bt.root.right.right = new TreeNode(9);
		
		bt.root = invertTree1(bt.root);
		
		levelOrder(bt.root);

	}

}
