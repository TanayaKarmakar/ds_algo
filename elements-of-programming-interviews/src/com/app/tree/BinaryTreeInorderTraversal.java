package com.app.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.app.tree.BinaryTree.TreeNode;

public class BinaryTreeInorderTraversal {
	private static List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		List<Integer> res = new ArrayList<>();
		
		while(curr != null || !stack.isEmpty()) {
			while(curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			
			curr = stack.pop();
			System.out.print(curr.val + " ");
			res.add(curr.val);
			curr = curr.right;
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
