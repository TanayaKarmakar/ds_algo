package com.app.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.app.practice.BinaryTree.TreeNode;

public class BinaryTreeInorderTraversalLeetcode94 {
	private static List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> res = new ArrayList<>();
		
		while(!stack.isEmpty() || root != null) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			
			root = stack.pop();
			System.out.print(root.val + " ");
			res.add(root.val);
			root = root.right;
		}
		
		return res;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = null;
		bt.root.right = new TreeNode(2);
		bt.root.right.left = new TreeNode(3);
		
		List<Integer> res = inorderTraversal(bt.root);
		
		System.out.println(res);

	}

}
