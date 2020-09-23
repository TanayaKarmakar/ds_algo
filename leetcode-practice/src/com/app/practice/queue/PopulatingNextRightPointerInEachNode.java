package com.app.practice.queue;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
};

public class PopulatingNextRightPointerInEachNode {
	private static Node connect(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node == null) {
				if(q.peek() != null)
					q.add(null);
				continue;
			}
			if(q.peek() != null) {
				node.next = q.peek();
			}
			
			if(node.left != null)
				q.add(node.left);
			if(node.right != null)
				q.add(node.right);
		}
		
		return root;
	}

	public static void main(String[] args) {
		

	}

}
