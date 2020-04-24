package com.app.segmenttree.problems;

import java.util.Scanner;

public class HorribleQueries {
	private static long getSum(long[] tree, long[] lazy, int start, int end, int left, int right, int treeIndx) {
		if(end < left || start > right)
			return 0;
		if(lazy[treeIndx] != 0) {
			tree[treeIndx] += (end - start + 1) * lazy[treeIndx];
			if(start != end) {
				lazy[2 * treeIndx] += lazy[treeIndx];
				lazy[2 * treeIndx + 1] += lazy[treeIndx];
			}
			lazy[treeIndx] = 0;
		}
		if(start >= left && end <= right)
			return tree[treeIndx];
		int mid = start + (end - start)/2;
		long ans1 = getSum(tree, lazy, start, mid, left, right, 2 * treeIndx);
		long ans2 = getSum(tree, lazy,  mid + 1, end, left, right, 2 * treeIndx + 1);
		return ans1 + ans2;
	}
		
	private static void update(long[] nums, long[] tree, long[] lazy, int start, int end, int left, int right,
			long value, int treeIndx) {
		if (lazy[treeIndx] != 0) {
			tree[treeIndx] += (end - start + 1) *lazy[treeIndx];
			if (start != end) {
				lazy[2 * treeIndx] += lazy[treeIndx];
				lazy[2 * treeIndx + 1] += lazy[treeIndx];
			}
			lazy[treeIndx] = 0;
		}
		if(end < left || start > right)
			return;
		if (start >= left && end <= right) {
			tree[treeIndx] += (end - start + 1) * value;
			if (start != end) {
				lazy[2 * treeIndx] += value;
				lazy[2 * treeIndx + 1] += value;
			}
			return;
		}

		int mid = start + (end - start) / 2;
		update(nums, tree, lazy, start, mid, left, right, value, 2 * treeIndx);
		update(nums, tree, lazy, mid + 1, end, left, right, value, 2 * treeIndx + 1);
		tree[treeIndx] = tree[2 * treeIndx] + tree[2 * treeIndx + 1];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		while (nTestCases > 0) {
			int nDim = scanner.nextInt();
			int nQueries = scanner.nextInt();

			long[] nums = new long[nDim];
			long[] tree = new long[4 * nDim];
			long[] lazy = new long[4 * nDim];
			while (nQueries > 0) {
				int queryType = scanner.nextInt();
				int first = scanner.nextInt();
				int second = scanner.nextInt();
				long third = 0;
				if (queryType == 0) {
					third = scanner.nextLong();
					update(nums, tree, lazy, 0, nDim - 1, first - 1, second - 1, third, 1);
				} else {
					long ans = getSum(tree, lazy, 0, nDim - 1, first - 1, second - 1, 1);
					System.out.println(ans);
				}

				nQueries--;
			}

			nTestCases--;
		}
		scanner.close();

	}

}
