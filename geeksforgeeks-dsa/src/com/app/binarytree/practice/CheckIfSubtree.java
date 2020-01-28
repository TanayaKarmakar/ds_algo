package com.app.binarytree.practice;

import java.util.LinkedList;
import java.util.Queue;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class CheckIfSubtree {
	private static boolean areEqual(Node root1, Node root2) {
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		return root1.data == root2.data && areEqual(root1.left, root2.left)
				&& areEqual(root1.right, root2.right);
	}
	private static boolean isSubtree(Node treeRoot, Node subtreeRoot) {
		Queue<Node> nodeQ = new LinkedList<>();
		nodeQ.add(treeRoot);
		
		while(!nodeQ.isEmpty()) {
			Node node = nodeQ.poll();
			
			if(node.data == subtreeRoot.data) {
				if(areEqual(node, subtreeRoot)) {
					return true;
				}
			}
			
			if(node.left != null) {
				nodeQ.add(node.left);
			}
			
			if(node.right != null) {
				nodeQ.add(node.right);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(26);
		bt.root.left = new Node(10);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(6);
		bt.root.left.right.left = new Node(30);
		bt.root.right.right = new Node(3);
		
		BinaryTree bt1 = new BinaryTree();
		bt1.root = new Node(10);
		bt1.root.left = new Node(4);
		bt1.root.right = new Node(6);
		bt1.root.right.left = new Node(30);
		
		System.out.println(isSubtree(bt.root, bt1.root));
	}

}
