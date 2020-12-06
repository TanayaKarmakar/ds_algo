package com.app.tree;

import java.util.Stack;

import com.app.tree.BinaryTree.TreeNode;

public class InorderSuccessorOfBinaryTree {
	private static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode curr = p;
		if (curr.right != null) {
			curr = curr.right;
			while (curr.left != null) {
				curr = curr.left;
			}
			return curr;
		}

		// if the right subtree is empty
		Stack<TreeNode> stack = new Stack<>();
		boolean isFound = false;
		curr = root;
		while (!stack.isEmpty() || curr != null) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			
			curr = stack.pop();
			if(isFound) {
				return curr;
			}
			if(p == curr)
				isFound = true;
			curr = curr.right;	
		}
		
		return null;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(5);
		bt.root.left = new TreeNode(3);
		bt.root.right = new TreeNode(6);
		bt.root.left.left = new TreeNode(2);
		bt.root.left.right = new TreeNode(4);
		bt.root.left.left.left = new TreeNode(1);
		
		TreeNode ans = inorderSuccessor(bt.root, bt.root.right);
		
		System.out.println(ans == null ? null : ans.val);

	}

}
