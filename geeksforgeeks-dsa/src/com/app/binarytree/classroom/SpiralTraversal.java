package com.app.binarytree.classroom;

import java.util.Stack;

import com.app.binarytree.classroom.BinaryTree.Node;

public class SpiralTraversal {
	private static void spiralTraversal(Node root) {
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.push(root);
		
		
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				Node node = stack1.pop();
				
				System.out.print(node.data + " ");
				
				if(node.left != null) {
					stack2.push(node.left);
				}
				
				if(node.right != null) {
					stack2.push(node.right);
				}
			}
			
			while(!stack2.isEmpty()) {
				Node node = stack2.pop();
				
				System.out.print(node.data + " ");
				
				if(node.right != null) {
					stack1.push(node.right);
				}
				
				if(node.left != null) {
					stack1.push(node.left);
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.left.left.left = new Node(8);
		bt.root.left.left.right = new Node(9);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(7);
		bt.root.right.left.left = new Node(10);
		
		spiralTraversal(bt.root);

	}

}
