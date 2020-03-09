package com.app.questions;

import java.util.ArrayList;
import java.util.List;

public class PrintZigZagBinaryTree {
	private static int getLevel(int label) {
		return (int)(Math.log(label) / Math.log(2)) + 1;
	}

	private static List<Integer> printZigZagTree(int label) {
		List<Integer> res = new ArrayList<>();
		if(label == 1) {
			res.add(1);
			return res;
		}
		int level = getLevel(label);

		int size = (int) Math.pow(2, level) - 1;
		int[] items = new int[size];

		items[0] = 1;
		int start = 1;
		int numItems = 0;
		int indx = 1;
		while (start < level) {
			numItems = (int) Math.pow(2, start);
			int count = 0;
			if (start % 2 == 0) {
				int startElem = numItems;
				while (count < numItems) {
					items[indx++] = startElem++;
					count++;
				}
			} else {
				int startElem = 2 * numItems - 1;
				while (count < numItems) {
					items[indx++] = startElem--;
					count++;
				}
			}
			start++;
		}

		indx = -1;
		for (int i = size - 1; i >= 0; i--) {
			if(items[i] == label) {
				indx = i;
				break;
			}
		}
		
		res.add(label);
		while(indx > 0) {
			indx = (indx - 1)/2;
			res.add(0, items[indx]);
		}
		
		return res;
	}

	public static void main(String[] args) {
		int label = 14;
		//printZigZagTree(label);

		System.out.println(printZigZagTree(label));
		
		System.out.println(printZigZagTree(16));
	}

}
