package com.app.questions.greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabelLeetcode763 {
	private static List<Integer> partitionLabels(String S) {
		int[] lastIndxArr = new int[26];
		int n = S.length();

		for (int i = 0; i < n; i++) {
			int charVal = S.charAt(i) - 'a';
			lastIndxArr[charVal] = i + 1;
		}

		List<Integer> res = new ArrayList<>();
		int start = 0;
		int finish = 1;

		while (finish <= n) {
			for (int i = start; i < finish; i++) {
				int charVal = S.charAt(i) - 'a';
				if (lastIndxArr[charVal] > finish) {
					finish = lastIndxArr[charVal];
				}
			}

			res.add(finish - start);
			start = finish;
			finish++;
		}
		
		return res;
	}

	public static void main(String[] args) {
		String str = "ababcbacadefegdehijhklij";

		List<Integer> res = partitionLabels(str);

		System.out.println(res);

	}

}
