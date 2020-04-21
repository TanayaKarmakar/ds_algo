package com.app.questions.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.app.questions.practice.BinaryTree.TreeNode;

public class InorderTraversalLeetcode94 {
	private static List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> res = new ArrayList<>();
		
		while(root != null || !stack.isEmpty()) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			res.add(root.data);
			root = root.right;
		}
		
		return res;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.right = new TreeNode(2);
		bt.root.right.left = new TreeNode(3);
		
		List<Integer> res = inorderTraversal(bt.root);
		
		System.out.println(res);
	}

}
