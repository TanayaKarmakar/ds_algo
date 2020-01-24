package com.app.binarytree.practice;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class IdenticalTree {
	private static boolean isIdentical(Node root1, Node root2) {
		if(root1 == null && root2 == null)
			return true;
		else if((root1 == null && root2 != null) || (root1 != null && root2 == null))
			return false;
		else
			return root1.data == root2.data && isIdentical(root1.left, root2.left)
				&& isIdentical(root1.right, root2.right);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		
		BinaryTree bt1 = new BinaryTree();
		bt1.root = new Node(1);
		bt1.root.left = new Node(2);
		bt1.root.right = new Node(3);
		bt1.root.left.left = new Node(4);
		bt1.root.left.right = new Node(5);
		
		System.out.println("Is Identical - " + isIdentical(bt.root, bt1.root));
		
		
		bt1 = new BinaryTree();
		bt1.root = new Node(1);
		bt1.root.left = new Node(2);
		bt1.root.right = new Node(3);
		bt1.root.left.left = new Node(4);
		bt1.root.left.right = new Node(6);
		
		System.out.println("Is Identical - " + isIdentical(bt.root, bt1.root));
	}

}
