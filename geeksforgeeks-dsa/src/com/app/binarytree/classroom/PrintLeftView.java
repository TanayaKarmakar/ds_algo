package com.app.binarytree.classroom;

import java.util.LinkedList;
import java.util.Queue;

import com.app.binarytree.classroom.BinaryTree.Node;

public class PrintLeftView {
	private static int maxLevel = 0;
	
	private static void printLeftViewRecursive(Node root, int level) {
		if(root == null)
			return;
		if(maxLevel < level) {
			System.out.print(root.data + " ");
			maxLevel = level;
		}
		printLeftViewRecursive(root.left, level + 1);
		printLeftViewRecursive(root.right, level + 1);
	}
	
	private static void printLeftView(Node root) {
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
			if(node.left != null) {
				nodeQ.add(node.left);
			}
			
			if(node.right != null) {
				nodeQ.add(node.right);
			}
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(50);
		bt.root.right = new Node(60);
		bt.root.right.left = new Node(70);
		bt.root.right.right = new Node(20);
		bt.root.right.left.right = new Node(8);
		
		System.out.println("Left View Iterative");
		printLeftView(bt.root);
		System.out.println();
		
		System.out.println("Left View Recursive");
		printLeftViewRecursive(bt.root, 1);
		System.out.println();
		
		System.out.println();
		bt = new BinaryTree();
		bt.root = new Node(30);
		bt.root.right = new Node(50);
		bt.root.right.left = new Node(60);
		bt.root.right.left.right = new Node(10);
		
		System.out.println("Left View Iterative");
		printLeftView(bt.root);
		System.out.println();
		
		System.out.println("Left View Recursive");
		maxLevel = 0;
		printLeftViewRecursive(bt.root, 1);
		System.out.println();
	}

}
