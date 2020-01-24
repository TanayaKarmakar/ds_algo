package com.app.binarytree.practice;

import java.util.LinkedList;
import java.util.Queue;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class LevelOrderTraversal {
	private static void levelOrderTraversal(Node root) {
		Queue<Node> nodeQ = new LinkedList<>();
		nodeQ.add(root);
		
		while(!nodeQ.isEmpty()) {
			Node node = nodeQ.poll();
			
			System.out.print(node.data + " ");
			
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
		
		levelOrderTraversal(bt.root);

	}

}
