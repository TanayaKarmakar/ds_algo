package com.app.questions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningLeetcode131 {
	private static void partitionRec(String s, List<String> partition, List<List<String>> partitions) {
		if (s == null || s.isEmpty()) {
			List<String> newList = new ArrayList<>();
			for (String str : partition) {
				newList.add(str);
			}
			partitions.add(newList);
			return;
		}

		for (int i = 1; i <= s.length(); i++) {
			String part1 = s.substring(0, i);
			String part2 = s.substring(i);
			if (isPalindrome(part1)) {
				partition.add(part1);
				partitionRec(part2, partition, partitions);
				partition.remove(partition.size() - 1);
			}
		}
	}

	private static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}

	private static List<List<String>> partition(String s) {
		if (s == null || s.isEmpty())
			return new ArrayList<>();
		List<String> partition = new ArrayList<>();
		List<List<String>> partitions = new ArrayList<>();
		partitionRec(s, partition, partitions);
		return partitions;
	}

	public static void main(String[] args) {
		String s = "radar";

		List<List<String>> res = partition(s);

		System.out.println(res);

	}

}
