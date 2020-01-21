package com.app.binarytree.classroom;

import java.util.LinkedList;
import java.util.Queue;

import com.app.binarytree.classroom.BinaryTree.Node;

public class LevelOrderTraversalLineByLine2 {
	private static void levelOrderTraversal(Node root) {
		Queue<Node> nodeQ = new LinkedList<>();
		nodeQ.add(root);
		
		while(!nodeQ.isEmpty()) {
			int count = nodeQ.size();
			
			for(int i = 0;i<count;i++) {
				Node node = nodeQ.poll();
				
				System.out.print(node.data + " ");
				if(node.left != null) {
					nodeQ.add(node.left);
				}
				
				if(node.right != null) {
					nodeQ.add(node.right);
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(20);
		bt.root.right = new Node(30);
		bt.root.left.left = new Node(40);
		bt.root.left.right = new Node(50);
		bt.root.right.right = new Node(60);
		bt.root.left.right.left = new Node(70);
		bt.root.left.right.right = new Node(80);
		
		levelOrderTraversal(bt.root);

	}

}
