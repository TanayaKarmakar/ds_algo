package com.app.tree;

import java.util.Stack;

import com.app.tree.BinaryTree.TreeNode;

public class KThNodeInInorderTraversal {
	private static TreeNode kThNode(TreeNode root, int k) {
		if(root == null)
			return null;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		while(curr != null || !stack.isEmpty()) {
			while(curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			
			curr = stack.pop();
			k--;
			if(k == 0)
				return curr;
			curr = curr.right;
		}
		return null;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(1);
		bt.root.right = new TreeNode(4);
		bt.root.left.right = new TreeNode(2);
		
		TreeNode ans = kThNode(bt.root, 1);
		
		System.out.println(ans.val);

	}

}
