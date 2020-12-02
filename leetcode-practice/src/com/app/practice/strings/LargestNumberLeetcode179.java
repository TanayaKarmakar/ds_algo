package com.app.practice.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class StringComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		String option1 = o1 + o2;
		String option2 = o2 + o1;
		return option2.compareTo(option1);
	}

}

public class LargestNumberLeetcode179 {
	private static String largestNumber(int[] nums) {
		List<String> numsList = Arrays.stream(nums).mapToObj(String::valueOf)
				.collect(Collectors.toList());
		StringBuilder sb = new StringBuilder();
		
		Collections.sort(numsList, new StringComparator());

		for (String el : numsList) {
			sb.append(el.toString());
		}

		int i = 0;
		String str = sb.toString();
		int n = str.length();
		
		StringBuilder sb1 = new StringBuilder();
		while(i < n && str.charAt(i) == '0') {
			i++;
		}
		
		sb1.append(str.substring(i));
		
		return str.length() != 0 && sb1.length() == 0 ? "0" : sb1.toString();
	}

	public static void main(String[] args) {
		int[] nums = { 3, 30, 34, 5, 9 };
		
		String ans = largestNumber(nums);
		
		System.out.println(ans);

	}

}
