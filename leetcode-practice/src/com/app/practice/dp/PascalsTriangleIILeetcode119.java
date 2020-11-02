package com.app.practice.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIILeetcode119 {
	private static List<Integer> getRow(int rowIndex) {
		List<List<Integer>> list = new ArrayList<>();
		
		for(int i = 0; i <= rowIndex; i++) {
			List<Integer> row = new ArrayList<>();
			for(int j = 0; j <= i; j++) {
				if(j == 0 || j == i) {
					row.add(1);
				} else {
					int sum = list.get(i - 1).get(j - 1) + list.get(i - 1).get(j);
					row.add(sum);
				}
			}
			list.add(row);
		}
		
		return list.get(rowIndex);
	}

	public static void main(String[] args) {
		int rowIndx = 1;
		
		List<Integer> ans = getRow(rowIndx);
		
		System.out.println(ans);

	}

}
