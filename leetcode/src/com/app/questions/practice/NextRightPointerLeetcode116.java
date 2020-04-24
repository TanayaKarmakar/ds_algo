package com.app.questions.practice;

import java.util.Queue;
import java.util.LinkedList;

class Node {
	public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class NextRightPointerLeetcode116 {
	private static Node connect(Node root) {
		if(root == null)
			return root;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(q.size() > 1) {
			Node node = q.poll();
			
			if(node == null) {
				q.add(null);
				continue;
			}
			
			if(q.peek() != null) {
				node.next = q.peek();
			}
			
			if(node.left != null) {
				q.add(node.left);
			}
			
			if(node.right != null) {
				q.add(node.right);
			}
		}
		return root;
	}
	
	private static void display(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
	
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			System.out.println("Current Node - " + node.val);
			System.out.println("Next Node - " + (node.next == null ? "null": node.next.val));
			if(node.left != null) {
				q.add(node.left);
			}
			
			if(node.right != null) {
				q.add(node.right);
			}
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		root = connect(root);
		
		
		display(root);

	}

}
