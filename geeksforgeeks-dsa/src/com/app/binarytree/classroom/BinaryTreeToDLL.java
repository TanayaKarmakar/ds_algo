package com.app.binarytree.classroom;

import com.app.binarytree.classroom.BinaryTree.Node;

public class BinaryTreeToDLL {
	static Node prev = null;
	private static Node binaryTreeToDLL(Node root) {
		if(root == null)
			return root;
		Node head = binaryTreeToDLL(root.left);
		if(prev == null) {
			head = root;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		binaryTreeToDLL(root.right);
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(5);
		bt.root.right = new Node(20);
		bt.root.right.left = new Node(30);
		bt.root.right.right = new Node(40);
		
		Node head = binaryTreeToDLL(bt.root);
		
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.right;
		}
	}

}
