package com.app.practice.tree;

class Node {
	public int val;
	public Node left;
	public Node right;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right) {
		val = _val;
		left = _left;
		right = _right;
	}
};

public class ConvertBinarySearchTreeToSortedDLLLeetcode426 {
	private static Node prev = null;
	private static Node head = null;

	private static void convertRec(Node root) {
		if (root == null)
			return;
		convertRec(root.left);

		if (prev == null) {
			head = root;
		} else {
			root.left = prev;
			prev.right = root;
		}

		prev = root;

		convertRec(root.right);
	}

	private static Node treeToDoublyList(Node root) {
		if (root == null)
			return null;
		
		prev = null;
		head = null;
		convertRec(root);
		
		Node temp = head;
		while(temp.right != null) {
			temp = temp.right;
		}
		
		temp.right = head;
		head.left = temp;
		
		return head;
		
	}

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		
		Node head = treeToDoublyList(root);
		
		Node temp = head;
		
		while(temp.right!= head) {
			System.out.print(temp.val + " ");
			temp = temp.right;
		}

		System.out.print(temp.val);
		
		System.out.println();
	}

}
