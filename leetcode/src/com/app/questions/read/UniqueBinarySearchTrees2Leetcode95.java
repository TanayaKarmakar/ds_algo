package com.app.questions.read;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.app.questions.practice.BinaryTree.TreeNode;

public class UniqueBinarySearchTrees2Leetcode95 {
	private static void swap(int[] arr, int i1, int i2) {
		int tmp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = tmp;
	}
	
	private static TreeNode generateTree(int data, TreeNode root) {
		if(root == null) {
			root = new TreeNode(data);
			return root;
		} else if(data > root.data){
			root.right = generateTree(data, root.right);
		} else {
			root.left = generateTree(data, root.left);
		}
		return root;
	}
	
	private static void generatePerm(int[] arr, int n, Set<TreeNode> nodes) {
		if(n == 1) {
			TreeNode root = null;
			for(int i = 0; i < arr.length; i++) {
				root = generateTree(arr[i], root);
			}
			
			nodes.add(root);
			return;
		}
		for(int i = 0; i < n; i++) {
			swap(arr, i, n - 1);
			generatePerm(arr, n - 1, nodes);
			swap(arr, i, n - 1);
		}
	}
	
	private static void generatePermutation(int n, Set<TreeNode> nodes) {
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		generatePerm(arr, n, nodes);
	}
	
	public static List<TreeNode> generateTrees(int n) {
		Set<TreeNode> trees = new HashSet<>();
		generatePermutation(n, trees);
		return new ArrayList<>(trees);
	}
	
	private static void traverse(TreeNode root) {
		if(root != null) {
			traverse(root.left);
			System.out.print(root.data + " ");
			traverse(root.right);
		}
	}

	public static void main(String[] args) {
		int n = 3;
		List<TreeNode> nodes = generateTrees(n);
		
		for(TreeNode root: nodes) {
			traverse(root);
			System.out.println();
		}

	}

}
