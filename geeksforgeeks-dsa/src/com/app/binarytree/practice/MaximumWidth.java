package com.app.binarytree.practice;

import java.util.LinkedList;
import java.util.Queue;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class MaximumWidth {
	private static int getMaxWidth(Node root) {
		Queue<Node> nodeQ = new LinkedList<>();
		nodeQ.add(root);
		nodeQ.add(null);

		int maxWidth = 0;

		while (nodeQ.size() > 1) {
			Node node = nodeQ.poll();

			if (node == null) {
				int size = nodeQ.size();
				maxWidth = Integer.max(maxWidth, size);
				nodeQ.add(null);
				continue;
			}

			if (node.left != null) {
				nodeQ.add(node.left);
			}

			if (node.right != null) {
				nodeQ.add(node.right);
			}
		}
		return maxWidth;
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
		
		
		System.out.println("MaxWidth - " + getMaxWidth(bt.root));

	}

}
