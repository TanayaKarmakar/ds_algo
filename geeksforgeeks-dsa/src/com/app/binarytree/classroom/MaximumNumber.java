package com.app.binarytree.classroom;

import java.util.LinkedList;
import java.util.Queue;

import com.app.binarytree.classroom.BinaryTree.Node;

public class MaximumNumber {
	private static int getMaxIterative(Node root) {
		if(root == null)
			return Integer.MIN_VALUE;
		int maxRes = Integer.MIN_VALUE;
		Queue<Node> nodeQ = new LinkedList<>();
		nodeQ.add(root);
		
		while(!nodeQ.isEmpty()) {
			Node node = nodeQ.remove();
			maxRes = Integer.max(node.data, maxRes);
			
			if(node.left != null) {
				nodeQ.add(node.left);
			}
			
			if(node.right != null) {
				nodeQ.add(node.right);
			}
		}
		
		return maxRes;
		
	}
	
	private static int getMax(Node root) {
		if(root == null)
			return Integer.MIN_VALUE;
		else {
			return Integer.max(root.data, 
					Integer.max(getMax(root.left), getMax(root.right)));
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(20);
		bt.root.right = new Node(60);
		bt.root.left.left = new Node(40);
		bt.root.left.right = new Node(50);
		
		System.out.println("Max element - " + getMax(bt.root));
		
		System.out.println("Max element iterative - " + getMaxIterative(bt.root));

	}

}
