package com.app.questions;

import java.util.Queue;
import java.util.LinkedList;

import com.app.questions.BinaryTree.Node;

class PathValue {
	Node node;
	int sum;
	
	public PathValue(Node node, int sum) {
		this.node = node;
		this.sum = sum;
	}
}

public class PathSumLeetCode112 {
	private static boolean isLeaf(Node root) {
		return root.left == null && root.right == null;
	}
	
	private static boolean hasPathSum(Node root, int sum) {
		if(root == null)
			return false;
		if(isLeaf(root)) {
			if(root.data == sum)
				return true;
			else
				return false;
		}
		Queue<PathValue> q = new LinkedList<>();
		q.add(new PathValue(root, root.data));
		
		while(!q.isEmpty()) {
			PathValue currPath = q.poll();
			if(currPath.node.left != null) {
				int currSum = currPath.sum + currPath.node.left.data;
				if(currSum == sum && isLeaf(currPath.node.left)) {
					return true;
				}
				q.add(new PathValue(currPath.node.left, currSum));
			}
			
			if(currPath.node.right != null) {
				int currSum = currPath.sum + currPath.node.right.data;
				if(currSum == sum && isLeaf(currPath.node.right)) {
					return true;
				}
				q.add(new PathValue(currPath.node.right, currSum));
			}
		}
		return false;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(5);
		bt.root.left = new Node(4);
		bt.root.right = new Node(8);
		bt.root.left.left = new Node(11);
		bt.root.left.left.left = new Node(7);
		bt.root.left.left.right = new Node(2);
		bt.root.right.left = new Node(13);
		bt.root.right.right = new Node(4);
		bt.root.right.right.right = new Node(1);
		
		System.out.println(hasPathSum(bt.root, 22));
	}

}
