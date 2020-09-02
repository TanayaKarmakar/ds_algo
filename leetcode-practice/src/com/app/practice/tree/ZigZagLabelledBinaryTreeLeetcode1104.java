package com.app.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZigZagLabelledBinaryTreeLeetcode1104 {
	private static List<Integer> pathInZigzagBinaryTree(int label) {
		int level = (int) (Math.log(label) / Math.log(2)) + 1;
		int size = (int) Math.pow(2, level);
		int[] arr = new int[size];

		int indx = 1;
		int start = 0;
		for(int h = 0; h < level; h++) {
			int total = (int)Math.pow(2, h);
			if(h % 2 != 0) {
				//copy in reverse
				for(int j = (start + total - 1); j >= start; j--) {
					arr[j] = indx++;
				}
			} else {
				for(int j = start; j < (start + total); j++) {
					arr[j] = indx++;
				}
			}
			start = start + total;
		}
		
		List<Integer> res = new ArrayList<>();
		start = size - 1;
		while(arr[start] != label)
			start--;
		
		while(start > 0) {
			res.add(0, arr[start]);
			start = (start - 1) / 2;
		}
		
		res.add(0, arr[0]);
		
		return res;
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int label = scanner.nextInt();
		
		List<Integer> res = pathInZigzagBinaryTree(label);
		
		System.out.println(res);
		
		scanner.close();
	}

}
