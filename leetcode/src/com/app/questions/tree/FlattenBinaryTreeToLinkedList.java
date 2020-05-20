package com.app.questions.tree;

import com.app.questions.tree.BinaryTree.Node;

//TBD
public class FlattenBinaryTreeToLinkedList {	
	private static void flatten(Node root) {
		if(root == null)
			return;
		
		Node left = root.left;
		Node right = root.right;
		root.left = null;
		flatten(left);
		flatten(right);
		
//		System.out.println("Root - " + root.data + ","
//				+ " Left - " + ( left == null ? null : left.data ) + ", "
//						+ "Right - " + (right == null ? null : right.data ));
		
		root.right = left;
		
		Node curr = root;
		while(curr.right != null) {
			curr = curr.right;
		}
		curr.right = right;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.left.left = new Node(3);
		bt.root.left.right = new Node(4);
		bt.root.right = new Node(5);
		bt.root.right.right = new Node(6);
		
		flatten(bt.root);
		//bt.root.left = null;
		
		Node curr = bt.root;
		while(curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.right;
		}

		System.out.println();
	}

}
