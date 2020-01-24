package com.app.binarytree.practice;

import java.util.LinkedList;
import java.util.Queue;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class ChildrenSumProperty {
	private static int isSumProperty(Node root) {
		Queue<Node> nodeQ = new LinkedList<>();
		nodeQ.add(root);
		
		while(!nodeQ.isEmpty()) {
			Node node = nodeQ.remove();
			int sum = 0;
			if(node.left != null) {
				nodeQ.add(node.left);
				sum += node.left.data;
			}
			if(node.right != null) {
				nodeQ.add(node.right);
				sum += node.right.data;
			}
			
			if((node.left != null || node.right != null) && sum != node.data)
				return 0;
		}
		return 1;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(30);
		bt.root.left = new Node(10);
		bt.root.right = new Node(20);
		bt.root.left.left = new Node(3);
		bt.root.left.right = new Node(7);
		bt.root.left.left.left = new Node(1);
		bt.root.left.left.right = new Node(2);
		bt.root.left.right.left = new Node(1);
		bt.root.left.right.right = new Node(6);
		bt.root.right.left = new Node(8);
		bt.root.right.right = new Node(12);
		bt.root.right.right.left = new Node(2);
		bt.root.right.right.right = new Node(10);
		
		System.out.println(isSumProperty(bt.root));

	}

}
