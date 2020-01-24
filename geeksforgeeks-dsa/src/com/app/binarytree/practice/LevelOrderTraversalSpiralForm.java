package com.app.binarytree.practice;

import java.util.Stack;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class LevelOrderTraversalSpiralForm {
	private static void levelOrderTraversalSpiralForm(Node root) {
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		
		stack1.push(root);
		
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				Node node = stack1.pop();
				
				System.out.print(node.data + " ");
				
				if(node.right != null) {
					stack2.push(node.right);
				}
				
				if(node.left != null) {
					stack2.push(node.left);
				}
			}
			
			while(!stack2.isEmpty()) {
				Node node = stack2.pop();
				
				System.out.print(node.data + " ");
				
				if(node.left != null) {
					stack1.push(node.left);
				}
				
				if(node.right != null) {
					stack1.push(node.right);
				}
			}
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(7);
		bt.root.left.right = new Node(6);
		bt.root.right.left = new Node(5);
		bt.root.right.right = new Node(4);
		
		levelOrderTraversalSpiralForm(bt.root);

	}

}
