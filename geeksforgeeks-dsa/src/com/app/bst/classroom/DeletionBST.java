package com.app.bst.classroom;

import java.util.LinkedList;
import java.util.Queue;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class DeletionBST {
	private static Node getSuccessor(Node root) {
		Node curr = root.right;
		while(curr != null && curr.left != null)
			curr = curr.left;
		return curr;
	}
	
	private static Node deleteNode(Node root, int data) {
		if(root == null)
			return null;
		else if(root.data > data)
			root.left = deleteNode(root.left, data);
		else if(root.data < data)
			root.right = deleteNode(root.right, data);
		else {
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			else {
				Node succ = getSuccessor(root);
				root.data = succ.data;
				Node del = deleteNode(root.right, succ.data);
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

	private static Node insertNode(Node root, int x) {
		if (root == null)
			return new Node(x);
		else if (root.data < x) {
			root.right = insertNode(root.right, x);
		} else {
			root.left = insertNode(root.left, x);
		}
		return root;
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		int[] nodes = { 50, 70, 30, 80, 20, 40, 60 };
		for (Integer node : nodes) {
			bt.root = insertNode(bt.root, node);
		}

		System.out.println("Inorder Traversal ");
		//inorderTraversal(bt.root);
		System.out.println();

		System.out.println("Before deletion, the tree is ");
		levelOrderTraversalLineByLine(bt.root);

		System.out.println("****************************");
		System.out.println("Delete 40");
		bt.root = deleteNode(bt.root, 40);

		System.out.println("After deletion, the tree is ");
		levelOrderTraversalLineByLine(bt.root);

		System.out.println("****************************");
		System.out.println("Delete 30");
		bt.root = deleteNode(bt.root, 30);

		System.out.println("After deletion, the tree is ");
		levelOrderTraversalLineByLine(bt.root);

		System.out.println("****************************");
		System.out.println("Delete 50");
		bt.root = deleteNode(bt.root, 50);

		System.out.println("After deletion, the tree is ");
		levelOrderTraversalLineByLine(bt.root);

		System.out.println("****************************");
		System.out.println("Delete 90");
		bt.root = deleteNode(bt.root, 90);

		System.out.println("After deletion, the tree is ");
		levelOrderTraversalLineByLine(bt.root);

	}

}
