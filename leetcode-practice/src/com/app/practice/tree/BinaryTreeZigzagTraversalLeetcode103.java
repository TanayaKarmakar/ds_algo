package com.app.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class BinaryTreeZigzagTraversalLeetcode103 {
	private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if(root == null)
			return new ArrayList<>();
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		
		List<List<Integer>> res = new ArrayList<>();
		stack1.push(root);
		
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			List<Integer> item = new ArrayList<>();
			
			while(!stack1.isEmpty()) {
				TreeNode node = stack1.pop();
				item.add(node.val);
				
				if(node.left != null)
					stack2.push(node.left);
				
				if(node.right != null)
					stack2.push(node.right);
			}
			
			if(!item.isEmpty())
				res.add(item);
			
			item = new ArrayList<>();
			while(!stack2.isEmpty()) {
				TreeNode node = stack2.pop();
				item.add(node.val);
				
				if(node.right != null)
					stack1.push(node.right);
				
				if(node.left != null)
					stack1.push(node.left);
			}
			
			if(!item.isEmpty())
				res.add(item);
		}
		
		return res;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(9);
		bt.root.right = new TreeNode(20);
		bt.root.right.left = new TreeNode(15);
		bt.root.right.right = new TreeNode(7);
		
		List<List<Integer>> res = zigzagLevelOrder(bt.root);
		
		System.out.println(res);
	}

}
