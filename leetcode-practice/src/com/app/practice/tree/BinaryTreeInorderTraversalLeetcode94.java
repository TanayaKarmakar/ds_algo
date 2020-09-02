package com.app.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class BinaryTreeInorderTraversalLeetcode94 {
	private static List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		
		//stack.push(root);
		while(root != null || !stack.isEmpty()) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			
			root = stack.pop();
			list.add(root.val);
			root = root.right;
		}
		
		return list;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.left.left = new TreeNode(4);
		bt.root.right = new TreeNode(3);
		bt.root.right.left = new TreeNode(5);
		bt.root.right.left.left = new TreeNode(7);
		bt.root.right.right = new TreeNode(6);
		bt.root.right.right.right = new TreeNode(8);
		
		List<Integer> res = inorderTraversal(bt.root);
		
		System.out.println(res);
		

	}

}
