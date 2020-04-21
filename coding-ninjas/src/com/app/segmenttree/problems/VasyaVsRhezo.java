package com.app.segmenttree.problems;

import java.util.Arrays;
import java.util.Scanner;

class Item1 {
	int indx;
	int aVal;
	int bVal;
	
	public String toString() {
		return aVal + " " + bVal + " " + indx;
	}
}

public class VasyaVsRhezo {

	private static void buildTree(int[] aVals, int[] bVals, Item1[] tree, int start, int end, int treeIndx) {
		if (start == end) {
			Item1 item = new Item1();
			item.aVal = aVals[start];
			item.bVal = bVals[start];
			item.indx = start;
			tree[treeIndx] = item;
			return;
		}
		int mid = start + (end - start) / 2;
		buildTree(aVals, bVals, tree, start, mid, 2 * treeIndx);
		buildTree(aVals, bVals, tree, mid + 1, end, 2 * treeIndx + 1);
		Item1 left = tree[2 * treeIndx];
		Item1 right = tree[2 * treeIndx + 1];
		Item1 finalNode = new Item1();
		int aVal = 0;
		int bVal = 0;
		int indx = 0;
		if (left.aVal > right.aVal) {
			aVal = left.aVal;
			bVal = left.bVal;
			indx = left.indx;
		} else if (left.aVal < right.aVal) {
			//finalNode = right;
			aVal = right.aVal;
			bVal = right.bVal;
			indx = right.indx;
		} else {
			if (left.bVal < right.bVal) {
				//finalNode = left;
				aVal = left.aVal;
				bVal = left.bVal;
				indx = left.indx;
			} else if (left.bVal > right.bVal) {
				//finalNode = right;
				aVal = right.aVal;
				bVal = right.bVal;
				indx = right.indx;
			} else {
				if (left.indx < right.indx) {
					//finalNode = left;
					aVal = left.aVal;
					bVal = left.bVal;
					indx = left.indx;
				} else {
					//finalNode = right;
					aVal = right.aVal;
					bVal = right.bVal;
					indx = right.indx;
				}
			}
		}
		finalNode.aVal = aVal;
		finalNode.bVal = bVal;
		finalNode.indx = indx;
		tree[treeIndx] = finalNode;
	}

	private static Item1 query(Item1[] tree, int start, int end, int l, int r, int treeIndx) {
		if (end < l || start > r) {
			Item1 item = new Item1();
			item.aVal = Integer.MIN_VALUE;
			item.bVal = Integer.MAX_VALUE;
			item.indx = tree.length + 1;
			return item;
		}
		if (start >= l && end <= r)
			return tree[treeIndx];

		int mid = start + (end - start) / 2;
		Item1 left = query(tree, start, mid, l, r, 2 * treeIndx);
		Item1 right = query(tree, mid + 1, end, l, r, 2 * treeIndx + 1);
		Item1 finalNode = new Item1();
		int aVal = 0;
		int bVal = 0;
		int indx = 0;
		if (left.aVal > right.aVal) {
			aVal = left.aVal;
			bVal = left.bVal;
			indx = left.indx;
		} else if (left.aVal < right.aVal) {
			//finalNode = right;
			aVal = right.aVal;
			bVal = right.bVal;
			indx = right.indx;
		} else {
			if (left.bVal < right.bVal) {
				//finalNode = left;
				aVal = left.aVal;
				bVal = left.bVal;
				indx = left.indx;
			} else if (left.bVal > right.bVal) {
				//finalNode = right;
				aVal = right.aVal;
				bVal = right.bVal;
				indx = right.indx;
			} else {
				if (left.indx < right.indx) {
					//finalNode = left;
					aVal = left.aVal;
					bVal = left.bVal;
					indx = left.indx;
				} else {
					//finalNode = right;
					aVal = right.aVal;
					bVal = right.bVal;
					indx = right.indx;
				}
			}
		}
		finalNode.aVal = aVal;
		finalNode.bVal = bVal;
		finalNode.indx = indx;
		return finalNode;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int len = scanner.nextInt();
		int[] aVals = new int[len];
		int[] bVals = new int[len];

		for (int i = 0; i < len; i++) {
			aVals[i] = scanner.nextInt();
		}

		for (int i = 0; i < len; i++) {
			bVals[i] = scanner.nextInt();
		}

		Item1[] tree = new Item1[4 * len];
		buildTree(aVals, bVals, tree, 0, len - 1, 1);
		//System.out.println(Arrays.toString(tree));

		int nQueries = scanner.nextInt();
		while (nQueries > 0) {
			int left = scanner.nextInt();
			int right = scanner.nextInt();
			Item1 finalNode = query(tree, 0, len - 1, left - 1, right - 1, 1);
			System.out.println(finalNode.indx + 1);
			nQueries--;
		}
		scanner.close();
	}

}
