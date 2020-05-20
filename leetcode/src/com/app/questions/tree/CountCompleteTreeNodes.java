package com.app.questions.tree;

import java.util.Queue;
import java.util.LinkedList;

import com.app.questions.tree.BinaryTree.Node;

public class CountCompleteTreeNodes {
	private static int countNodes(Node root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		return countNodes(root.left) + countNodes(root.right) + 1;
	}
	
	private static int count(Node root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		int count = 0;
		while(!q.isEmpty()) {
			Node node = q.poll();
			count++;
			
			if(node.left != null)
				q.add(node.left);
			if(node.right != null)
				q.add(node.right);
		}
		
		return count;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.right.left = new Node(6);
		
		System.out.println("Count Iterative - " + count(bt.root));
		
		System.out.println("Count Recursive - " + countNodes(bt.root));

	}

}
