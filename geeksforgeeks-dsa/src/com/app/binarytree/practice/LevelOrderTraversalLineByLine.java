package com.app.binarytree.practice;

import java.util.LinkedList;
import java.util.Queue;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class LevelOrderTraversalLineByLine {
	private static void levelOrderTraversalLineByLine(Node root) {
		Queue<Node> nodeQ = new LinkedList<>();
		
		nodeQ.add(root);
		nodeQ.add(null);
		
		while(nodeQ.size() > 1) {
			Node node = nodeQ.poll();
			
			if(node == null) {
				nodeQ.add(null);
				System.out.print("$ ");
				continue;
			} else {
				System.out.print(node.data + " ");
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
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(7);
		bt.root.left.right.right = new Node(8);
		
		levelOrderTraversalLineByLine(bt.root);

	}

}
