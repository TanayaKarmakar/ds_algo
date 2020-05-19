package com.app.questions.tree;

import com.app.questions.tree.BinaryTree.Node;

public class DeleteLeavesWithGivenValue {	
	private static boolean cleanNodes(Node root, int x) {
		if(root == null)
			return false;
		
		boolean left = cleanNodes(root.left, x);
		boolean right = cleanNodes(root.right, x);
		if(left) {
			root.left = null;
		}
		if(right) {
			root.right = null;
		}
		
		if(root.data == x && root.left == null && root.right == null)
			return true;
		return false;
	}
	
	private static Node removeLeafs(Node root, int x) {
		if(cleanNodes(root, x))
			return null;
		return root;
	}
	
	private static void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(2);
		bt.root.right.left = new Node(2);
		bt.root.right.right = new Node(4);
		
		bt.root = removeLeafs(bt.root, 2);
		
		System.out.println("TestCase 1 = ");
		inorder(bt.root);
		
		System.out.println();
		
		bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.left.left = new Node(2);
		bt.root.left.left.left = new Node(2);
		
		bt.root = removeLeafs(bt.root, 2);
		System.out.println("TestCase 2 = ");
		inorder(bt.root);
		
		
		System.out.println();
		bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(1);
		bt.root.right = new Node(1);
		
		bt.root = removeLeafs(bt.root, 1);
		System.out.println("TestCase 3 = ");
		inorder(bt.root);

	}

}
