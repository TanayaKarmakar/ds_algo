package com.app.janchallenge2021;

import java.util.HashMap;
import java.util.Map;

import com.app.augustchallenge.BinaryTree.TreeNode;

public class FindClonedTargetOfBinaryTree {
	private static void populateMap(TreeNode original, TreeNode cloned, Map<TreeNode, TreeNode> map) {
		if(original != null) {
			map.put(original, cloned);
			populateMap(original.left, cloned.left, map);
			populateMap(original.right, cloned.right, map);
		}
	}

	
	private static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		if(original == null)
			return null;
		Map<TreeNode, TreeNode> map = new HashMap<>();
		populateMap(original, cloned, map);
		return map.get(target);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
