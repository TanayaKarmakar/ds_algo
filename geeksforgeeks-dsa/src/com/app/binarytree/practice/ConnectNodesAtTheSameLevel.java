package com.app.binarytree.practice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import com.app.binarytree.practice.BinaryTree1.Node1;

class BinaryTree1 {
	Node1 root;

	static class Node1 {
		int data;
		Node1 left;
		Node1 right;
		Node1 nextRight;

		public Node1(int data) {
			this.data = data;
			this.left = null;
			this.nextRight = null;
			this.nextRight = null;
		}
	}
}

public class ConnectNodesAtTheSameLevel {
	private static void connectNodes(Node1 root) {
		Queue<Node1> nodeQ = new LinkedList<>();
		nodeQ.add(root);
		nodeQ.add(null);

		while (nodeQ.size() > 1) {
			Node1 node = nodeQ.poll();
			if (node == null) {
				Iterator<Node1> qItr = nodeQ.iterator();
				Node1 prev = null;
				Node1 curr = null;
				while (qItr.hasNext()) {
					prev = curr;
					curr = qItr.next();
					if (prev != null) {
						prev.nextRight = curr;
					}
				}
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
	}

	private static void levelOrderTraversalLineByLine(Node1 root) {
		Queue<Node1> nodeQ = new LinkedList<>();
		nodeQ.add(root);
		nodeQ.add(null);

		System.out.print(root.data);
		System.out.println();
		while (nodeQ.size() > 1) {
			Node1 node = nodeQ.poll();
			if (node == null) {
				Node1 curr = nodeQ.peek();
				while (curr != null) {
					System.out.print(curr.data + " ");
					curr = curr.nextRight;
				}
				System.out.println();
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
	}

	public static void main(String[] args) {
		BinaryTree1 bt = new BinaryTree1();
		bt.root = new Node1(10);
		bt.root.left = new Node1(3);
		bt.root.right = new Node1(5);
		bt.root.left.left = new Node1(4);
		bt.root.left.right = new Node1(1);
		bt.root.right.right = new Node1(2);
		
		connectNodes(bt.root);
		
		levelOrderTraversalLineByLine(bt.root);	
	}

}
