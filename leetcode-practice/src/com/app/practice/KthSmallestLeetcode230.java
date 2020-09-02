package com.app.practice;

import java.util.Stack;

import com.app.practice.BinaryTree.TreeNode;

public class KthSmallestLeetcode230 {
	public static int kthSmallest(TreeNode root, int k) {
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
				return curr.val;
			curr = curr.right;	
		}
		return -1;
    }

	public static void main(String[] args) {
		/*TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		
		System.out.println(kthSmallest(root, 1));*/
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);
		
		System.out.println(kthSmallest(root, 3));

	}

}
