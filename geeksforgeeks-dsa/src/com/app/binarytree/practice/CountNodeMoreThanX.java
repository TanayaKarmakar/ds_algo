package com.app.binarytree.practice;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class CountNodeMoreThanX {
	private static int count = 0;
	
	private static void countNode(Node root, int x) {
		if(root == null)
			return;
		if(root.data > x)
			count++;
		countNode(root.left, x);
		countNode(root.right, x);
	}
	
	private static int countNodeWrapper(Node root, int x) {
		count = 0;
		countNode(root, x);
		return count;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(8);
		bt.root.left = new Node(3);
		bt.root.right = new Node(10);
		bt.root.left.left = new Node(1);
		bt.root.left.right = new Node(6);
		bt.root.left.right.left = new Node(17);
		bt.root.right.left = new Node(14);
		bt.root.right.left.right = new Node(18);

		int count = countNodeWrapper(bt.root, 10);
		System.out.println("Count - " + count);
		
		
		count = countNodeWrapper(bt.root, 100);
		
		System.out.println("Count - " + count);
	}

}
