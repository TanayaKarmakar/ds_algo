package com.app.binarytree.practice;

import java.util.LinkedList;
import java.util.Queue;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class MirrorTree {
	private static Node convertMirrorTree(Node root) {
		Queue<Node> nodeQ = new LinkedList<>();
		nodeQ.add(root);
		
		while(!nodeQ.isEmpty()) {
			Node node = nodeQ.poll();
			
			Node temp1 = node.left;
			Node temp2 = node.right;
			node.left = temp2;
			node.right = temp1;
			
			if(node.left != null) {
				nodeQ.add(node.left);
			}
			
			if(node.right != null) {
				nodeQ.add(node.right);
			}
		}
		return root;
	}
	
	private static void levelOrderTraversalLineByLine(Node root) {
		Queue<Node> nodeQ = new LinkedList<>();
		nodeQ.add(root);
		nodeQ.add(null);

		while (nodeQ.size() > 1) {
			Node node = nodeQ.poll();
			if (node == null) {
				System.out.println();
				nodeQ.add(null);
				continue;
			}
			System.out.print(node.data + " ");
			if (node.left != null) {
				nodeQ.add(node.left);
			}

			if (node.right != null) {
				nodeQ.add(node.right);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(3);
		bt.root.right = new Node(2);
		bt.root.right.left = new Node(5);
		bt.root.right.right = new Node(4);
		
		bt.root = convertMirrorTree(bt.root);
		
		levelOrderTraversalLineByLine(bt.root);

	}

}
