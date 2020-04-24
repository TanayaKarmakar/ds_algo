package com.app.segmenttree.problems;

import java.util.Scanner;

public class TwoVsThree {
	private static int[] power;
	
	private static void buildTree(String str, int[] tree, int start, int end, int treeIndx) {
		if (start == end) {
			char ch = str.charAt(start);
			tree[treeIndx] = (ch - '0') * (int)(Math.pow(2, 0));
			tree[treeIndx] = tree[treeIndx] % 3;
			return;
		}
		int mid = start + (end - start) / 2;

		buildTree(str, tree, start, mid, 2 * treeIndx);
		buildTree(str, tree, mid + 1, end, 2 * treeIndx + 1);
		int term = power[end - mid] % 3;
		tree[treeIndx] = ((tree[2 * treeIndx] * term)% 3 + tree[2 * treeIndx + 1]) % 3;
		return;
	}

	private static int query(int[] tree, int start, int end, int left, int right, int treeIndx) {
		if (end < left || start > right)
			return 0;
		if (start >= left && end <= right) {
            int term = power[right - end];
            return term*tree[treeIndx];
        }
			//return tree[treeIndx];

		int mid = start + (end - start) / 2;
		int leftChild = query(tree, start, mid, left, right, 2 * treeIndx);
		int rightChild = query(tree, mid + 1, end, left, right, 2 * treeIndx + 1);
        return (leftChild + rightChild) % 3;
	}
	
	private static void updateTree(String str, int[] tree, int start, int end, int indx, int treeIndx) {
		if(start == end) {
			if(str.charAt(indx) == '0') {
				char[] ch = str.toCharArray();
				ch[indx] = '1';
				tree[treeIndx] = 1;
				str = String.valueOf(ch);
			}
			return;
		}
		int mid = start + (end - start)/2;
		if(mid >= indx)
			updateTree(str, tree, start, mid, indx, 2 * treeIndx);
		else
			updateTree(str, tree, mid + 1, end, indx, 2 * treeIndx + 1);
		int term = power[end - mid];
		tree[treeIndx] = ((tree[2 * treeIndx] * term)% 3 + tree[2 * treeIndx + 1]) % 3;
	}
	
	private static void precomputePower() {
		power = new int[1000001];
		
		power[0] = 1;
		for(int i = 1; i <= 100000; i++) {
			power[i] = (power[i - 1] * 2) % 3;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int len = scanner.nextInt();

		String str = scanner.next();

		int[] tree = new int[4 * len];
		
		precomputePower();

		buildTree(str, tree, 0, len - 1, 1);

		int nQueries = scanner.nextInt();

		while (nQueries > 0) {
			int queryType = scanner.nextInt();

			int first = scanner.nextInt();

			int second = 0;

			if (queryType == 0) {
				second = scanner.nextInt();

				int ans = query(tree, 0, len - 1, first, second, 1);
				
				System.out.println(ans);
			} else {
				updateTree(str, tree, 0, len - 1, first, 1);
			}
			nQueries--;
		}

		scanner.close();

	}

}
