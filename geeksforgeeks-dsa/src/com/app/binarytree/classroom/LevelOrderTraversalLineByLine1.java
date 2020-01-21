package com.app.binarytree.classroom;

import java.util.LinkedList;
import java.util.Queue;

import com.app.binarytree.classroom.BinaryTree.Node;

public class LevelOrderTraversalLineByLine1 {
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
			} else {
				System.out.print(node.data + " ");
			}

			if (node.left != null) {
				nodeQ.add(node.left);
			}
			if (node.right != null) {
				nodeQ.add(node.right);
			}
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(20);
		bt.root.right = new Node(30);
		bt.root.left.left = new Node(8);
		bt.root.left.right = new Node(7);
		bt.root.left.right.left = new Node(9);
		bt.root.left.right.right = new Node(15);
		bt.root.right.right = new Node(6);

		levelOrderTraversalLineByLine(bt.root);

	}

}
