package com.app.questions.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

import com.app.questions.practice.BinaryTree.TreeNode;

public class DeleteNodesAndReturnForestLeetcode1110 {
	private static void delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> nodes = new ArrayList<>();
		
		
		List<TreeNode> res = new ArrayList<>();
		for(int i = 0; i < to_delete.length; i++) {
			int item = to_delete[i];
			TreeNode parent = null;
			Queue<TreeNode> q = new LinkedList<>();
			
		}
	}

	public static void main(String[] args) {
		

	}

}
