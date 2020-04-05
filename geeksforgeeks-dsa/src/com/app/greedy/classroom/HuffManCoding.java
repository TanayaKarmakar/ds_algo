package com.app.greedy.classroom;

import java.util.PriorityQueue;

class HuffmanNode implements Comparable<HuffmanNode> {
	int data;
	char ch;

	HuffmanNode left;
	HuffmanNode right;

	public HuffmanNode(int data, char ch) {
		this.data = data;
		this.ch = ch;
		this.left = null;
		this.right = null;
	}

	@Override
	public int compareTo(HuffmanNode o) {
		return this.data - o.data;
	}
}

public class HuffManCoding {
	private static HuffmanNode buildTree(char[] chars, int[] freq) {
		int n = chars.length;

		PriorityQueue<HuffmanNode> pQ = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			HuffmanNode node = new HuffmanNode(freq[i], chars[i]);
			pQ.add(node);
		}

		while (pQ.size() > 1) {
			HuffmanNode x = pQ.poll();
			HuffmanNode y = pQ.poll();

			int data = x.data + y.data;
			HuffmanNode currentRoot = new HuffmanNode(data, '-');
			currentRoot.left = x;
			currentRoot.right = y;

			pQ.add(currentRoot);
		}
		return pQ.poll();
	}

	private static void printTree(HuffmanNode node, String str) {
		if (node.left == null && node.right == null && Character.isLetter(node.ch)) {
			System.out.println(node.ch + ":" + str);
			return;
		}
		printTree(node.left, str + "0");
		printTree(node.right, str + "1");
	}

	public static void main(String[] args) {
		char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] freq = { 5, 9, 12, 13, 16, 45 };

		HuffmanNode node = buildTree(chars, freq);
		printTree(node, "");
	}

}
