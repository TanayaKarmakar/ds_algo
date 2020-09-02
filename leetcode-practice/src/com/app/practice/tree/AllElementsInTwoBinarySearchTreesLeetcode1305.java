package com.app.practice.tree;

import java.util.ArrayList;
import java.util.List;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class AllElementsInTwoBinarySearchTreesLeetcode1305 {
	private static void getElements(TreeNode root, List<Integer> elements) {
		if(root != null) {
			getElements(root.left, elements);
			elements.add(root.val);
			getElements(root.right, elements);
		}
	}
	
	private static List<Integer> merge(List<Integer> el1, List<Integer> el2) {
		int m = el1.size();
		int n = el2.size();
		
		
		List<Integer> result = new ArrayList<>();
		int i = 0;
		int j = 0;
		while(i < m && j < n) {
			if(el1.get(i) <= el2.get(j)) {
				result.add(el1.get(i));
				i++;
			} else {
				result.add(el2.get(j));
				j++;
			}
		}
		
		while(i < m) {
			result.add(el1.get(i));
			i++;
		}
		
		while(j < n) {
			result.add(el2.get(j));
			j++;
		}
		
		return result;
	}
	
	private static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> elements1 = new ArrayList<>();
		getElements(root1, elements1);
		
		List<Integer> elements2 = new ArrayList<>();
		getElements(root2, elements2);
		
		return merge(elements1, elements2);
	}

	public static void main(String[] args) {
		BinaryTree bt1 = new BinaryTree();
		bt1.root = new TreeNode(2);
		bt1.root.left = new TreeNode(1);
		bt1.root.right = new TreeNode(4);
		
		BinaryTree bt2 = new BinaryTree();
		bt2.root = new TreeNode(1);
		bt2.root.left = new TreeNode(0);
		bt2.root.right = new TreeNode(3);
		
		List<Integer> result = getAllElements(bt1.root, bt2.root);
		
		System.out.println(result);
	}

}
