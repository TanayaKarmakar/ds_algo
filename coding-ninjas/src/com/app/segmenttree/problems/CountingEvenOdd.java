package com.app.segmenttree.problems;

import java.util.Scanner;

class Item {
	int evenCount;
	int oddCount;
}

public class CountingEvenOdd {
	private static void buildTree(int[] nums, Item[] tree, int start, int end, int treeIndx) {
		if (start == end) {
			Item item = new Item();
			if (nums[start] % 2 == 0) {
				item.evenCount = 1;
				item.oddCount = 0;
			} else {
				item.evenCount = 0;
				item.oddCount = 1;
			}
			tree[treeIndx] = item;
			return;
		}
		int mid = start + (end - start) / 2;
		buildTree(nums, tree, start, mid, 2 * treeIndx);
		buildTree(nums, tree, mid + 1, end, 2 * treeIndx + 1);
		Item left = tree[2 * treeIndx];
		Item right = tree[2 * treeIndx + 1];
		Item finalItem = new Item();
		finalItem.evenCount = left.evenCount + right.evenCount;
		finalItem.oddCount = left.oddCount + right.oddCount;
		tree[treeIndx] = finalItem;
		return;
	}

	private static void updateTree(int[] nums, Item[] tree, int start, int end, int treeIndx, int indx, int value) {
		if (start == end) {
			if(start == indx) {
				nums[indx] = value;
				System.out.println(treeIndx);
				if(value % 2 == 0) {
					tree[treeIndx].evenCount = 1;
					tree[treeIndx].oddCount = 0;
				} else {
					tree[treeIndx].evenCount = 0;
					tree[treeIndx].oddCount = 1;
				}
			}
			
			return;
		}
		int mid = start + (end - start) / 2;
		if (indx <= mid) {
			updateTree(nums, tree, start, mid, 2 * treeIndx, indx, value);
		} else {
			updateTree(nums, tree, mid + 1, end, 2 * treeIndx + 1, indx, value);
		}
		
		Item left = tree[2 * treeIndx];
		Item right = tree[2 * treeIndx + 1];
		Item finalNode = new Item();
		finalNode.evenCount = left.evenCount + right.evenCount;
		finalNode.oddCount = left.oddCount + right.oddCount;
		tree[treeIndx] = finalNode;
	}

	private static Item query(Item[] tree, int start, int end, int left, int right, int treeIndx) {
		if (end < left || start > right) {
			Item nullItem = new Item();
			nullItem.evenCount = 0;
			nullItem.oddCount = 0;
			return nullItem;
		}
		if (start >= left && end <= right) {
			return tree[treeIndx];
		}

		int mid = start + (end - start) / 2;
		Item ans1 = query(tree, start, mid, left, right, 2 * treeIndx);
		Item ans2 = query(tree, mid + 1, end, left, right, 2 * treeIndx + 1);
		Item finalItem = new Item();
		finalItem.evenCount = ans1.evenCount + ans2.evenCount;
		finalItem.oddCount = ans1.oddCount + ans2.oddCount;
		return finalItem;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDim = scanner.nextInt();
		int[] nums = new int[nDim];

		for (int i = 0; i < nDim; i++) {
			nums[i] = scanner.nextInt();
		}

		Item[] tree = new Item[4 * nDim];

		buildTree(nums, tree, 0, nDim - 1, 1);

		int nQueries = scanner.nextInt();
		while (nQueries > 0) {
			int queryType = scanner.nextInt();
			int first = scanner.nextInt();
			int second = scanner.nextInt();

			if (queryType == 0) {
				// update index x with value y
				updateTree(nums, tree, 0, nDim - 1, 1, first - 1, second);
			}
			if (queryType == 1) {
				// count even numbers from l to r
				Item ans = query(tree, 0, nDim - 1, first - 1, second - 1, 1);
				System.out.println(ans.evenCount);
			}
			if (queryType == 2) {
				// count odd numbers from l to r
				Item ans = query(tree, 0, nDim - 1, first - 1, second - 1, 1);
				System.out.println(ans.oddCount);
			}
			nQueries--;
		}

		scanner.close();
	}

}
