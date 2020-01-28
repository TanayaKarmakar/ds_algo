package com.app.questions;

import java.util.ArrayList;
import java.util.List;

import com.app.questions.BinaryTree.Node;

public class ValidateBST {
	private static boolean checkBST(Node root, int min, int max) {
		if(root.data > min && root.data < max) {
			boolean leftTree = true;
			boolean rightTree = true;
			
			if(root.left != null)
				leftTree = checkBST(root.left, min, root.data);
			
			if(root.right != null)
				rightTree = checkBST(root.right, root.data, max);
			
			return leftTree && rightTree;
		}
		return false;
	}
	private static boolean isValidBSTEfficient(Node root) {
		if(root == null)
			return true;
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static void getInorder(Node root, List<Integer> nodeList) {
		if(root != null) {
			getInorder(root.left, nodeList);
			nodeList.add(root.data);
			getInorder(root.right, nodeList);
		}
	}
	
	private static boolean isValidBST(Node root) {
		List<Integer> res = new ArrayList<>();
		getInorder(root, res);
		for(int i = 1;i<res.size();i++) {
			if(res.get(i - 1) >= res.get(i))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		
		System.out.println(isValidBST(bt.root));
		System.out.println("Efficient - " + 
		isValidBSTEfficient(bt.root));
		
		bt.root = new Node(10);
		bt.root.left = new Node(2);
		bt.root.right = new Node(13);
		
		System.out.println(isValidBST(bt.root));
		System.out.println("Efficient - " + 
				isValidBSTEfficient(bt.root));
		
		bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(2);
		
		System.out.println(isValidBST(bt.root));
		System.out.println("Efficient - " + 
				isValidBSTEfficient(bt.root));
		
		bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(12);
		
		System.out.println(isValidBST(bt.root));
		System.out.println("Efficient - " + 
				isValidBSTEfficient(bt.root));
		
		bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(5);
		bt.root.right = new Node(15);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(20);
		
		System.out.println(isValidBST(bt.root));
		System.out.println("Efficient - " + 
				isValidBSTEfficient(bt.root));
		
	}

}
