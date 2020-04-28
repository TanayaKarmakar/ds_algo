package com.app.segmenttree.problems;

import java.util.Scanner;

class Pair {
	int first;
	int second;
	
	public Pair() {
		this.first = 0;
		this.second = 0;
	}
}

public class SumOfSquares {

	private static void buildTree(int[] nums, Pair[] tree, int start, int end, int treeIndx) {
		if (start == end) {
			Pair node = new Pair();
			node.second = nums[start];
			node.first = nums[start] * nums[start];
			tree[treeIndx] = node;
			return;
		}

		int mid = start + (end - start) / 2;
		buildTree(nums, tree, start, mid, 2 * treeIndx);
		buildTree(nums, tree, mid + 1, end, 2 * treeIndx + 1);
		Pair newNode = new Pair();
		newNode.first = tree[2 * treeIndx].first + tree[2 * treeIndx + 1].first;
		newNode.second = tree[2 * treeIndx].second + tree[2 * treeIndx + 1].second;
		tree[treeIndx] = newNode;
		return;
	}

	private static long getSumOfSquares(Pair[] tree, Pair[] lazy, int si, int ei, int left, int right, int node) {
		if (lazy[node] != null && lazy[node].first != 0) {
			if (lazy[node].second != 2) {
				tree[node].first = tree[node].first + (2 * lazy[node].first * tree[node].second)
						+ ((ei - si + 1) * lazy[node].first * lazy[node].first);
				tree[node].second += (ei - si + 1) * lazy[node].first;

				if (si != ei) {
					lazy[2 * node].first += lazy[node].first;
					lazy[2 * node + 1].first += lazy[node].first;
				}

				lazy[node].first = 0;
				lazy[node].second = 0;
			}

			else {
				tree[node].first = (ei - si + 1) * lazy[node].first * lazy[node].first;
				tree[node].second = (ei - si + 1) * lazy[node].first;
				if (si != ei) {
					lazy[2 * node].second = 2;
					lazy[2 * node + 1].second = 2;
					lazy[2 * node].first = lazy[node].first;
					lazy[2 * node + 1].first = lazy[node].first;
				}
				lazy[node].first = 0;
				lazy[node].second = 0;
			}
		}
		if (si > right || ei < left)
			return 0;
		if (si >= left && ei <= right)
			return tree[node].first;
		int mid = (si + ei) / 2;
		long ans1 = getSumOfSquares(tree, lazy, si, mid, 2 * node, left, right);
		long ans2 = getSumOfSquares(tree, lazy, mid + 1, ei, 2 * node + 1, left, right);
		return ans1 + ans2;
	}

	private static void update(Pair[] tree, Pair[] lazy, int start, int end, int left, int right, int treeIndx,
			int value, int type) {
		if (start > end)
			return;
		if (lazy[treeIndx] != null && lazy[treeIndx].first != 0) {
			if (lazy[treeIndx].second != 2) {
				tree[treeIndx].first += (2 * lazy[treeIndx].first * tree[treeIndx].second)
						+ ((end - start + 1) * lazy[treeIndx].first * lazy[treeIndx].first);
				tree[treeIndx].second += (end - start + 1) * lazy[treeIndx].first;

				if (start != end) {
					lazy[2 * treeIndx].first += lazy[treeIndx].first;
					lazy[2 * treeIndx + 1].first += lazy[treeIndx].first;
				}

				lazy[treeIndx].first = 0;
				lazy[treeIndx].second = 0;
			} else {
				tree[treeIndx].first = (end - start + 1) * lazy[treeIndx].first * lazy[treeIndx].first;
				tree[treeIndx].second = (end - start + 1) * lazy[treeIndx].first;
				if (start != end) {
					lazy[2 * treeIndx].second = 2;
					lazy[2 * treeIndx + 1].second = 2;
					lazy[2 * treeIndx].first = lazy[treeIndx].first;
					lazy[2 * treeIndx + 1].first = lazy[treeIndx].first;
				}
				lazy[treeIndx].first = 0;
				lazy[treeIndx].second = 0;
			}
		}
		if (start > right || end < left)
			return;
		if (start >= left && end <= right) {
			if (type == 1) {
				tree[treeIndx].first = tree[treeIndx].first + (2 * value * tree[treeIndx].second)
						+ ((end - start + 1) * value * value);
				tree[treeIndx].second += (end - start + 1) * value;

				if (start != end) {
					lazy[2 * treeIndx].first += lazy[treeIndx].first;
					lazy[2 * treeIndx + 1].first += lazy[treeIndx].first;
				}
				return;
			} else {
				tree[treeIndx].first = (end - start + 1) * value * value;
				tree[treeIndx].second = (end - start + 1) * value;
				if (start != end) {
					lazy[2 * treeIndx].second = 2;
					lazy[2 * treeIndx + 1].second = 2;
					lazy[2 * treeIndx].first = value;
					lazy[2 * treeIndx + 1].first = value;
				}
				return;
			}
		}
		int mid = (start + end) / 2;
		update(tree, lazy, start, mid, 2 * treeIndx, left, right, type, value);
		update(tree, lazy, mid + 1, end, 2 * treeIndx + 1, left, right, type, value);
		tree[treeIndx].first = tree[2 * treeIndx].first + tree[2 * treeIndx + 1].first;
		tree[treeIndx].second = tree[2 * treeIndx].second + tree[2 * treeIndx + 1].second;
		return;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		int j = 1;
		while (j <= nTestCases) {
			int nDim = scanner.nextInt();
			int nQueries = scanner.nextInt();

			int[] nums = new int[nDim];
			for (int i = 0; i < nDim; i++) {
				nums[i] = scanner.nextInt();
			}

			Pair[] tree = new Pair[4 * nDim];
			Pair[] lazy = new Pair[4 * nDim];
			for(int i = 0; i < (4 * nDim); i++) {
				tree[i] = new Pair();
				lazy[i] = new Pair();
			}
			
			buildTree(nums, tree, 0, nDim - 1, 1);

			System.out.println("Case " + j + ":");

			while (nQueries > 0) {
				int queryType = scanner.nextInt();
				int left = scanner.nextInt();
				int right = scanner.nextInt();
				if (queryType == 0 || queryType == 1) {
					int num = scanner.nextInt();
					if (queryType == 0) {
						// set x to all the numbers within the range
						update(tree, lazy, 0, nDim - 1, left - 1, right - 1, 1, num, 2);
					}
					if (queryType == 1) {
						// add x to all numbers within the range
						update(tree, lazy, 0, nDim - 1, left - 1, right - 1, 1, num, 1);
					}
				}

				if (queryType == 2) {
					// returns sum of squres all the numbers within that range
					long ans = getSumOfSquares(tree, lazy, 0, nDim - 1, left - 1, right - 1, 1);
					System.out.println(ans);
				}
				nQueries--;
			}

			j++;
		}
		scanner.close();

	}

}
