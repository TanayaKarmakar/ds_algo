package com.app.questions.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

import com.app.questions.tree.BinaryTree.Node;

public class RightViewOfBinaryTee {
	private static List<Integer> rightView(Node root) {
		if(root == null)
			return new ArrayList<>();
		
		List<Integer> res = new ArrayList<>();
		Queue<Node> nodeQ = new LinkedList<>();
		nodeQ.add(root);
		nodeQ.add(null);
		
		//res.add(root.data);
		
		while(nodeQ.size() > 1) {
			Node node = nodeQ.poll();
			if(node == null) {
				nodeQ.add(null);
				continue;
			}
			if(nodeQ.peek() == null)
				res.add(node.data);
			
			if(node.left != null) {
				nodeQ.add(node.left);
			}
			
			if(node.right != null) {
				nodeQ.add(node.right);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.right = new Node(5);
		bt.root.right.right = new Node(4);
		
		List<Integer> res = rightView(bt.root);
		System.out.println(res);

	}

}
