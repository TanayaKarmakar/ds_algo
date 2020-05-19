package com.app.questions.tree;

public class BinarySearchTreeToDLLLeetcode426 {
	static class Node {
	    public int val;
	    public Node left;
	    public Node right;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val,Node _left,Node _right) {
	        val = _val;
	        left = _left;
	        right = _right;
	    }
	};
	
	static Node prev;
	static Node head;
	
	private static void convertRec(Node root) {
		if(root == null)
			return;
		convertRec(root.left);
		if(prev == null) {
			head = root;
		} else {
			prev.right = root;
			root.left = prev;
		}
		prev = root;
		convertRec(root.right);
	}
	
	private static Node treeToDoublyLinkedList(Node root) {
		if(root == null)
			return null;
		head = null;
		prev = null;
		convertRec(root);
		head.left = prev;
		prev.right = head;
		return head;
	}

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		
		Node head = treeToDoublyLinkedList(root);
		
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.right;
		}

	}

}
