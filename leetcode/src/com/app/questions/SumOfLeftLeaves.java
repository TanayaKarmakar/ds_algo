package com.app.questions;

import java.util.Queue;
import java.util.LinkedList;

import com.app.questions.BinaryTree.Node;

//TBD
public class SumOfLeftLeaves {
	private static boolean isLeaf(Node root) {
		return root.left == null && root.right == null;
	}
	
	private static int sum(Node root) {
		if(root == null)
			return 0;
		if(isLeaf(root))
			return root.data;
		int sum = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node.left != null) {
				if(isLeaf(node.left)) {
					sum += node.left.data;
				} else {
					q.add(node.left);
				}
			}
			if(node.right != null) {
				q.add(node.right);
			}
		}
		
		return sum;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(3);
		bt.root.left = new Node(9);
		bt.root.right = new Node(20);
		bt.root.right.left = new Node(15);
		bt.root.right.right = new Node(7);
		
		System.out.println("Sum - " + sum(bt.root));

		bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(7);
		bt.root.right.right.left = new Node(8);
		
		System.out.println("Sum - " + sum(bt.root));
	}

}
