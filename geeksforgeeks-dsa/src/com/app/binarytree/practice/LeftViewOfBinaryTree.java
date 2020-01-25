package com.app.binarytree.practice;

import java.util.LinkedList;
import java.util.Queue;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class LeftViewOfBinaryTree {
	private static void printLeftView(Node root) {
		if(root == null)
			return;
		Queue<Node> nodeQ = new LinkedList<>();
		nodeQ.add(root);
		nodeQ.add(null);
		
		System.out.print(root.data + " ");
		while(nodeQ.size() > 1) {
			Node node = nodeQ.poll();
			
			if(node == null) {
				System.out.print(nodeQ.peek().data + " ");
				nodeQ.add(null);
				continue;
			}
			if(node.left != null)
				nodeQ.add(node.left);
			
			if(node.right != null)
				nodeQ.add(node.right);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(7);
		bt.root.left.left.right = new Node(8);
		
		printLeftView(bt.root);

	}

}
