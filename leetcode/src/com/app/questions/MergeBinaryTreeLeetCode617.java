package com.app.questions;

import com.app.questions.BinaryTree.Node;

public class MergeBinaryTreeLeetCode617 {
	private static Node merge(Node root1, Node root2) {
		if(root1 == null && root2 == null)
			return null;
		if(root1 == null || root2 == null) {
			if(root1 == null) {
				return root2;
			}
			else if(root2 == null)
				return root1;
		}
		root1.data = root1.data + root2.data;
		root1.left = merge(root1.left, root2.left);
		root1.right = merge(root1.right, root2.right);
		return root1;
	}
	
	private static void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		BinaryTree bt1 = new BinaryTree();
		bt1.root = new Node(1);
		bt1.root.left = new Node(3);
		bt1.root.right = new Node(2);
		bt1.root.left.left = new Node(5);
		
		BinaryTree bt2 = new BinaryTree();
		bt2.root = new Node(2);
		bt2.root.left = new Node(1);
		bt2.root.right = new Node(3);
		bt2.root.left.right = new Node(4);
		bt2.root.right.right = new Node(7);
		
		bt1.root = merge(bt1.root, bt2.root);
		
		inorder(bt1.root);
	}

}
