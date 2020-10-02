package com.app.practice.tree;

import java.util.ArrayList;
import java.util.List;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class AllElementsInTwoBinarySearchTreeLeetcode1305 {
	private static void inorderTraversal(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		inorderTraversal(root.left, list);
		list.add(root.val);
		inorderTraversal(root.right, list);
	}

	private static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> tmp1 = new ArrayList<>();
		List<Integer> tmp2 = new ArrayList<>();

		inorderTraversal(root1, tmp1);
		inorderTraversal(root2, tmp2);

		int i = 0;
		int j = 0;
		int m = tmp1.size();
		int n = tmp2.size();
		List<Integer> res = new ArrayList<>();

		while (i < m && j < n) {
			if (tmp1.get(i) < tmp2.get(j)) {
				res.add(tmp1.get(i));
				i++;
			} else {
				res.add(tmp2.get(j));
				j++;
			}
		}

		while (i < m) {
			res.add(tmp1.get(i));
			i++;
		}

		while (j < n) {
			res.add(tmp2.get(j));
			j++;
		}
		
		return res;
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
		
		List<Integer> res = getAllElements(bt1.root, bt2.root);
		
		System.out.println(res);

	}

}
