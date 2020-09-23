package com.app.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class BinaryTreeInorderTraversalLeetcode94 {
	private static List<Integer> inorderTraversal(TreeNode root) {
		if(root == null)
			return new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		List<Integer> result = new ArrayList<>();
		
		while(root != null || !stack.isEmpty()) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			
			root = stack.pop();
			result.add(root.val);
			root = root.right;
		}
		
		return result;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.right = new TreeNode(2);
		bt.root.right.left = new TreeNode(3);
		
		List<Integer> result = inorderTraversal(bt.root);
		
		System.out.println(result);

	}

}
