package com.app.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.app.practice.BinaryTree.TreeNode;

public class BinaryTreePreorderTraversalLeetcode144 {
	private static List<Integer> preorderTraversal(TreeNode root) {
		if(root == null)
			return new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.print(node.val + " ");
			list.add(node.val);
			
			if(node.right != null)
				stack.push(node.right);
			if(node.left != null)
				stack.push(node.left);
		}
		System.out.println();
		return list;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.right = new TreeNode(2);
		bt.root.right.left = new TreeNode(3);
		
		preorderTraversal(bt.root);

	}

}
