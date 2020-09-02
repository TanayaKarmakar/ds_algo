package com.app.practice;



public class ConvertBinarySearchTreeToDLL {
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
	
	private static Node prev = null;
	private static Node head = null;
	
	private static void treeToDLL(Node root) {
		if(root == null)
			return;
		treeToDLL(root.left);
		if(prev == null) {
			head = root;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		treeToDLL(root.right);
	}
	
	private static Node treeToDoublyLinkedList(Node root) {
		if(root == null)
			return null;
		head = null;
		prev = null;
		treeToDLL(root);
		return head;
	}

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		
		root = treeToDoublyLinkedList(root);
		
		Node temp = root;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.right;
		}
		System.out.println();
	}

}
