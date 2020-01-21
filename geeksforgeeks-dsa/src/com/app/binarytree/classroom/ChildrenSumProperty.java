package com.app.binarytree.classroom;

import java.util.LinkedList;
import java.util.Queue;

import com.app.binarytree.classroom.BinaryTree.Node;

public class ChildrenSumProperty {
	private static boolean isChildrenSumRecursive(Node root) {
		if(root == null || (root.left == null && root.right == null))
			return true;
		int sum = 0;
		if(root.left != null) {
			sum += root.left.data;
		}
		if(root.right != null) {
			sum += root.right.data;
		}
		
		return sum == root.data && isChildrenSumRecursive(root.left)
				&& isChildrenSumRecursive(root.right);
	}
	
	private static boolean isChildrenSumProperty(Node root) {
		if(root == null || (root.left == null && root.right == null))
			return true;
		
		Queue<Node> nodeQ = new LinkedList<>();
		nodeQ.add(root);
		
		while(!nodeQ.isEmpty()) {
			Node node = nodeQ.remove();
			
			int sum = 0;
			if(node.left != null) {
				sum += node.left.data;
				nodeQ.add(node.left);
			}
			
			if(node.right != null) {
				sum += node.right.data;
				nodeQ.add(node.right);
			}
			
			if((node.left != null && node.right != null) && sum != node.data) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(20);
		bt.root.left = new Node(8);
		bt.root.right = new Node(12);
		bt.root.left.left = new Node(3);
		bt.root.left.right = new Node(5);
		
		System.out.println("Children sum property - " + isChildrenSumProperty(bt.root));
		
		System.out.println("Children sum property recursive - " + isChildrenSumRecursive(bt.root));
		
		bt = new BinaryTree();
		bt.root = new Node(3);
		bt.root.left = new Node(1);
		bt.root.right = new Node(2);
		bt.root.right.left = new Node(1);
		bt.root.right.right = new Node(2);
		
		System.out.println("Children sum property - " + isChildrenSumProperty(bt.root));
		
		System.out.println("Children sum property recursive - " + isChildrenSumRecursive(bt.root));

	}

}
