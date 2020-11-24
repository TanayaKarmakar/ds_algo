package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

class AvgItem {
	double total;
	int count;

	public AvgItem(double total, int count) {
		this.total = total;
		this.count = count;
	}
}

public class MaximumAverageSubtreeLeetcode1120 {
	private static double maxAvg = Double.MAX_VALUE;
	
	private static AvgItem maximumAverageSubtreeRec(TreeNode root) {
		if(root == null) {
			return new AvgItem(0, 0);
		}
		AvgItem lAvg = maximumAverageSubtreeRec(root.left);
		AvgItem rAvg = maximumAverageSubtreeRec(root.right);
		
		double total = lAvg.total + rAvg.total + root.val;
		int count = lAvg.count + rAvg.count + 1;
		
		double option1 = 0;
		if(lAvg.count > 0) {
			option1 = lAvg.total / lAvg.count;
		}
		
		double option2 = 0;
		if(rAvg.count > 0) {
			option2 = rAvg.total / rAvg.count;
		}
		
		double currentAvg = Double.max(option1, Double.max(option2, total / count));
		maxAvg = Double.max(maxAvg, currentAvg);
		return new AvgItem(total, count);
	}

	private static double maximumAverageSubtree(TreeNode root) {
		if(root == null)
			return 0;
		maxAvg = Double.MIN_VALUE;
		maximumAverageSubtreeRec(root);
		return maxAvg;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(5);
		bt.root.left = new TreeNode(6);
		bt.root.right = new TreeNode(1);
		
		double ans = maximumAverageSubtree(bt.root);
		
		System.out.println(ans);

	}

}
