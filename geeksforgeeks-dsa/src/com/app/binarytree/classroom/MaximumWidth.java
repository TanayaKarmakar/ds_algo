package com.app.binarytree.classroom;

import java.util.LinkedList;
import java.util.Queue;

import com.app.binarytree.classroom.BinaryTree.Node;

public class MaximumWidth {
	private static int maximumWidth(Node root) {
		if(root == null)
			return 0;
		int maxCount = Integer.MIN_VALUE;
		Queue<Node> nodeQ = new LinkedList<>();

		nodeQ.add(root);
		nodeQ.add(null);

		while (nodeQ.size() > 1) {
			Node node = nodeQ.remove();
			if (node == null) {
				int qSize = nodeQ.size();
				maxCount = Integer.max(maxCount, qSize);
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
		
		return maxCount;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(3);
		bt.root.left = new Node(4);
		bt.root.right = new Node(8);
		bt.root.left.left = new Node(5);
		bt.root.left.right = new Node(9);
		bt.root.right.right = new Node(7);
		bt.root.right.right.left = new Node(6);
		
		System.out.println("Maximum width - " + maximumWidth(bt.root));
	}

}
