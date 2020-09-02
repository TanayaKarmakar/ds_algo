package com.app.practice.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintInZigzagLabelledBinaryTreeLeetcode1104 {
	private static List<Integer> pathInZigZagTree(int label) {
		int level = (int) (Math.log10(label) / Math.log10(2)) + 1;
		int size = (int)Math.pow(2, level);
		int[] arr = new int[size];

		int val = 1;
		int start = 0;
		int end = 0;

		for (int i = 0; i < level; i++) {
			int totalEls = (int) Math.pow(2, i);
			end = start + totalEls;

			if (i % 2 == 0) {
				for (int j = start; j < end; j++) {
					arr[j] = val++;
				}
			} else {
				for (int j = end - 1; j >= start; j--) {
					arr[j] = val++;
				}
			}
			
			start = end;
		}

		List<Integer> res = new ArrayList<>();
		int indx = 0;
		for (int i = size - 1; i >= 0; i--) {
			if (arr[i] == label) {
				indx = i;
				break;
			}
		}

		while (indx > 0) {
			res.add(0, arr[indx]);
			indx = (indx - 1) / 2;
		}
		res.add(0, arr[0]);

		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int label = scanner.nextInt();
		
		List<Integer> res = pathInZigZagTree(label);
		
		System.out.println(res);
		
		scanner.close();
	}

}
