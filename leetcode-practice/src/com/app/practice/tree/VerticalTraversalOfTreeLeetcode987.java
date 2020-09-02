package com.app.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

class VerticalNode implements Comparable<VerticalNode> {
	TreeNode node;
	int column;
	int level;
	
	public VerticalNode(TreeNode node, int level, int column) {
		this.node = node;
		this.level = level;
		this.column = column;
	}

	@Override
	public int compareTo(VerticalNode o) {
		if(this.level == o.level)
			return this.node.val - o.node.val;
		return this.level - o.level;
	}	
}

public class VerticalTraversalOfTreeLeetcode987 {
	private static List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		
		PriorityQueue<VerticalNode> pQ = new PriorityQueue<>();
		
		pQ.add(new VerticalNode(root, 0, 0));
		
		while(!pQ.isEmpty()) {
			int size = pQ.size();
			for(int i = 0; i < size; i++) {
				VerticalNode vNode = pQ.poll();
				if(!map.containsKey(vNode.column)) {
					map.put(vNode.column, new ArrayList<>());
				}
				map.get(vNode.column).add(vNode.node.val);
				
				if(vNode.node.left != null) {
					pQ.add(new VerticalNode(vNode.node.left, vNode.level + 1, 
							vNode.column - 1));
				}
				
				if(vNode.node.right != null) {
					pQ.add(new VerticalNode(vNode.node.right, vNode.level + 1, 
							vNode.column + 1));
				}
			}
		}
		
		for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
			res.add(entry.getValue());
		}
		
		return res;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(9);
		bt.root.right = new TreeNode(20);
		bt.root.right.left = new TreeNode(15);
		bt.root.right.right = new TreeNode(7);
		
		List<List<Integer>> res = verticalTraversal(bt.root);
		
		System.out.println(res);
	}

}
