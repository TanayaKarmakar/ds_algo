package com.app.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.app.tree.BinaryTree.TreeNode;

class VNode {
	int num;
	TreeNode node;
	
	public VNode(int num, TreeNode node) {
		this.num = num;
		this.node = node;
	}
}

public class SumRootToLeafPathsInABinaryTree {
	private static int sumRootToLeafPath(TreeNode root) {
		Queue<VNode> q = new LinkedList<>();
		q.add(new VNode(root.val, root));
		
		int sum = 0;
		while(!q.isEmpty()) {
			VNode vNode = q.poll();
			
			TreeNode currNode = vNode.node;
			int num = vNode.num;
			
			if(currNode.left == null && currNode.right == null) {
				sum += num;
				System.out.print(num + " ");
				continue;
			}
			
			if(currNode.left != null) {
				int newNum = num * 10 + currNode.left.val;
				q.add(new VNode(newNum, currNode.left));
			}
			
			if(currNode.right != null) {
				int newNum = num * 10 + currNode.right.val;
				q.add(new VNode(newNum, currNode.right));
			}
		}
		System.out.println();
		
		return sum;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(0);
		bt.root.right = new TreeNode(0);
		bt.root.left.left = new TreeNode(0);
		bt.root.left.right = new TreeNode(1);
		bt.root.left.left.left = new TreeNode(0);
		bt.root.left.left.right = new TreeNode(1);
		bt.root.left.right.right = new TreeNode(1);
		bt.root.left.right.right.left = new TreeNode(0);
		bt.root.right.left = new TreeNode(0);
		bt.root.right.right = new TreeNode(0);
		bt.root.right.left.right = new TreeNode(0);
		bt.root.right.left.right.left = new TreeNode(1);
		bt.root.right.left.right.right = new TreeNode(0);
		bt.root.right.left.right.left.right = new TreeNode(1);
		bt.root.right.right.right = new TreeNode(0);
		
		int ans = sumRootToLeafPath(bt.root);
		
		System.out.println(ans);

	}

}
