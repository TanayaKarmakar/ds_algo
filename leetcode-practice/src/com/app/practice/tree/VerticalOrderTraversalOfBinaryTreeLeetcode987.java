package com.app.practice.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

class VItem implements Comparable<VItem> {
	TreeNode node;
	int pos;
	int level;

	public VItem(TreeNode node, int pos, int level) {
		this.node = node;
		this.pos = pos;
		this.level = level;
	}

	@Override
	public int compareTo(VItem o) {
		if(this.level == o.level) 
			return this.node.val - o.node.val;
		return this.level - o.level;
	}	
}

public class VerticalOrderTraversalOfBinaryTreeLeetcode987 {
	private static List<List<Integer>> verticalTraversal(TreeNode root) {
		Queue<VItem> q = new LinkedList<>();
		q.add(new VItem(root, 0, 0));
		TreeMap<Integer, List<VItem>> tMap = new TreeMap<>();
		
		while(!q.isEmpty()) {
			VItem vItem = q.poll();
			TreeNode node = vItem.node;
			int level = vItem.level;
			int pos = vItem.pos;
			
			if(!tMap.containsKey(pos)) {
				tMap.put(pos, new ArrayList<>());
			}
			tMap.get(pos).add(vItem);
			
			if(node.left != null) {
				q.add(new VItem(node.left, pos - 1, level + 1));
			}
			
			if(node.right != null) {
				q.add(new VItem(node.right, pos + 1, level + 1));
			}
		}
		
		List<List<Integer>> res = new ArrayList<>();
		for(Map.Entry<Integer, List<VItem>> entry: tMap.entrySet()) {
			Collections.sort(entry.getValue());
			List<Integer> item = new ArrayList<>();
			for(VItem vItem: entry.getValue()) {
				item.add(vItem.node.val);
			}
			res.add(item);
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
