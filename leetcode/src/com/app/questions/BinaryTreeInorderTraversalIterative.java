package com.app.questions;

import java.util.Stack;

import com.app.questions.BinaryTree.Node;

public class BinaryTreeInorderTraversalIterative {
	private static void inorderIterative(Node root) {
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		root = root.left;
		
		while(!stack.isEmpty() || root != null) {
			if(root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				System.out.print(root.data + " ");
				root = root.right;
			}
		}
		
		System.out.println();
		
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		
		inorderIterative(bt.root);

	}

}
