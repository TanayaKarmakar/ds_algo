package com.app.problems;

import java.util.LinkedList;
import java.util.Queue;

import com.app.problems.BinaryTree.Node;

public class SerializeDeserializeTree {
	private static final String SPACE = " ";
	private static int index = 0;
	
	//serialize the tree with pre order traversal
	private static void serializeTree(Node root, StringBuilder sb) {		
		if(root == null) {
			sb.append("-1");
			sb.append(SPACE);
			return;
		} else {
			sb.append(root.data + SPACE);
			serializeTree(root.left, sb);
			serializeTree(root.right, sb);
		}
			
	}

	//deserialize the tree from array
	private static Node deserializeTree(String[] arr) {
		if(index == arr.length - 1 || Integer.parseInt(arr[index]) == -1) {
			index++;
			return null;
		}
		Node root = new Node(Integer.parseInt(arr[index]));
		index++;
		root.left = deserializeTree(arr);
		root.right = deserializeTree(arr);
		return root;
	}

	private static void levelOrderTraversal(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {
			Node currentNode = queue.poll();
			if (currentNode == null) {
				System.out.println();
				if (queue.peek() != null) {
					queue.add(null);
				}
			} else {
				System.out.print(currentNode.data + "\t");
				if (currentNode.left != null) {
					queue.add(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.add(currentNode.right);
				}
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
		//bt.root.right.right = new Node(7);
		StringBuilder sb = new StringBuilder();
		serializeTree(bt.root, sb);
		
		System.out.println(sb.toString());
		
		
		String[] arr = sb.toString().split("\\s+");
		BinaryTree bt1 = new BinaryTree();
		bt1.root = deserializeTree(arr);
		
		levelOrderTraversal(bt1.root);

	}

}
