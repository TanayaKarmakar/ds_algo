package com.app.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class BinaryTreePreorderTraversalLeetcode144 {
	private static List<Integer> preorderTraversal(TreeNode root) {
		if(root == null)
			return new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		stack.push(root);
		List<Integer> res = new ArrayList<>();
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			
			res.add(node.val);
			
			if(node.right != null)
				stack.push(node.right);
			if(node.left != null)
				stack.push(node.left);
		}
		
		return res;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.right = new TreeNode(2);
		bt.root.right.left = new TreeNode(3);
		
		List<Integer> res = preorderTraversal(bt.root);
		
		System.out.println(res);

	}

}
